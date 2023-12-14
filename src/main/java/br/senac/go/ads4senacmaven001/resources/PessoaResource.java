package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.PessoaService;
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
@RequestMapping(path = "/pessoa")
@Api(value="Operações para manipulação dos dados do Pessoa", tags = "Pessoa")
public class PessoaResource implements GenericOperationsResource<Pessoa, Integer> {

    @Autowired
    PessoaService pessoaService;

    private static final Logger LOGGER =
            Logger.getLogger(PessoaResource.class.getName());

    @Override
    @ApiOperation(
            value="${resource.pessoa-post}",
            notes="Criar dados de Pessoa.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Pessoa.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Pessoa post(@RequestBody @Validated Pessoa entity) {
        LOGGER.log(Level.INFO,"PessoaResource.post inicado {} ", entity);

        Pessoa pessoaPersitida = this.pessoaService.create(entity);

        LOGGER.log(Level.INFO,"PessoaResource.post concluído {} ", pessoaPersitida);
        return pessoaPersitida;
    }

    @Override
    @ApiOperation(
            value="${resource.pessoa-get}",
            notes="Solicitar dados de Pessoa.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Pessoa.class)
    })
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Pessoa> get() {
        LOGGER.log(Level.INFO,"PessoaResource.get iniciado");

        List<Pessoa> pessoaList = this.pessoaService.readAll();

        LOGGER.log(Level.INFO,"PessoaResource.get concluído");
        return pessoaList;
    }

    @Override
    @ApiOperation(
            value="${resource.pessoa-put}",
            notes="Criar dados de Pessoa.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Pessoa.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated Pessoa entity,
                    @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do PUT: %s | %d", entity, id));

        this.pessoaService.updatePut(entity, id);

    }

    @Override
    @ApiOperation(
            value="${resource.pessoa-post}",
            notes="Criar dados de Pessoa.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Pessoa.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated Pessoa entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do PATCH: %s | %d", entity, id));

        this.pessoaService.updatePatch(entity, id);

    }

    @Override
    @ApiOperation(
            value="${resource.pessoa-post}",
            notes="Criar dados de Pessoa.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Pessoa.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated Pessoa entity) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do DELETE: %s", entity));
    }

    @Override
    @ApiOperation(
            value="${resource.pessoa-post}",
            notes="Criar dados de Pessoa.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Pessoa.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do DELETE: %d", id));
    }
}
