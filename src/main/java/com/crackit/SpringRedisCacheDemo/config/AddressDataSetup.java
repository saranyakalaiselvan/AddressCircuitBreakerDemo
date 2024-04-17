package com.crackit.SpringRedisCacheDemo.config;

import com.crackit.SpringRedisCacheDemo.entity.Address;
import com.crackit.SpringRedisCacheDemo.repository.AddressRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AddressDataSetup {

    private final AddressRepository addressRepository;
    public AddressDataSetup(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostConstruct
    public void setupData() {
        addressRepository.saveAll(
                Arrays.asList(
                        Address.builder().id(1).city("Chennai")
                                .postCode(600000).suburb("suburb")
                                .streetName("Street").employeeId(1).build(),
                        Address.builder().id(2).city("Bangalore")
                                .postCode(600000).suburb("suburb")
                                .streetName("Street").employeeId(2).build(),
                        Address.builder().id(3).city("Sydney")
                                .postCode(600000).suburb("suburb")
                                .streetName("Street").employeeId(3).build()
                )
        );
    }
}
