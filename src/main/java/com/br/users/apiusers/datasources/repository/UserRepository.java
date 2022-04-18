package com.br.users.apiusers.datasources.repository;

import com.br.users.apiusers.datasources.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByNome(String nome);
}
