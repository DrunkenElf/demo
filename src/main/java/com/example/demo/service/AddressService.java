package com.example.demo.service;

import com.example.demo.entities.AddressEntity;
import com.example.demo.entities.AddressWithoutId;
import com.example.demo.exception.AddressAlreadyExist;
import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo repo;

    public AddressService(){}

    public List<AddressEntity> findAllAddresses(){
        List<AddressEntity> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }

    public AddressEntity findAddrById(String id) throws AddressNotFoundException{
        Optional<AddressEntity> addr = repo.findById(id);
        if (addr.isEmpty())
            throw new AddressNotFoundException("No such address");
        return addr.get();
    }

    public AddressEntity createAddress(AddressEntity addr) throws AddressAlreadyExist {
        if (addr == null) System.out.println("add null");
        if (repo.findById(addr.getId()).isPresent())
            throw new AddressAlreadyExist("address already exist");
        return repo.save(addr);
    }

    public Integer deleteAddress(String id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            return 204;
        } else return 404;
    }

    public Integer updateAddress(String id, AddressWithoutId addr){
        if (repo.existsById(id)){
            AddressEntity entity = repo.findById(id).get();
            entity.toEntity(addr);
            repo.save(entity);
            return 204;
        } else return 404;
    }
}
