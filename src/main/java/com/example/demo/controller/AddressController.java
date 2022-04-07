package com.example.demo.controller;

import com.example.demo.service.AddressService;
import com.example.demo.entities.AddressEntity;
import com.example.demo.entities.AddressWithoutId;
import com.example.demo.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity getAddresses(){
        try {
            List<AddressEntity> list = service.findAllAddresses();
            return ResponseEntity.ok(list);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getAddress(@PathVariable String id){
        try {
            return ResponseEntity.ok(service.findAddrById(id));
        } catch (AddressNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity saveAddress(@RequestBody AddressEntity addr){
        try {
            return ResponseEntity.ok(service.createAddress(addr));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editAddress(@PathVariable String id, @RequestBody AddressWithoutId addr){
        try {
            Integer status = service.updateAddress(id, addr);
            if (status == 204)
                return ResponseEntity.ok(status);
            else return ResponseEntity.badRequest().body("404 address not found");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable String id){
        try {
            Integer status = service.deleteAddress(id);
            if (status == 204)
                return ResponseEntity.ok(204);
            else return ResponseEntity.badRequest().body("404 address not found");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }
}
