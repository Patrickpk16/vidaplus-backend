package com.vidaplus.backend.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String endereco;
}

