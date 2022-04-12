package com.br.users.apiusers.transportlayers;

import com.br.users.apiusers.api.openapi.api.UsersApi;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.interactors.SalvarUsuarioUseCase;
import com.br.users.apiusers.transportlayers.mappers.UsuarioMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsuarioApiImpl implements UsersApi {

    private final SalvarUsuarioUseCase salvarUsuarioUseCase;

    public UsuarioApiImpl(SalvarUsuarioUseCase salvarUsuarioUseCase) {
        this.salvarUsuarioUseCase = salvarUsuarioUseCase;
    }

    @Override
    public ResponseEntity<Void> salvar(DadosUsuarioRequest dadosUsuarioRequest) {

        var mapper = UsuarioMapper.INSTANCE;

        salvarUsuarioUseCase.salvarUsuario(mapper.map(dadosUsuarioRequest));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
