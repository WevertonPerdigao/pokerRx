package com.weverton.pokerRx.controller;

import com.weverton.pokerRx.model.Usuario;
import com.weverton.pokerRx.model.UsuarioEvent;
import com.weverton.pokerRx.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public Flux<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> getUsuario(@PathVariable String id) {
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok(usuario))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    @DeleteMapping
    public Mono<Void> deleteAllUsuario() {
        return usuarioRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUsuario(@PathVariable String id) {
        return usuarioRepository.deleteById(id);

    }


    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UsuarioEvent> getPokemonEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(val ->
                        new UsuarioEvent(val, "Usuáio Event")
                );
    }

}
