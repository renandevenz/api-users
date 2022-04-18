package com.br.users.apiusers.datasources.mapper;

import com.br.users.apiusers.datasources.entity.UserEntity;
import com.br.users.apiusers.entities.DadosUsuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-18T10:07:43-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Azul Systems, Inc.)"
)
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public DadosUsuario toEntity(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DadosUsuario dadosUsuario = new DadosUsuario();

        dadosUsuario.setNome( entity.getNome() );
        dadosUsuario.setEmail( entity.getEmail() );

        return dadosUsuario;
    }
}
