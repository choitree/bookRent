package com.company.bookRent.controller;

import com.company.bookRent.controller.dto.RentalResponseDTO;
import com.company.bookRent.domain.Rental;
import com.company.bookRent.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RentalController {

    private final RentalService rentalService;

    private String getLoginId(final String accessToken) {
        final String payloadJWT = accessToken.split("\\.")[1];
        Base64.Decoder decoder = Base64.getUrlDecoder();

        final String payload = new String(decoder.decode(payloadJWT));
        JsonParser jsonParser = new BasicJsonParser();
        Map<String, Object> jsonArray = jsonParser.parseMap(payload);

        if(!jsonArray.containsKey("sub")) {
            throw new RuntimeException("유효하지 않은 AccessToken입니다.");
        }
        return jsonArray.get("sub").toString();

    }

    @GetMapping("/rental")
    public List<RentalResponseDTO> getRentalList(@RequestParam Long bookId) {
        return rentalService.getRentalList(bookId);
    }

    @PostMapping("/rental")
    public void rentBook(@RequestParam Long bookId, @RequestHeader("Authorization") String bearerToken) {
        String loginId = getLoginId(bearerToken);
        rentalService.rentBook(bookId, loginId);
    }

    @PutMapping("/rental")
    public void returnBook(@RequestParam Long bookId, @RequestHeader("Authorization") String bearerToken) {
        String loginId = getLoginId(bearerToken);
        rentalService.returnBook(bookId, loginId);
    }
}
