package com.example.bank_simulation.service;

import com.example.bank_simulation.dto.RegistryDTO;
import com.example.bank_simulation.dto.mapper.RegistryMapper;
import com.example.bank_simulation.model.User;
import com.example.bank_simulation.repository.RegistryRepository;
import com.example.bank_simulation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistryService {

    @Autowired
    private RegistryRepository registryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistryMapper registryMapper;


    @Transactional
    public Optional<RegistryDTO> creditRegistry(String document, Double transactionValue){
        RegistryDTO registryDTO = new RegistryDTO();
        registryDTO.setTransactionValue(transactionValue);
        registryDTO.setCredit(true);
        registryDTO.setDate(LocalDate.now());
        registryDTO.setUserDocument(document);

        return Optional.of(registryMapper.toRegistryDTO(registryRepository.save(registryMapper.toRegistry(registryDTO))));
    }

    @Transactional
    public Optional<RegistryDTO> debitRegistry(String document, Double transactionValue){
        RegistryDTO registryDTO = new RegistryDTO();
        registryDTO.setTransactionValue(transactionValue);
        registryDTO.setCredit(false);
        registryDTO.setDate(LocalDate.now());
        registryDTO.setUserDocument(document);

        return Optional.of(registryMapper.toRegistryDTO(registryRepository.save(registryMapper.toRegistry(registryDTO))));
    }

    @Transactional(readOnly = true)
    public Optional<List<RegistryDTO>> listUserRegistry(String document){
        Optional<User> user = userRepository.findUserByDocument(document);
        return Optional.of(registryRepository
                .findRegistryByUser(user).get()
                .stream().map(registryMapper::toRegistryDTO)
                .collect(Collectors.toList()));
    }
}
