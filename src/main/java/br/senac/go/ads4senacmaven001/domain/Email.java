package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email")
public class Email extends BaseModel{

    @Column(length = 50, nullable = false)
    private String enderecoEmail;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @ManyToOne
    private Contato contato;
}
