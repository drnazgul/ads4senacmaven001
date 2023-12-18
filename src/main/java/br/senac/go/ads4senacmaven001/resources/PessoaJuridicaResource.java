package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.PessoaJuridica;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.PessoaJuridicaService;
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
@RequestMapping(path = "/pessoaJuridica")
@Api(value="Operações para manipulação dos dados do Pessoa Juridica", tags = "PessoaJuridica")
public class PessoaJuridicaResource implements GenericOperationsResource<PessoaJuridica, Integer> {

    @Autowired
    PessoaJuridicaService pessoaJuridicaService;

    private static final Logger LOGGER =
            Logger.getLogger(PessoaJuridicaResource.class.getName());

    @Override
    @ApiOperation(
            value="${resource.pessoaJuridica-post}",
            notes="Criar dados de Pessoa Juridica.")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = PessoaJuridica.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = PessoaJuridica.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = PessoaJuridica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaJuridica.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = PessoaJuridica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaJuridica.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public PessoaJuridica post(@RequestBody @Validated PessoaJuridica entity) {
        LOGGER.log(Level.INFO,"PessoaJuridicaResource.post inicado {} ", entity);

        PessoaJuridica pessoaJuridicaPersitida = this.pessoaJuridicaService.create(entity);
        LOGGER.log(Level.INFO,"PessoaJuridicaResource.post concluído {} ", pessoaJuridicaPersitida);

        return pessoaJuridicaPersitida;
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaJuridica-get}",
            notes="Solicitar dados de Pessoa Juridica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso solicitado foi enviado na resposta.", response = PessoaJuridica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado não foi encontrado.", response = PessoaJuridica.class),
            @ApiResponse(code = 406, message = "Not Acceptable: O servidor não pode produzir uma resposta que corresponda à lista de valores aceitáveis definidos nas headers da requisição.", response = PessoaJuridica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaJuridica.class)
    })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PessoaJuridica> get(@PathVariable("id") int id) {
        LOGGER.log(Level.INFO,"PessoaJuridicaResource.get iniciado", id);

        List<PessoaJuridica> pessoaJuridicaList = this.pessoaJuridicaService.readAll();
        LOGGER.log(Level.INFO,"PessoaJuridicaResource.get concluído", pessoaJuridicaList);

        return pessoaJuridicaList;
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaJuridica-put}",
            notes="Atualizar ou criar dados de Pessoa Juridica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado.", response = PessoaJuridica.class),
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = PessoaJuridica.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = PessoaJuridica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaJuridica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = PessoaJuridica.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = PessoaJuridica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaJuridica.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated PessoaJuridica entity, @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, String.format("Executado método PessoaJuridicaResource.put: %s | %d", entity, id));

        this.pessoaJuridicaService.updatePut(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaJuridica-patch}",
            notes="Atualizar parcialmente dados de Pessoa Juridica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado parcialmente.", response = PessoaJuridica.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = PessoaJuridica.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = PessoaJuridica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaJuridica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = PessoaJuridica.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = PessoaJuridica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaJuridica.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated PessoaJuridica entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO, String.format("Executado método PessoaJuridicaResource.patch: %s | %d", entity, id));

        this.pessoaJuridicaService.updatePatch(entity, id);
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaJuridica-delete}",
            notes="Remover dados de Pessoa Juridica.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = PessoaJuridica.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = PessoaJuridica.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = PessoaJuridica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaJuridica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = PessoaJuridica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaJuridica.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated PessoaJuridica entity) {
        LOGGER.log(Level.INFO,
                String.format("Executado método PessoaJuridicaResource.delete: %s", entity));
    }

    @Override
    @ApiOperation(
            value="${resource.pessoaJuridica-deleteById}",
            notes="Remover dados de Pessoa Juridica por ID.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = PessoaJuridica.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = PessoaJuridica.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta.", response = PessoaJuridica.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = PessoaJuridica.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = PessoaJuridica.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = PessoaJuridica.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Executado método PessoaJuridicaResource.deleteById: %d", id));
    }
}
