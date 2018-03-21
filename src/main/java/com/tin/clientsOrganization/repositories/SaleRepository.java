package com.tin.clientsOrganization.repositories;

import com.tin.clientsOrganization.entities.Customer;
import com.tin.clientsOrganization.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Sale findById(Long id);
    List<Sale> findByCustomer (Customer customer);

    @Transactional
    @Modifying
    @Query("update Sale s set s.id=:id, s.amount=:amount, s.customer=:customer, s.date=:date, s.fees=:fees, " +
            "s.product=:product where s.id=:id")
    void updateById(@Param("id") Long id,@Param("amount") Float amount,
                    @Param("customer")Customer customer, @Param("date")Date date, @Param("fees")Integer fees,
                    @Param("product")String product);
    
    /*@Transactional
    Sale save (Sale sale);*/
}
