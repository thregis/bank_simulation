package com.example.bank_simulation.repository;

import com.example.bank_simulation.model.Registry;
import com.example.bank_simulation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByDocument(String document);
    Optional<List<Registry>> findRegistryByDocument(String document);
}
