package br.senac.go.ads4senacmaven001.generics;

import br.senac.go.ads4senacmaven001.domain.Pessoa;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface GenericOperationsResource<E,N> {

    /**
     * Quando a pessoa for mandar um post, a aplicação
     * recebe uma entidade(E) e retorna a entidade (e) com o campo
     * id preenchido
     * @param entity
     * @return
     */
    E post(E entity);

    /**
     * Retorna uma lista de entidades
     * @return
     */
    List<E> get(int i);


    /**
     * Atualiza TODO o registro
     * @param entity
     * @param id
     */
    void put(E entity, N id);

    /**
     * Atualiza parcialmente um registro
     * @param entity
     * @param id
     */
    void patch(E entity, N id) throws Exception;

    /**
     * Deleta um registro no banco;
     * @param entity
     */
    void delete(E entity);

    /**
     * Deleta um registro no banco pelo identificador
     * @param id
     */
    void deleteById(N id);
}
