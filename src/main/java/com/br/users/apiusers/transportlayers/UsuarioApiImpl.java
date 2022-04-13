package com.br.users.apiusers.transportlayers;

import com.br.users.apiusers.api.openapi.api.UsersApi;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioResponse;
import com.br.users.apiusers.interactors.BuscarUsuarioUseCase;
import com.br.users.apiusers.interactors.SalvarUsuarioUseCase;
import com.br.users.apiusers.transportlayers.mapper.UsuarioMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/")
public class UsuarioApiImpl implements UsersApi {

    private final SalvarUsuarioUseCase salvarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public UsuarioApiImpl(SalvarUsuarioUseCase salvarUsuarioUseCase, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.salvarUsuarioUseCase = salvarUsuarioUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    @Override
    public ResponseEntity<Void> salvar(DadosUsuarioRequest dadosUsuarioRequest) {

        var mapper = UsuarioMapper.INSTANCE;

        salvarUsuarioUseCase.salvarUsuario(mapper.map(dadosUsuarioRequest));

        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public ResponseEntity<DadosUsuarioResponse> buscar(String nome) {

        var mapper = UsuarioMapper.INSTANCE;

        var response = mapper.map(buscarUsuarioUseCase.buscarUsuario(nome));

        return new ResponseEntity<>(response, OK);
    }

    @Override
    public ResponseEntity<List<DadosUsuarioResponse>> buscarTodos() {

        var mapper = UsuarioMapper.INSTANCE;

        var response = mapper.map(buscarUsuarioUseCase.buscarUsuarios());

        return new ResponseEntity<>(response, OK);
    }
}
