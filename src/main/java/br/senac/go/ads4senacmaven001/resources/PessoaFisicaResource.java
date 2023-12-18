package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.PessoaFisica;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.PessoaFisicaService;
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
@RequestMapping(path = "/pessoafisica")
@Api(value="Operações para manipulação dos dados do PessoaFisica", tags = "PessoaFisica")
public class PessoaFisicaResource implements GenericOperationsResource<PessoaFisica, Integer> {

    @Autowired
    PessoaFisicaService pessoaFisicaService;

    private static final Logger LOGGER =
            Logger.getLogger(PessoaFisicaResource.class.getName());

    @Override
    @ApiOperation(
            value="${resource.pessoaFisica-post}",
            notes="Criar dados de Pessoa Fisica.")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = PessoaFisica.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = PessoaFisica.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = PessoaFisica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaFisica.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = PessoaFisica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaFisica.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public PessoaFisica post(@RequestBody @Validated PessoaFisica entity) {
        LOGGER.log(Level.INFO,"PessoaFisicaResource.post inicado {} ", entity);

        PessoaFisica pessoafisicaPersitida = this.pessoaFisicaService.create(entity);
        LOGGER.log(Level.INFO,"EmailResource.post concluído {} ", pessoafisicaPersitida);

        return pessoafisicaPersitida;
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaFisica-get}",
            notes="Solicitar dados de Pessoa Fisica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso solicitado foi enviado na resposta.", response = PessoaFisica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado não foi encontrado.", response = PessoaFisica.class),
            @ApiResponse(code = 406, message = "Not Acceptable: O servidor não pode produzir uma resposta que corresponda à lista de valores aceitáveis definidos nas headers da requisição.", response = PessoaFisica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaFisica.class)
    })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PessoaFisica> get(@PathVariable("id") int id) {
        LOGGER.log(Level.INFO,"PessoaFisicaResource.get iniciado", id);

        List<PessoaFisica> pessoaFisicaList = this.pessoaFisicaService.readAll();
        LOGGER.log(Level.INFO,"PessoaFisicaResource.get concluído", pessoaFisicaList);

        return pessoaFisicaList;
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaFisica-put}",
            notes="Atualizar ou criar dados de Pessoa Fisica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado.", response = PessoaFisica.class),
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = PessoaFisica.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = PessoaFisica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaFisica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = PessoaFisica.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = PessoaFisica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaFisica.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated PessoaFisica entity, @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, String.format("Executado método PessoaFisicaResource.put: %s | %d", entity, id));

        this.pessoaFisicaService.updatePut(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaFisica-patch}",
            notes="Atualizar parcialmente dados de Pessoa Fisica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado parcialmente.", response = PessoaFisica.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = PessoaFisica.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = PessoaFisica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaFisica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = PessoaFisica.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = PessoaFisica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaFisica.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated PessoaFisica entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO, String.format("Executado método PessoaFisicaResource.patch: %s | %d", entity, id));

        this.pessoaFisicaService.updatePatch(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaFisica-delete}",
            notes="Remover dados de Pessoa Fisica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = PessoaFisica.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = PessoaFisica.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = PessoaFisica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaFisica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = PessoaFisica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaFisica.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated PessoaFisica entity) {
        LOGGER.log(Level.INFO,
                String.format("Executado método PessoaFisicaResource.delete: %s", entity));
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaFisica-deleteById}",
            notes="Remover dados de Pessoa Fisica por ID.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = PessoaFisica.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = PessoaFisica.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = PessoaFisica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaFisica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = PessoaFisica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaFisica.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Executado método PessoaFisicaResource.deleteById: %d", id));
    }
}
