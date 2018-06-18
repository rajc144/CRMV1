package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.Activities;

public interface ActivitesRepository extends JpaRepository<Activities, Long> {

	public Activities findByid(Long id);
}
