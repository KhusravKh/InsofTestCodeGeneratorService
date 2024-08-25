package com.example.insoftestcodegeneratorservice.services;

import com.example.insoftestcodegeneratorservice.dto.CodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class CodeGeneratorService {

    private final WebClient webClient;

    public List<CodeDto> generateCode() {
        var rand = new Random();
        var code = String.valueOf(1000 + rand.nextInt(9000));
        var codeDto = new CodeDto(code, code);
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

    public List<CodeDto> findAllCodes() {
        var codesDto = webClient
                .get()
                .uri("/get_codes")
                .retrieve()
                .bodyToFlux(CodeDto.class)
                .collectList()
                .block();
        return codesDto;
    }

}
