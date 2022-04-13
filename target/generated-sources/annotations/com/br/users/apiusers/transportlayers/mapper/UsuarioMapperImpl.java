package com.br.users.apiusers.transportlayers.mapper;

import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioResponse;
import com.br.users.apiusers.entities.DadosUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-13T15:48:16-0300",
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

    @Override
    public DadosUsuarioResponse map(DadosUsuario domain) {
        if ( domain == null ) {
            return null;
        }

        DadosUsuarioResponse dadosUsuarioResponse = new DadosUsuarioResponse();

        dadosUsuarioResponse.setNome( domain.getNome() );
        dadosUsuarioResponse.setEmail( domain.getEmail() );

        return dadosUsuarioResponse;
    }

    @Override
    public List<DadosUsuarioResponse> map(List<DadosUsuario> domain) {
        if ( domain == null ) {
            return null;
        }

        List<DadosUsuarioResponse> list = new ArrayList<DadosUsuarioResponse>( domain.size() );
        for ( DadosUsuario dadosUsuario : domain ) {
            list.add( map( dadosUsuario ) );
        }

        return list;
    }
}
