package com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql;

import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.entity.ClienteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface ClienteMysqlRepository extends CrudRepository<ClienteEntity, String> {
    @Modifying
    @Transactional
    @Query(value = "update cliente c set c.fecfal = ?1 where c.id = ?2",
            nativeQuery = true)
    Integer updateFechaMortandad(LocalDate fechaFallecimiento, String id);




    /*@Modifying
    @Query(value = "INSERT INTO cliente(id,nombre, apellido, edad, fecnac, fecfal) VALUES(?1,?2,?3,?4,?5,?6)",
            nativeQuery = true)
    @Transactional
    Integer saveCliente(String id, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento,
                                    LocalDate fechaPosibleFallecimiento);*/
}
