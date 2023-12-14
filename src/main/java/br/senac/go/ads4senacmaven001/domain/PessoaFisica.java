package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends BaseModel {
    private String cpf;
}