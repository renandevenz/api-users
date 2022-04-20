package com.br.users.apiusers.interactors;

import com.br.users.apiusers.repositories.SalvarUsuarioPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.br.users.apiusers.factory.UsuarioFactory.getDomain;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalvarUsuarioUseCaseTest {

    @Mock
    SalvarUsuarioPort port;

    @InjectMocks
    SalvarUsuarioUseCase useCase;

    @Test
    @Order(1)
    @DisplayName("Deve processar o comando para salvar com sucesso")
    public void salvarUsuarioComsucesso() {

        var domain = getDomain();

        useCase.salvarUsuario(domain);

        verify(port, atLeastOnce()).salvar(any());
    }

    @Test
    @Order(2)
    @DisplayName("Deve processar o comando com objeto nulo")
    public void salvarUsuarioNulo() {

        var domain = getDomain();

        useCase.salvarUsuario(null);

        verify(port, never()).salvar(domain);
    }
}
