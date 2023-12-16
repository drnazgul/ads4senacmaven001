package br.senac.go.ads4senacmaven001.generics;

import br.senac.go.ads4senacmaven001.domain.Email;

import java.util.List;

/**
 * C - create
 * R - readById
 * R - Read()
 * U - update
 * D - delete
 * @param <E>
 * @param <N>
 */
public interface IService<E,N> {

    E create(E entity);

    E readById(N id) throws Exception;

    E read(E entity) throws Exception;

    List<E> readAll();

    E updatePatch(E entity, N id) throws Exception;

    E updatePut(E entity, N id);

    E deleteById(N id);

    E delete(E entity);



}
