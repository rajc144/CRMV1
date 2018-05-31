package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Addresses;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends CrudRepository<Addresses, Integer> {

    Addresses findAddressesByprofileId(Integer profile_id);
}
