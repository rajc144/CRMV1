package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    java.util.Optional<Address> findAddressByProfileid(Integer profileid);

    Iterable<Address> findAllByProfileid(Integer profileid);
}
