package com.hbc.cadastro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pessoa_name")
    private String nome;

    @Column(name = "sobre_nome")
    private String sobreNome;

    @Column(name = "pessoa_telefone")
    private String telefone;

    @Column(name = "pessoa_email")
    private String email;


    
     
}