package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Telefone;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.TelefoneService;
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
@RequestMapping(path = "/telefone")
@Api(value="Operações para manipulação dos dados do Telefone", tags = "Telefone")
public class TelefoneResource implements GenericOperationsResource<Telefone, Integer> {

    @Autowired
    TelefoneService telefoneService;

    private static final Logger LOGGER =
            Logger.getLogger(TelefoneResource.class.getName());

    @Override
    @ApiOperation(
            value="${resource.telefone-post}",
            notes="Criar dados de Telefone.")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Telefone.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Telefone.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Telefone.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Telefone.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Telefone.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Telefone.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Telefone post(@RequestBody @Validated Telefone entity) {
        LOGGER.log(Level.INFO,"TelefoneResource.post inicado {} ", entity);

        Telefone telefonePersitida = this.telefoneService.create(entity);
        LOGGER.log(Level.INFO,"TelefoneResource.post concluído {} ", telefonePersitida);

        return telefonePersitida;
    }

    @Override
    @ApiOperation(
            value="${resource.telefone-get}",
            notes="Solicitar dados de Telefone.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso solicitado foi enviado na resposta.", response = Telefone.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado não foi encontrado.", response = Telefone.class),
            @ApiResponse(code = 406, message = "Not Acceptable: O servidor não pode produzir uma resposta que corresponda à lista de valores aceitáveis definidos nas headers da requisição.", response = Telefone.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Telefone.class)
    })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Telefone> get(@PathVariable("id") int id) {
        LOGGER.log(Level.INFO,"TelefoneResource.get iniciado", id);

        List<Telefone> telefoneList = this.telefoneService.readAll();
        LOGGER.log(Level.INFO,"TelefoneResource.get concluído", telefoneList);

        return telefoneList;
    }

    @Override
    @ApiOperation(
            value="${resource.telefone-put}",
            notes="Atualizar ou criar dados de Telefone.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado.", response = Telefone.class),
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Telefone.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Telefone.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Telefone.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Telefone.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Telefone.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Telefone.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated Telefone entity, @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, String.format("Executado método TelefoneResource.put: %s | %d", entity, id));

        this.telefoneService.updatePut(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.telefone-patch}",
            notes="Atualizar parcialmente dados de Telefone.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado parcialmente.", response = Telefone.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Telefone.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Telefone.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Telefone.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Telefone.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Telefone.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Telefone.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated Telefone entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO, String.format("Executado método TelefoneResource.patch: %s | %d", entity, id));

        this.telefoneService.updatePatch(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.telefone-delete}",
            notes="Remover dados de Telefone.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Telefone.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Telefone.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = Telefone.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Telefone.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Telefone.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Telefone.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated Telefone entity) {
        LOGGER.log(Level.INFO,
                String.format("Executado método TelefoneResource.delete: %s", entity));
    }

    @Override
    @ApiOperation(
            value="${resource.telefone-deleteById}",
            notes="Remover dados de Telefone por ID.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Telefone.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Telefone.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = Telefone.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Telefone.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Telefone.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Telefone.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Executado método TelefoneResource.deleteById: %d", id));
    }
}
