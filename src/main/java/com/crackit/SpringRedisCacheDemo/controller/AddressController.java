package com.crackit.SpringRedisCacheDemo.controller;

import com.crackit.SpringRedisCacheDemo.dto.AddressDTO;
import com.crackit.SpringRedisCacheDemo.service.AddressService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis-cache/v1/crackit")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @GetMapping("/address")
    @Cacheable("address")
    public List<AddressDTO> getAddresses()  {
        System.out.println("In Address Controller - Get all addresses");
        return addressService.getAddress();
    }

    @PostMapping("/address")
    public void createAddress(@RequestBody AddressDTO addressDTO)  {
        System.out.println("In Address Controller - Create address");
        addressService.createAddress(addressDTO);
    }
}
