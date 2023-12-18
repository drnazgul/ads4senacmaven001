package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Contato> contatos = new ArrayList<>();
}