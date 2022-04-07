package com.example.demo.repository;

import com.example.demo.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<AddressEntity, String> {

}
