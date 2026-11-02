package com.norteads.norteads.ConfigMethods;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashPassword {

public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

}
