package com.bbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbt.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
