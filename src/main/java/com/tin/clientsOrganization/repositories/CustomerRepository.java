package com.tin.clientsOrganization.repositories;

import com.tin.clientsOrganization.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.server.PathParam;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findById(Long id);

    List<Customer> findByName(String name);

    @Transactional
    @Modifying
    @Query ("update Customer c set c.name=:name, c.lastname=:lastname, c.phoneNumber=:phoneNumber," +
            "c.dni=:dni, c.address=:address where c.id=:id")
    void updateById(@Param("name")String name,@Param("lastname")String lastname, @Param("phoneNumber")String phoneNumber,
                        @Param("dni")String dni, @Param("address")String address, @Param("id")Long id);
}
