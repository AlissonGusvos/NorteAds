package com.norteads.norteads.ConfigMethods;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class IdGenerator {

    private final SecureRandom RANDOM = new SecureRandom();

    public Long gerarId(){
        return 10_000_000L + RANDOM.nextLong(99_999_999L);
    }

}
