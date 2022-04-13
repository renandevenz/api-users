package com.br.users.apiusers.interactors;

import com.br.users.apiusers.entities.DadosUsuario;
import com.br.users.apiusers.repositories.BuscarUsuarioPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarUsuarioUseCase {

    private final BuscarUsuarioPort port;

    public BuscarUsuarioUseCase(BuscarUsuarioPort port) {
        this.port = port;
    }

    public DadosUsuario buscarUsuario(String nome) {
        return port.consultar(nome);
    }

    public List<DadosUsuario> buscarUsuarios() {
        return port.consultarTodos();
    }
}
