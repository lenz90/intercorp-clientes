package com.intercorp.lizardo.intercorpclientes.infrastructure.controller;

import com.intercorp.lizardo.intercorpclientes.application.create.ClienteCreateService;
import com.intercorp.lizardo.intercorpclientes.application.create.CrearClienteRequest;
import com.intercorp.lizardo.intercorpclientes.application.find.ClienteFindService;
import io.swagger.annotations.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/cliente/v1")
@Api(value = "Api para crear y obtener resultados valiosos de los clientes", tags = "ApiCliente")
public final class ClienteController {

    private ClienteCreateService createService;

    private ClienteFindService findService;

    public ClienteController(ClienteCreateService createService, ClienteFindService findService) {
        this.createService = createService;
        this.findService = findService;
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de los clientes", response = ResponseEntity.class)
    public Mono<ResponseEntity> crearCliente(@ApiParam @RequestBody @Valid RequestCrear request) {
        createService.crearCliente(new CrearClienteRequest(request.nombre(), request.apellido(),
                LocalDate.parse(request.fechaNacimiento(), DateTimeFormatter.ofPattern("dd-MM-yyyy")))).subscribe();
        return Mono.just(new ResponseEntity(HttpStatus.CREATED));
    }

    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtener la lista de clientes con su fecha aproximado de fallecer",
            response = ResponseDetail[].class)
    public Flux<ResponseDetail> findAll() {
        return findService.findAllDetail().map(x -> new ResponseDetail(x.nombre(), x.apellido(), x.edad(),
                x.fechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                x.fechaPosibleFallecimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
    }

    @GetMapping(value = "/kpis", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtener los kpis de los clientes", response = ResponseKpi.class)
    public Mono<ResponseKpi> obtenerKpis() {
        return findService.obtenerKpis().map(x -> new ResponseKpi(x.promedioClientes(), x.desviacionEstandar()));
    }


}

@Getter
@Setter
@ApiModel("RequestCrear")
final class RequestCrear {

    @ApiModelProperty(value = "nombre", example = "Lizardo")
    @NotEmpty
    private String nombre;
    @ApiModelProperty(value = "apellido", example = "Mamani")
    @NotEmpty
    private String apellido;

    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$")
    @ApiModelProperty(value = "fechaNacimiento", example = "20-02-1990")
    private String fechaNacimiento;

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String fechaNacimiento() {
        return fechaNacimiento;
    }

}

@Getter
@Setter
@ApiModel("ResponseKpi")
final class ResponseKpi {
    @ApiModelProperty(value = "promedio", example = "28.0")
    private Double promedio;
    @ApiModelProperty(value = "desviacionEstandar", example = "20.0")
    private Double desviacionEstandar;

    public ResponseKpi(Double promedio, Double desviacionEstandar) {
        this.promedio = promedio;
        this.desviacionEstandar = desviacionEstandar;
    }

    public Double promedio() {
        return promedio;
    }

    public Double desviacionEstandar() {
        return desviacionEstandar;
    }
}

@Getter
@Setter
@ApiModel("ResponseDetail")
final class ResponseDetail {

    @ApiModelProperty(value = "nombre", example = "Lizardo")
    private String nombre;
    @ApiModelProperty(value = "apellido", example = "Mamani")
    private String apellido;
    @ApiModelProperty(value = "edad", example = "29")
    private Integer edad;
    @ApiModelProperty(value = "fechaNacimiento", example = "20-01-1990")
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$")
    private String fechaNacimiento;
    @ApiModelProperty(value = "fechaPosibleFallecimiento", example = "20-12-2090")
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$")
    private String fechaPosibleFallecimiento;

    public ResponseDetail(String nombre, String apellido, Integer edad, String fechaNacimiento,
                          String fechaPosibleFallecimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaPosibleFallecimiento = fechaPosibleFallecimiento;
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public Integer edad() {
        return edad;
    }

    public String fechaNacimiento() {
        return fechaNacimiento;
    }

    public String fechaPosibleFallecimiento() {
        return fechaPosibleFallecimiento;
    }
}
