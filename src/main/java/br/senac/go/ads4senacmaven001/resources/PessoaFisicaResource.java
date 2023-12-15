package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.PessoaFisica;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;

import java.util.List;

public class PessoaFisicaResource implements
        GenericOperationsResource<PessoaFisica, Integer> {
    /**
     * Quando a pessoa for mandar um post, a aplicação
     * recebe uma entidade(E) e retorna a entidade (e) com o campo
     * id preenchido
     *
     * @param entity
     * @return
     */
    @Override
    public PessoaFisica post(PessoaFisica entity) {
        return null;
    }

    /**
     * Retorna uma lista de entidades
     *
     * @return
     */
    @Override
    public List<PessoaFisica> get(int i) {
        return null;
    }

    /**
     * Atualiza TODO o registro
     *
     * @param entity
     * @param id
     */
    @Override
    public void put(PessoaFisica entity, Integer id) {

    }

    /**
     * Atualiza parcialmente um registro
     *
     * @param entity
     * @param id
     */
    @Override
    public void patch(PessoaFisica entity, Integer id) {

    }

    /**
     * Deleta um registro no banco;
     *
     * @param entity
     */
    @Override
    public void delete(PessoaFisica entity) {

    }

    /**
     * Deleta um registro no banco pelo identificador
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {

    }
}
