package com.example.bank_simulation.controller;


import com.example.bank_simulation.dto.RegistryDTO;
import com.example.bank_simulation.dto.UserDTO;
import com.example.bank_simulation.service.RegistryService;
import com.example.bank_simulation.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Api(value="User account API")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistryService registryService;

    @ApiOperation(value="Create user", notes="Method to create new users.")
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return ok().build();
    }

    @ApiOperation(value = "Add credit", notes = "Method to register a new credit entry.")
    @PutMapping("/{document}/credit")
    public ResponseEntity<UserDTO> creditUser(@PathVariable String document, Double transactionValue){
        userService.creditUser(document, transactionValue);
        return ok().build();
    }

    @ApiOperation(value = "Add debit", notes = "Method to register a new debit entry.")
    @PutMapping("/{document}/debit")
    public ResponseEntity<UserDTO> debitUser(@PathVariable String document, Double transactionValue){
        userService.debitUser(document, transactionValue);
        return ok().build();
    }

    @ApiOperation(value = "Check balance", notes = "Method to get the account balance.")
    @GetMapping("/{document}/balance")
    public ResponseEntity<String> checkBalance(@PathVariable String document){
        return ok(userService.checkBalance(document).get());
    }

    @ApiOperation(value = "List registry", notes = "Method to get a list of all transactions made in that account.")
    @GetMapping("{document}/registry")
    public ResponseEntity<List<RegistryDTO>> listUserRegistry(@PathVariable String document){
        return ok(registryService.listUserRegistry(document).get());
    }
}
