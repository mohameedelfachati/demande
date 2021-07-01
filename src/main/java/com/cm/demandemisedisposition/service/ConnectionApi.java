package com.cm.demandemisedisposition.service;

import com.cm.demandemisedisposition.domain.Voiture;
import com.cm.demandemisedisposition.security.SecurityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConnectionApi {
    String baseUrl="http://localhost:8080/services";
    public WebClient webClient(){
        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION,"Bearer "+ SecurityUtils.getCurrentUserJWT().get())
            .build();
    }

    public Flux<Voiture> getVoiture(){
        return webClient().get()
            .uri(baseUrl+"/voiture/api/voitures").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(Voiture.class);
    }
    public Mono<Voiture> getVoiture(String matricule){
        return webClient().get()
            .uri("/voiture/api/voitures1/"+matricule)
            .retrieve().bodyToMono(Voiture.class);
    }
     public Mono<Voiture> ubdateStatus(Voiture voiture){
        System.out.println(voiture.getStatus());
        return webClient().put()
            .uri("/voiture/api/voitures")
            .bodyValue(voiture)
            .retrieve().bodyToMono(Voiture.class);
    }
}
