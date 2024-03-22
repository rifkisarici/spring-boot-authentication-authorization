package com.auth.ws.company.repository;


import com.auth.ws.company.entity.AppCompany;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CompanyRepository extends JpaRepository<AppCompany, Long> {
    @Query("Select u from AppCompany u ")
    List<AppCompany> findFirsts(Pageable page);

    @Query("Select u from AppCompany u where lower(u.name) LIKE lower(concat('%',?1,'%'))")
    List<AppCompany> findByName(String name, Pageable page);
}
