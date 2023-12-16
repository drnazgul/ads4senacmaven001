package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "contato")
public class Contato extends BaseModel {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    //Relacionamento Bi-direcional
    /**
     * Sugestão é sempre LAZY (forma preguiçosa de fazer a consulta).
     * A consulta é realizada somente quando a propriedade é 'invocada'.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa pessoa;
    /**
     * A configuração @OneToMany por padrão o fetch é sempre LAZY
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Email> emails = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Telefone> telefones = new HashSet<>();
}
