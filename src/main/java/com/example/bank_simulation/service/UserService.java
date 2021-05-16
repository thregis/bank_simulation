package com.example.bank_simulation.service;

import com.example.bank_simulation.dto.RegistryDTO;
import com.example.bank_simulation.dto.UserDTO;
import com.example.bank_simulation.dto.mapper.UserMapper;
import com.example.bank_simulation.exception.BadRequestException;
import com.example.bank_simulation.model.Registry;
import com.example.bank_simulation.model.User;
import com.example.bank_simulation.repository.RegistryRepository;
import com.example.bank_simulation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistryService registryService;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public Optional<UserDTO> createUser(UserDTO userDTO){

        if (!userDTO.getDocument().matches("[0-9]{11}")){
            throw new BadRequestException("Invalid entry");
        }else if (userDTO.getName().isEmpty() || userDTO.getPassword().isEmpty()){
            throw new BadRequestException("Name and Password fields must be filled");
        }

        Optional<User> validator= userRepository.findUserByDocument(userDTO.getDocument());
        if (validator.isPresent()){
            throw new BadRequestException("Document already used.");
        }
        userDTO.setBalance(100.0);
        userDTO.setActive(true);
        return Optional.of(userMapper.toUserDTO(userRepository.save(userMapper.toUser(userDTO))));
    }

    @Transactional
    public Optional<UserDTO> creditUser(String document, Double transactionValue){

        Optional<User> user = userRepository.findUserByDocument(document);
        if (transactionValue <= 0){
            throw new BadRequestException("Invalid number inserted");
        }
        registryService.creditRegistry(document, transactionValue);
        user.get().setBalance(user.get().getBalance()+transactionValue);

    return Optional.of(userMapper.toUserDTO(userRepository.save(user.get())));
    }

    @Transactional
    public Optional<UserDTO> debitUser(String document, Double transactionValue){

        Optional<User> user = userRepository.findUserByDocument(document);
        if (transactionValue <= 0){
            throw new BadRequestException("Invalid number inserted");
        }else if(user.get().getBalance()-transactionValue < 0){
            throw new BadRequestException("You can't debit an amount you don't have");
        }
        registryService.debitRegistry(document, transactionValue);
        user.get().setBalance(user.get().getBalance()-transactionValue);

        return Optional.of(userMapper.toUserDTO(userRepository.save(user.get())));
    }

    @Transactional(readOnly = true)
    public Optional<String> checkBalance(String document){
        Optional<User> user = userRepository.findUserByDocument(document);
        String message = "The balance of user - "+ user.get().getName()+" - is: R$ "+ user.get().getBalance()+".";
        return Optional.of(message);
    }

}
