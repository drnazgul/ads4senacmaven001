package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "endereco")
public class Endereco extends BaseModel{

    @Column(length = 100, nullable = false)
    private String logradouro;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contato contato;

}
