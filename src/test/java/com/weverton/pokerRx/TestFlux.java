package com.weverton.pokerRx;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class TestFlux {
    @Test
    void testFlux1() {
        Flux.empty();
    }

    @Test
    void testFlux2() {
        Flux<String> flux = Flux.just("PokerRX");
        flux.subscribe(System.out::println);
    }

    @Test
    void testFlux3() {
        Flux<String> flux = Flux.just("Weverton", "Freitas", "Perdigão");
        flux.subscribe(System.out::println);
    }
}
