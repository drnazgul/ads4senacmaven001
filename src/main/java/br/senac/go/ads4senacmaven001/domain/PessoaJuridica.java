package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends BaseModel {

    @Column(length = 14, nullable = false)
    private String cnpj;

    @OneToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;
}
