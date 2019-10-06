package com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql;

import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClienteMysqlRepository extends JpaRepository<ClienteEntity, String> {
    @Modifying
    @Query(value = "update cliente c set c.fec-fal = ?1 where c.id = ?2",
            nativeQuery = true)
    void updateFechaMortandad(LocalDate fechaFallecimiento, String id);
}
