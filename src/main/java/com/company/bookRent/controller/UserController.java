package com.company.bookRent.controller;

import com.company.bookRent.controller.dto.UserLoginDTO;
import com.company.bookRent.controller.dto.UserSignupDTO;
import com.company.bookRent.domain.User;
import com.company.bookRent.jwt.JwtToken;
import com.company.bookRent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignupDTO userSignupDTO) {
        User user = User.createUser(userSignupDTO, passwordEncoder);
        userService.save(user);
        return ResponseEntity.ok(user.getLoginId());
    }

    @PostMapping("/login")
    public JwtToken login(@RequestBody UserLoginDTO loginDTO) {
        String loginId = loginDTO.getLoginId();
        String password = loginDTO.getPassword();
        JwtToken jwtToken = userService.signIn(loginId, password);
        return  jwtToken;
    }


}
