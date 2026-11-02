package com.norteads.norteads.Auth;

import com.norteads.norteads.Auth.RequestDTO.RegisterRequest;
import com.norteads.norteads.ConfigMethods.HashPassword;
import com.norteads.norteads.ConfigMethods.IdGenerator;
import com.norteads.norteads.User.User;
import com.norteads.norteads.User.UserRepository;
import com.norteads.norteads.User.UserStatus;
import com.norteads.norteads.User.UserTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthService {

    private final IdGenerator idGenerator;
    private final UserRepository userRepository;
    private final HashPassword hashPassword;

    public AuthService(IdGenerator idGenerator, UserRepository userRepository, HashPassword hashPassword) {
        this.idGenerator = idGenerator;
        this.userRepository = userRepository;
        this.hashPassword = hashPassword;
    }

    public ResponseEntity<?> userRegister(RegisterRequest request){

        Long id;
        User user = new User();

        do {
            id = idGenerator.gerarId();
        }
        while (userRepository.existsById(id));

        user.setId(id);
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setHashPassword(hashPassword.passwordEncoder().encode(request.password()));
        user.setCreatedDate(LocalDate.now());
        user.setUserType(UserTypes.GERENTE);
        user.setUserStatus(UserStatus.ATIVO);

        userRepository.save(user);
        
        return ResponseEntity.status(200).body("Registrado com sucesso");
    }

}
