package com.example.Onetoone.Repo;

import com.example.Onetoone.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
