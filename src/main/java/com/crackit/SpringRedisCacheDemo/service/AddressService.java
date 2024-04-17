package com.crackit.SpringRedisCacheDemo.service;

import com.crackit.SpringRedisCacheDemo.dto.AddressDTO;
import com.crackit.SpringRedisCacheDemo.entity.Address;
import com.crackit.SpringRedisCacheDemo.repository.AddressRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<AddressDTO> getAddress() {
        return entityToDTOMapper(addressRepository.findAll());
    }

    private List<AddressDTO> entityToDTOMapper(List<Address> addresses) {
        return addresses.stream().map(address -> new AddressDTO(
                address.getId(),
                address.getStreetName(),
                address.getSuburb(),
                address.getCity(),
                address.getPostCode(),
                address.getEmployeeId()
        )).collect(Collectors.toList());
    }

    @CacheEvict(value = "address", allEntries = true)
    public void createAddress(AddressDTO addressDTO) {
         addressRepository.save(DTOToEntityMapper(addressDTO));
    }

    private Address DTOToEntityMapper(AddressDTO addressDTO) {
        return  Address.builder()
                .id(addressDTO.id())
                .city(addressDTO.city())
                .suburb(addressDTO.suburb())
                .streetName(addressDTO.streetName())
                .postCode(addressDTO.postCode())
                .employeeId(addressDTO.employeeId())
                .build();
    }
}
