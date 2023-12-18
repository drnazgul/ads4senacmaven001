package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends BaseModel {

    @Column(length = 11, nullable = false)
    private String cpf;

    @OneToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;
}