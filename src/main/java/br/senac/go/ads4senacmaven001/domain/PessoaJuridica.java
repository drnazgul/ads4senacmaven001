package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends BaseModel {

    private String cnpj;
}
