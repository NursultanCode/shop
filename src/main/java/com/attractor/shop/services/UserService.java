package com.attractor.shop.services;

import com.attractor.shop.entities.User;
import com.attractor.shop.entities.UserRegisterForm;
import com.attractor.shop.entities.UserResponseDto;
import com.attractor.shop.exceptions.CustomerNotFoundException;
import com.attractor.shop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserResponseDto register(UserRegisterForm form) {
        if (repository.existsByEmail(form.getEmail())) {
            //throw new CustomerAlreadyRegisteredException();
            log.error("Customer already registered");
        }

        var user = User.builder()
                .email(form.getEmail())
                .fullname(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return UserResponseDto.from(user);
    }

    public UserResponseDto getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return UserResponseDto.from(user);
    }
}
