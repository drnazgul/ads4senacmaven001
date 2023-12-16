package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "pessoa")
public class Pessoa extends BaseModel {

    @Column(length = 50, nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PessoaFisica pessoaFisica;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PessoaJuridica pessoaJuridica;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();
}
