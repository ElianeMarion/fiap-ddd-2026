package br.com.fiap.agenda_web.dto;

public record ViaCepResponse(
        String logradouro,
        String cep,
        String bairro,
        String localidade,
        String estado,
        String uf,
        String complemento
) {
}
