package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Endereco;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;

import java.util.List;

public class ContatoResource implements GenericOperationsResource<Contato, Integer> {
    /**
     * Quando a pessoa for mandar um post, a aplicação
     * recebe uma entidade(E) e retorna a entidade (e) com o campo
     * id preenchido
     *
     * @param entity
     * @return
     */
    @Override
    public Contato post(Contato entity) {
        return null;
    }

    /**
     * Retorna uma lista de entidades
     *
     * @return
     */
    @Override
    public List<Contato> get() {
        return null;
    }

    /**
     * Atualiza TODO o registro
     *
     * @param entity
     * @param id
     */
    @Override
    public void put(Contato entity, Integer id) {

    }

    /**
     * Atualiza parcialmente um registro
     *
     * @param entity
     * @param id
     */
    @Override
    public void patch(Contato entity, Integer id) {

    }

    /**
     * Deleta um registro no banco;
     *
     * @param entity
     */
    @Override
    public void delete(Contato entity) {

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
