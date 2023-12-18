package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "telefone")
public class Telefone extends BaseModel {

    @Column(length = 2, nullable = false)
    private String ddd;

    @Column(length = 20, nullable = false)
    private String numero;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contato contato;
}
