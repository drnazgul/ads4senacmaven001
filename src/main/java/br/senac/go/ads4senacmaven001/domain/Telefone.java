package br.senac.go.ads4senacmaven001.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "telefone")
public class Telefone extends BaseModel {
    private String ddd;
    private String numero;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    //private Contato contato;
}
