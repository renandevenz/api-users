package com.br.users.apiusers.transportlayers.mappers;

import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.entities.DadosUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    DadosUsuario map(DadosUsuarioRequest dto);
}
