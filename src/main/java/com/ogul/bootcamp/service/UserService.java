package com.ogul.bootcamp.service;

import com.ogul.bootcamp.security.entity.Authority;
import com.ogul.bootcamp.security.entity.User;
import com.ogul.bootcamp.entity.dto.SignInRequest;
import com.ogul.bootcamp.repository.AuthorityRepository;
import com.ogul.bootcamp.repository.UserRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public void signIn(SignInRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .authorities(Set.of(authorityRepository.findById(1L).orElseThrow(RuntimeException::new)))
            .build();

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void giveAdminRights(Long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        Set<Authority> authorities = user.getAuthorities();
        authorities.add(authorityRepository.findById(2L).orElseThrow(RuntimeException::new));
        user.setAuthorities(authorities);
        userRepository.save(user);
    }

}
