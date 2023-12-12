package com.company.bookRent.controller;

import com.company.bookRent.controller.dto.RentalResponseDTO;
import com.company.bookRent.exception.IllegalAccessTokenException;
import com.company.bookRent.globalResponse.ResponseDTO;
import com.company.bookRent.globalResponse.ResponseType;
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
            throw new IllegalAccessTokenException();
        }
        return jsonArray.get("sub").toString();

    }

    @GetMapping("/rental")
    public ResponseDTO<List<RentalResponseDTO>> getRentalList(@RequestParam Long bookId) {
        List<RentalResponseDTO> response = rentalService.getRentalList(bookId);
        return ResponseDTO.from(ResponseType.SUCCESS, response);
    }

    @PostMapping("/rental")
    public ResponseDTO<RentalResponseDTO> rentBook(@RequestParam Long bookId, @RequestHeader("Authorization") String bearerToken) {
        String loginId = getLoginId(bearerToken);
        RentalResponseDTO response = rentalService.rentBook(bookId, loginId);
        return ResponseDTO.from(ResponseType.SUCCESS, response);
    }

    @PutMapping("/rental")
    public ResponseDTO<RentalResponseDTO> returnBook(@RequestParam Long bookId, @RequestHeader("Authorization") String bearerToken) {
        String loginId = getLoginId(bearerToken);
        RentalResponseDTO response = rentalService.returnBook(bookId, loginId);
        return ResponseDTO.from(ResponseType.SUCCESS, response);
    }
}
