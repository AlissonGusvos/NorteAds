package com.norteads.norteads.Auth;

import com.norteads.norteads.Auth.RequestDTO.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody RegisterRequest request){
        return authService.userRegister(request);
    }

}
