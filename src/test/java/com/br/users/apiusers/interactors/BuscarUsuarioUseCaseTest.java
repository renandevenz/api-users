package com.br.users.apiusers.interactors;

import com.br.users.apiusers.repositories.BuscarUsuarioPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.br.users.apiusers.factory.UsuarioFactory.getDomain;
import static com.br.users.apiusers.factory.UsuarioFactory.getDomainList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuscarUsuarioUseCaseTest {

    @Mock
    BuscarUsuarioPort port;

    @InjectMocks
    BuscarUsuarioUseCase useCase;

    @Test
    @Order(1)
    @DisplayName("Deve buscar um usuario por nome com sucesso")
    public void buscarUsuarioComSucesso() {

        var domain = getDomain();

        when(port.consultar(anyString())).thenReturn(domain);

        useCase.buscarUsuario("Fulano");

        verify(port, times(1)).consultar(anyString());

        assertThat(domain).isNotNull();
    }

    @Test
    @Order(2)
    @DisplayName("Deve buscar um usuario com erro")
    public void buscarUsuarioComErro() {

        useCase.buscarUsuario("");

        verify(port, never()).consultar(null);
    }

    @Test
    @Order(3)
    @DisplayName("Deve buscar todos os usuarios com sucesso")
    public void buscarTodosComsucesso() {

        var users = getDomainList();

        when(port.consultarTodos()).thenReturn(users);

        useCase.buscarUsuarios();

        verify(port, atMostOnce()).consultarTodos();
    }
}
