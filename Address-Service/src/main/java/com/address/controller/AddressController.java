package com.address.controller;

import com.address.model.Address;
import com.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
   @Autowired
   private AddressRepository addressRepository;
   @GetMapping("/address/{id}")
   public Address getAddressbyEmpId(@PathVariable int id){
       Address address=addressRepository.getAddressByEmpId(id);
       return address;
   }
}
