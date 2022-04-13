package com.br.users.apiusers.transportlayers.mapper;

import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioResponse;
import com.br.users.apiusers.entities.DadosUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    DadosUsuario map(DadosUsuarioRequest dto);

    DadosUsuarioResponse map(DadosUsuario domain);

    List<DadosUsuarioResponse> map(List<DadosUsuario> domain);
}
