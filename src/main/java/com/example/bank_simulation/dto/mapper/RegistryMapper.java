package com.example.bank_simulation.dto.mapper;

import com.example.bank_simulation.dto.RegistryDTO;
import com.example.bank_simulation.model.Registry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RegistryMapper {

    @Mappings({
            @Mapping(source = "userDocument", target = "user.document")})
    Registry toRegistry(RegistryDTO registryDTO);

    @Mappings({
            @Mapping(source = "user.document", target = "userDocument")})
    RegistryDTO toRegistryDTO(Registry registry);


}
