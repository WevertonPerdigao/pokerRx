package com.weverton.pokerRx.repository;

import com.weverton.pokerRx.model.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {


}
