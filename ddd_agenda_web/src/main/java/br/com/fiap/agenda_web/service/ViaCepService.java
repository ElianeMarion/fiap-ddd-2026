package br.com.fiap.agenda_web.service;

import br.com.fiap.agenda_web.dto.ViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ViaCepService {
    private final RestClient restClient;

    public ViaCepService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://viacep.com.br/ws")
                .build();
    }
    public ViaCepResponse consultarCep(String cep){
        if(cep == null || !cep.matches("\\d{8}")){
            throw new IllegalArgumentException("O CEP " +
                    "deve conter exatamente 8 dígitos");
        }
        ViaCepResponse resposta = restClient.get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .body(ViaCepResponse.class);
        if(resposta == null)
            throw new IllegalArgumentException("CEP nao encontrado");
        return resposta;
    }
}
