package com.tin.clientsOrganization.repositories;

import com.tin.clientsOrganization.entities.Quota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotaRepository extends JpaRepository<Quota, Long> {
}
