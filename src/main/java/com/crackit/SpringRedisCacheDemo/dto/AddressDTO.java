package com.crackit.SpringRedisCacheDemo.dto;

import java.io.Serializable;

public record AddressDTO(Integer id,
                         String streetName,
                         String suburb,
                         String city,
                         Integer postCode,
                         Integer employeeId) implements Serializable {
}
