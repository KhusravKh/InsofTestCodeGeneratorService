package com.example.insoftestcodegeneratorservice.services;

import com.example.insoftestcodegeneratorservice.dto.CodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CodeGeneratorService {

    private final WebClient webClient;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<CodeDto> generateCode() {
        var rand = new Random();
        var code = String.valueOf(1000 + rand.nextInt(9000));
        var codeDto = new CodeDto(code, bCryptPasswordEncoder.encode(code));
        var codesDto = webClient
                .post()
                .uri("/code_save")
                .body(Mono.just(codeDto), CodeDto.class)
                .retrieve()
                .bodyToFlux(CodeDto.class)
                .collectList()
                .block();
        return codesDto;
    }

}
