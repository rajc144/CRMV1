package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entity.ContactInformation;

public interface ContactInformationRepository extends JpaRepository<ContactInformation, Long> {

}
