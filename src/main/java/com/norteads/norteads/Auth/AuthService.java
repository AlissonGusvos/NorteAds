package com.norteads.norteads.Auth;

import com.norteads.norteads.Auth.RequestDTO.LoginRequest;
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
import java.util.Optional;

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

    public ResponseEntity<?> userLogin(LoginRequest request){
        Optional<User> optionalUser = userRepository.findByEmail(request.email());
        if (optionalUser.isEmpty()){
            return ResponseEntity.status(401).body("E-mail ou senha inválidos");
        }

        User user = optionalUser.get();
        if (!hashPassword.passwordEncoder().matches(request.password(), user.getHashPassword())){
            return ResponseEntity.status(401).body("E-mail ou senha inválidos");
        }

        return ResponseEntity.status(200).body("Logado");
    }
}
