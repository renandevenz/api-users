package com.br.users.apiusers.datasources.mapper;

import com.br.users.apiusers.datasources.entity.UserEntity;
import com.br.users.apiusers.entities.DadosUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target = "entity.id", ignore = true)
    DadosUsuario toEntity(UserEntity entity);

    @Mapping(target = "id", ignore = true)
    UserEntity toDomain(DadosUsuario domain);
}
