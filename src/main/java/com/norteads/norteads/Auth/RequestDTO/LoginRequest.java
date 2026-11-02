package com.norteads.norteads.Auth.RequestDTO;

public record LoginRequest(
        String email,
        String password
) {
}
