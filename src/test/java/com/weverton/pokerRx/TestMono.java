package com.weverton.pokerRx;

import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.util.BsonUtils;
import reactor.core.publisher.Mono;

public class TestMono {

    @Test
    public void TesteMono1() {
        Mono<String> mono = Mono.empty();
    }


    @Test
    public void TesteMono2() {
        Mono<String> mono = Mono.just("Weverton");
        mono.subscribe(System.out::println);
    }


    @Test
    public void TesteMono3() {
        Mono<Integer> mono = Mono.just(10);
        mono.subscribe(System.out::println);
    }

    @Test
    public void TesteMono4() {
        Mono<String> mono = Mono.error(new RuntimeException("Ocorreu uma exeção"));
    }



}
