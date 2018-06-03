package com.tin.clientsOrganization.repositories;

import com.tin.clientsOrganization.entities.Quota;
import com.tin.clientsOrganization.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface QuotaRepository extends JpaRepository<Quota, Long> {

    Quota findById (Long id);

    @Transactional
    @Modifying
    @Query("update Quota q set q.amount=:amount, q.date=:date, q.sale=:sale where q.id=:id")
    void update (@Param("amount")Float amount, @Param("date")Date date, @Param("sale")Sale sale, @Param("id")Long id);
}
