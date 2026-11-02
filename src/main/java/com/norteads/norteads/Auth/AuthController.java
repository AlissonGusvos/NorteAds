package com.norteads.norteads.Auth;

import com.norteads.norteads.Auth.RequestDTO.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseStatus userRegister(@RequestBody RegisterRequest request){
    }

}
