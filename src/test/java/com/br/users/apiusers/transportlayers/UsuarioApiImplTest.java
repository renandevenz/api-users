package com.br.users.apiusers.transportlayers;

import com.br.users.apiusers.interactors.BuscarUsuarioUseCase;
import com.br.users.apiusers.interactors.SalvarUsuarioUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.br.users.apiusers.factory.UsuarioFactory.getRequest;
import static com.br.users.apiusers.factory.UsuarioFactory.getResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioApiImplTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    BuscarUsuarioUseCase buscarUsuarioUseCase;

    @Mock
    SalvarUsuarioUseCase salvarUsuarioUseCase;

    @InjectMocks
    UsuarioApiImpl usuarioApiImpl;

    private static final String URL_BUSCAR_POR_NOME = "/users/v1/buscarPorNome";
    private static final String URL_SALVAR = "/users/v1/cadastrar";
    private static final String HEADER = "Fulano";

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioApiImpl).build();
    }

    @Test
    @Order(1)
    @DisplayName("Deve realizar a consulta por nome com sucesso")
    public void testBuscarUsuario() throws Exception {

        var response = getResponse();
        var json = new ObjectMapper().writeValueAsString(response);

        var request = get(URL_BUSCAR_POR_NOME)
                .content(json)
                .contentType(APPLICATION_JSON)
                .header("nome", HEADER);

        mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @Order(2)
    @DisplayName("Deve realizar a consulta e retornar BAD REQUEST")
    public void testBuscarUsuarioComErro() throws Exception {

        var response = getResponse();
        var json = new ObjectMapper().writeValueAsString(response);

        var request = get(URL_BUSCAR_POR_NOME)
                .content(json)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(3)
    @DisplayName("Deve criar um novo usuário com sucesso")
    public void testSalvarUsuario() throws Exception {

        var request = getRequest();
        var json = new ObjectMapper().writeValueAsString(request);

        var builder = post(URL_SALVAR)
                .content(json)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(builder)
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @Order(4)
    @DisplayName("Deve criar um novo usuário com erro")
    public void testSalvarUsuarioComErro() throws Exception {

        var request = getRequest();
        var json = new ObjectMapper().writeValueAsString(request);

        var builder = post("/deuRuim")
                .content(json)
                .contentType(APPLICATION_JSON);

        mockMvc.perform(builder)
                .andExpect(status().isNotFound());
    }
}
