package com.br.users.apiusers.repositories;

import com.br.users.apiusers.entities.DadosUsuario;

import java.util.List;

public interface BuscarUsuarioPort {

    DadosUsuario consultar(String nome);
    List<DadosUsuario> consultarTodos();
}
