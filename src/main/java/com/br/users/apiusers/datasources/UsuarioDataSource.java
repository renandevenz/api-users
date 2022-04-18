package com.br.users.apiusers.datasources;

import com.br.users.apiusers.datasources.mapper.UserEntityMapper;
import com.br.users.apiusers.datasources.repository.UserRepository;
import com.br.users.apiusers.entities.DadosUsuario;
import com.br.users.apiusers.repositories.BuscarUsuarioPort;
import com.br.users.apiusers.repositories.SalvarUsuarioPort;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UsuarioDataSource implements BuscarUsuarioPort, SalvarUsuarioPort {

    private final UserRepository repository;

    public UsuarioDataSource(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public DadosUsuario consultar(String nome) {
        var mapper = UserEntityMapper.INSTANCE;
        return mapper.toEntity(repository.findByNome(nome));
    }

    @Override
    public List<DadosUsuario> consultarTodos() {
        var mapper = UserEntityMapper.INSTANCE;
        return repository.findAll().stream().map(mapper::toEntity).collect(toList());
    }

    @Override
    public void salvar(DadosUsuario usuario) {
        var mapper = UserEntityMapper.INSTANCE;
        var entity = repository.findByNome(usuario.getNome());
        mapper.toEntity(repository.save(entity));
    }
}
