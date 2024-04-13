package com.crackit.AddressCircuitBreakerDemo.service;

import com.crackit.AddressCircuitBreakerDemo.dto.AddressDTO;
import com.crackit.AddressCircuitBreakerDemo.entity.Address;
import com.crackit.AddressCircuitBreakerDemo.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public AddressDTO getAddress(Integer employeeId) {
        return addressMapper(addressRepository.findByEmployeeId(employeeId)
                .orElseThrow(
                        () -> new RuntimeException("No address found for employeeId: " + employeeId)
                ));
    }

    private AddressDTO addressMapper(Address address) {
        return new AddressDTO(
                address.getId(),
                address.getStreetName(),
                address.getSuburb(),
                address.getCity(),
                address.getPostCode(),
                address.getEmployeeId()
        );
    }
}
