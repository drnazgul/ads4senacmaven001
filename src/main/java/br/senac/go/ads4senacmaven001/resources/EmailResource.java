package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;
import br.senac.go.ads4senacmaven001.services.EmailService;
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
@RequestMapping(path = "/email")
@Api(value = "Operações para manipulação dos dados do Email", tags = "Email")
public class EmailResource implements GenericOperationsResource<Email, Integer> {


    @Autowired
    EmailService emailService;


    private static final Logger LOGGER =
            Logger.getLogger(EmailResource.class.getName());


    /**
     * Quando a pessoa for mandar um post, a aplicação
     * recebe uma entidade(E) e retorna a entidade (e) com o campo
     * id preenchido
     *
     * @param entity
     * @return
     */
    @Override
    @ApiOperation(
            value="${resource.email-post}",
            notes="Criar dados de Email.")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Email.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Email.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Email.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Email.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Email.class)
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Email post(@RequestBody @Validated Email entity) {
        LOGGER.log(Level.INFO,"EmailResource.post inicado {} ", entity);

        Email emailPersitida = this.emailService.create(entity);
        LOGGER.log(Level.INFO,"EmailResource.post concluído {} ", emailPersitida);

        return emailPersitida;
    }


    /**
     * Retorna uma lista de entidades
     *
     * @return
     */
    @Override
    @ApiOperation(
            value="${resource.email-get}",
            notes="Solicitar dados de Email.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso solicitado foi enviado na resposta.", response = Email.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado não foi encontrado.", response = Email.class),
            @ApiResponse(code = 406, message = "Not Acceptable: O servidor não pode produzir uma resposta que corresponda à lista de valores aceitáveis definidos nas headers da requisição.", response = Email.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Email.class)
    })
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Email> get(@PathVariable("id") int id) {
        LOGGER.log(Level.INFO,"EmailResource.get iniciado", id);

        List<Email> emailList = this.emailService.readAll();
        LOGGER.log(Level.INFO,"EmailResource.get concluído", emailList);

        return emailList;
    }

    /**
     * Atualiza TODO o registro
     *
     * @param entity
     * @param id
     */
    @Override
    @ApiOperation(
            value="${resource.email-put}",
            notes="Atualizar ou criar dados de Email.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado.", response = Email.class),
            @ApiResponse(code = 201, message = "Created: A requisição foi bem-sucedida e um novo recurso foi criado.", response = Email.class),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Email.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Email.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Email.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Email.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Email.class)
    })
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated Email entity, @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO, String.format("Executado método EmailResource.put: %s | %d", entity, id));

        this.emailService.updatePut(entity, id);
    }

    /**
     * Atualiza parcialmente um registro
     *
     * @param entity
     * @param id
     */
    @Override
    @ApiOperation(
            value="${resource.email-patch}",
            notes="Atualizar parcialmente dados de Email.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi atualizado parcialmente.", response = Email.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 400, message = "Bad Request: A requisição é inválida ou malformada.", response = Email.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Email.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para atualização não foi encontrado.", response = Email.class),
            @ApiResponse(code = 409, message = "Conflict: A requisição não pôde ser concluída devido a um conflito com o estado atual do recurso.", response = Email.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Email.class)
    })
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated Email entity, @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO, String.format("Executado método EmailResource.patch: %s | %d", entity, id));

        this.emailService.updatePatch(entity, id);
    }

    /**
     * Deleta um registro no banco;
     *
     * @param entity
     */
    @Override
    @ApiOperation(
            value="${resource.email-delete}",
            notes="Remover dados de Email.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Email.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Email.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta."),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Email.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Email.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Email.class)
    })
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated Email entity) {
        LOGGER.log(Level.INFO,
                String.format("Executado método EmailResource.delete: %s", entity));
    }

    /**
     * Deleta um registro no banco pelo identificador
     *
     * @param id
     */
    @Override
    @ApiOperation(
            value="${resource.email-deleteById}",
            notes="Remover dados de Email por ID.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "OK: A requisição foi bem-sucedida e o recurso foi removido.", response = Email.class),
            @ApiResponse(code = 202, message = "Accepted: A requisição foi aceita para processamento, mas a conclusão do processamento ainda não ocorreu.", response = Email.class),
            @ApiResponse(code = 204, message = "No Content: A requisição foi bem-sucedida, mas não há conteúdo para enviar na resposta."),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Email.class),
            @ApiResponse(code = 404, message = "Not Found: O recurso solicitado para exclusão não foi encontrado.", response = Email.class),
            @ApiResponse(code = 500, message = "Erro na requisição, verifique configurações do servidor.", response = Email.class)
    })
    @DeleteMapping(value="/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Executado método EmailResource.deleteById: %d", id));
    }
}
