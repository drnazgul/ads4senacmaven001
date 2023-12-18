package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.ContatoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/contato")
@Api(value="Operações para manipulação dos dados do Contato", tags = "Contato")
public class ContatoResource implements GenericOperationsResource<Contato, Integer> {

    @Autowired
    ContatoService contatoService;

    private static final Logger LOGGER =
            Logger.getLogger(ContatoResource.class.getName());

    @Override
    @ApiOperation(
            value="${resource.contato-post}",
            notes="Criar dados de Contato.")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Contato.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Contato.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Contato.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Contato.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Contato.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Contato.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Contato post(@RequestBody @Validated Contato entity) {
        LOGGER.log(Level.INFO,"ContatoResource.post inicado {} ", entity);

        Contato contatoPersitida = this.contatoService.create(entity);
        LOGGER.log(Level.INFO,"ContatoResource.post concluído {} ", contatoPersitida);

        return contatoPersitida;
    }

    @Override
    @ApiOperation(
            value="${resource.contato-get}",
            notes="Solicitar dados de Contato.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso solicitado foi enviado na resposta.", response = Contato.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado não foi encontrado.", response = Contato.class),
            @ApiResponse(code = 406, message = "Not Acceptable: O servidor não pode produzir uma resposta que corresponda à lista de valores aceitáveis definidos nas headers da requisição.", response = Contato.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Contato.class)
    })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Contato> get(@PathVariable("id") int id) {
        LOGGER.log(Level.INFO,"ContatoResource.get iniciado", id);

        List<Contato> contatoList = this.contatoService.readAll();
        LOGGER.log(Level.INFO,"ContatoResource.get concluído", contatoList);

        return contatoList;
    }

    @Override
    @ApiOperation(
            value="${resource.contato-put}",
            notes="Atualizar ou criar dados de Contato.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado.", response = Contato.class),
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Contato.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Contato.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Contato.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Contato.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Contato.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Contato.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated Contato entity, @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, String.format("Executado método ContatoResource.put: %s | %d", entity, id));

        this.contatoService.updatePut(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.contato-patch}",
            notes="Atualizar parcialmente dados de Contato.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado parcialmente.", response = Contato.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Contato.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Contato.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Contato.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Contato.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Contato.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Contato.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated Contato entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO, String.format("Executado método ContatoResource.patch: %s | %d", entity, id));

        this.contatoService.updatePatch(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.contato-delete}",
            notes="Remover dados de Contato.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Contato.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Contato.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = Contato.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Contato.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Contato.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Contato.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated Contato entity) {
        LOGGER.log(Level.INFO,
                String.format("Executado método ContatoResource.delete: %s", entity));
    }

    @Override
    @ApiOperation(
            value="${resource.contato-deleteById}",
            notes="Remover dados de Contato por ID.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Contato.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Contato.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = Contato.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Contato.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Contato.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Contato.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Executado método ContatoResource.deleteById: %d", id));
    }
}
