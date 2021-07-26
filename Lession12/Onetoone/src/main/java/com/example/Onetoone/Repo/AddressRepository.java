package com.example.Onetoone.Repo;

import com.example.Onetoone.Model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
