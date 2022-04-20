package com.br.users.apiusers.datasources;

import com.br.users.apiusers.datasources.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.br.users.apiusers.factory.UsuarioFactory.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioDataSourceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UsuarioDataSource dataSource;

    @Test
    @Order(1)
    @DisplayName("Deve consultar um usuario com sucesso no banco de dados")
    public void buscarUsuarioComsucesso() {

        var entity = getEntity();

        when(repository.findByNome(anyString())).thenReturn(entity);

        dataSource.consultar("Fulano");

        verify(repository, atLeastOnce()).findByNome(anyString());

        assertThat(entity).isNotNull();
    }

    @Test
    @Order(2)
    @DisplayName("Deve consultar uma lista de usuarios com sucesso no banco de dados")
    public void buscarUsuariosComSucesso() {

        var entities = getEntities();

        when(repository.findAll()).thenReturn(entities);

        dataSource.consultarTodos();

        verify(repository, atLeastOnce()).findAll();

        assertThat(entities).isNotNull();
    }

    @Test
    @Order(3)
    @DisplayName("Deve salvar com sucesso um usuario no banco de dados")
    public void salvarUsuarioComsucesso() {

        var domain = getDomain();

        dataSource.salvar(domain);

        verify(repository, atLeastOnce()).save(any());

        assertThat(domain).isNotNull();
    }
}
