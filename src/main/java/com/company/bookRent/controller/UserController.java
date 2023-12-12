package com.company.bookRent.controller;

import com.company.bookRent.controller.dto.UserLoginDTO;
import com.company.bookRent.controller.dto.UserSignupDTO;
import com.company.bookRent.domain.User;
import com.company.bookRent.globalResponse.ResponseDTO;
import com.company.bookRent.globalResponse.ResponseType;
import com.company.bookRent.jwt.JwtToken;
import com.company.bookRent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseDTO<String> signup(@RequestBody UserSignupDTO userSignupDTO) {
        User user = User.createUser(userSignupDTO, passwordEncoder);
        userService.save(user);
        return ResponseDTO.from(ResponseType.CREATED, user.getLoginId());
    }

    @GetMapping("/login")
    public ResponseDTO<JwtToken> login(@RequestBody UserLoginDTO loginDTO) {
        String loginId = loginDTO.getLoginId();
        String password = loginDTO.getPassword();
        JwtToken jwtToken = userService.signIn(loginId, password);
        return ResponseDTO.from(ResponseType.SUCCESS, jwtToken);
    }


}
