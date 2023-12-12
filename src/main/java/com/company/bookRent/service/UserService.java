package com.company.bookRent.service;

import com.company.bookRent.domain.User;
import com.company.bookRent.exception.DuplicateUserException;
import com.company.bookRent.exception.UserNotFoundException;
import com.company.bookRent.jwt.JwtToken;
import com.company.bookRent.jwt.JwtTokenProvider;
import com.company.bookRent.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public JwtToken signIn(String loginId, String password) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginId, password);

        Authentication authentication = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        return jwtToken;
    }

    public User find(String loginId) {
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public User save(User user) {
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
        if (userRepository.findByLoginId(user.getLoginId()).isPresent()) {
            throw new DuplicateUserException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findByLoginId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }
}
