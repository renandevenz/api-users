package com.br.users.apiusers.factory;

import com.br.users.apiusers.api.openapi.model.DadosUsuarioRequest;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioResponse;
import com.br.users.apiusers.datasources.entity.UserEntity;
import com.br.users.apiusers.entities.DadosUsuario;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.springframework.http.ResponseEntity.ok;

public class UsuarioFactory {

    public static ResponseEntity<DadosUsuarioResponse> getResponse() {
        var response = new DadosUsuarioResponse();
        response.setEmail("teste@teste.com");
        response.setNome("fulano");
        return ok(response);
    }

    public static DadosUsuarioRequest getRequest() {
        var request = new DadosUsuarioRequest();
        request.setEmail("teste@teste.com");
        request.setNome("fulano");
        return request;
    }

    public static UserEntity getEntity() {
        var entity = new UserEntity();
        entity.setEmail("teste@teste.com");
        entity.setNome("fulano");
        entity.setId(new Random().nextInt());
        return entity;
    }

    public static List<UserEntity> getEntities() {
        List<UserEntity> entities = new ArrayList<>();
        var entity = new UserEntity();
        entity.setEmail("teste@teste.com");
        entity.setNome("fulano");
        entity.setId(new Random().nextInt());
        entities.add(entity);
        return entities;
    }

    public static DadosUsuario getDomain() {
        var usuario = new DadosUsuario();
        usuario.setEmail("teste@teste.com");
        usuario.setNome("fulano");
        return usuario;
    }

    public static List<DadosUsuario> getDomainList() {
        List<DadosUsuario> users = new ArrayList<>();
        var user = new DadosUsuario();
        user.setEmail("teste@teste.com");
        user.setNome("fulano");
        users.add(user);
        return users;
    }
}
