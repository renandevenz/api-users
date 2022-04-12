package com.br.users.apiusers.interactors;

import com.br.users.apiusers.entities.DadosUsuario;
import com.br.users.apiusers.repositories.SalvarUsuarioPort;
import org.springframework.stereotype.Service;

@Service
public class SalvarUsuarioUseCase {

    private final SalvarUsuarioPort port;

    public SalvarUsuarioUseCase(SalvarUsuarioPort port) {
        this.port = port;
    }

    public void salvarUsuario(DadosUsuario usuario) {
        port.salvar(usuario);
    }
}
