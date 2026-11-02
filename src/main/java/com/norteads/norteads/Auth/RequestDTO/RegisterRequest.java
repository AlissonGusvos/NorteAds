package com.norteads.norteads.Auth.RequestDTO;

public record RegisterRequest(
        String username,
        String email,
        String password
) {
}
