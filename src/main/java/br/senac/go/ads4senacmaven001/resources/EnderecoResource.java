package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Endereco;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.EnderecoService;
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
@RequestMapping(path = "/endereco")
@Api(value="Operações para manipulação dos dados do Endereco", tags = "Endereco")
public class EnderecoResource implements GenericOperationsResource<Endereco, Integer> {

    @Autowired
    EnderecoService enderecoService;

    private static final Logger LOGGER =
            Logger.getLogger(EnderecoResource.class.getName());

    @Override
    @ApiOperation(
            value="${resource.endereco-post}",
            notes="Criar dados de Endereco.")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Endereco.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Endereco.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Endereco.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Endereco.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Endereco.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Endereco.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Endereco post(@RequestBody @Validated Endereco entity) {
        LOGGER.log(Level.INFO,"EnderecoResource.post inicado {} ", entity);

        Endereco enderecoPersitida = this.enderecoService.create(entity);
        LOGGER.log(Level.INFO,"EmailResource.post concluído {} ", enderecoPersitida);

        return enderecoPersitida;
    }

    @Override
    @ApiOperation(
            value="${resource.endereco-get}",
            notes="Solicitar dados de Endereco.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso solicitado foi enviado na resposta.", response = Endereco.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado não foi encontrado.", response = Endereco.class),
            @ApiResponse(code = 406, message = "Not Acceptable: O servidor não pode produzir uma resposta que corresponda à lista de valores aceitáveis definidos nas headers da requisição.", response = Endereco.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Endereco.class)
    })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Endereco> get(@PathVariable("id") int id) {
        LOGGER.log(Level.INFO,"EnderecoResource.get iniciado", id);

        List<Endereco> enderecoList = this.enderecoService.readAll();
        LOGGER.log(Level.INFO,"EnderecoResource.get concluído", enderecoList);

        return enderecoList;
    }

    @Override
    @ApiOperation(
            value="${resource.endereco-put}",
            notes="Atualizar ou criar dados de Endereco.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado.", response = Endereco.class),
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Endereco.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Endereco.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Endereco.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Endereco.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Endereco.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Endereco.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated Endereco entity, @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, String.format("Executado método EnderecoResource.put: %s | %d", entity, id));

        this.enderecoService.updatePut(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.endereco-patch}",
            notes="Atualizar parcialmente dados de Endereco.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado parcialmente.", response = Endereco.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Endereco.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Endereco.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Endereco.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Endereco.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Endereco.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Endereco.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated Endereco entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO, String.format("Executado método EnderecoResource.patch: %s | %d", entity, id));

        this.enderecoService.updatePatch(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.endereco-delete}",
            notes="Remover dados de Endereco.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Endereco.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Endereco.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = Endereco.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Endereco.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Endereco.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Endereco.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated Endereco entity) {
        LOGGER.log(Level.INFO,
                String.format("Executado método EnderecoResource.delete: %s", entity));
    }

    @Override
    @ApiOperation(
            value="${resource.endereco-deleteById}",
            notes="Remover dados de Endereco por ID.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Endereco.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Endereco.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = Endereco.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Endereco.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Endereco.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Endereco.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Executado método EnderecoResource.deleteById: %d", id));
    }
}
