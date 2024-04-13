package com.crackit.AddressCircuitBreakerDemo.controller;

import com.crackit.AddressCircuitBreakerDemo.dto.AddressDTO;
import com.crackit.AddressCircuitBreakerDemo.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit-breaker/v1/crackit")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @GetMapping("/employees/{employeeId}/address")
    public AddressDTO getAddress(@PathVariable("employeeId") Integer employeeId)  {
        return addressService.getAddress(employeeId);
    }

}
