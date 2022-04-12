package com.br.users.apiusers.transportlayers.mappers;

import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.entities.DadosUsuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T15:09:00-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Azul Systems, Inc.)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public DadosUsuario map(DadosUsuarioRequest dto) {
        if ( dto == null ) {
            return null;
        }

        DadosUsuario dadosUsuario = new DadosUsuario();

        dadosUsuario.setNome( dto.getNome() );
        dadosUsuario.setEmail( dto.getEmail() );

        return dadosUsuario;
    }
}
