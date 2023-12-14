package br.senac.go.ads4senacmaven001.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;
}
