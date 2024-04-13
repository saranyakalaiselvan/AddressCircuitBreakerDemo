package com.crackit.AddressCircuitBreakerDemo.repository;

import com.crackit.AddressCircuitBreakerDemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByEmployeeId(Integer employeeId);
}
