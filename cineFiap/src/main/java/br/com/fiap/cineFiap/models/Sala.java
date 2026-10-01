package br.com.fiap.cineFiap.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sala {

    private Long id;
    private String nome;
    private double preco;
    private LocalDateTime dataExclusao;
}
