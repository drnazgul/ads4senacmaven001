package br.senac.go.ads4senacmaven001.services;

import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.generics.IService;
import br.senac.go.ads4senacmaven001.repositories.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class EmailService implements IService<Email, Integer> {


    @Autowired
    private EmailRepository emailRepository;


    @Override
    @Transactional
    public Email create(Email entity) {
        log.info("Método EmailService.create invocado.");
        log.debug("Valores informados EmailService.create {}", entity);

        return this.emailRepository.save(entity);
    }

    @Override
    public Email readById(Integer id) throws Exception {
        log.info("Método EmailService.readById invocado");
        log.debug("Valores informados EmailService.readById {}", id);

        Email email = this.emailRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));
        log.debug("Valores recuperados em EmailService.readById são {}", email);

        return email;
    }

    @Override
    public Email read(Email entity) throws Exception {

        log.info("Método EmailService.read invocado");
        log.debug("Valores informados EmailService.read {}", entity);

        Example<Email> emailAprocurar = Example.of(entity);
        Email email = this.emailRepository
                .findOne(emailAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaService.read são {}", email);

        return email;
    }

    @Override
    public List<Email> readAll() throws Exception {

        log.info("Método EmailService.read invocado");

        List<Email> emails = this.emailRepository
                .findAll();

        log.debug("Valores recuperados em EmailService.read são {}", emails);

        return emails;
    }


    @Override
    @Transactional
    public Email updatePatch(Email entity, Integer id) throws Exception {
        log.info("Método EmailService.updatePatch invocado");
        log.debug("Valores informados EmailService.updatePatch {} {}", entity, id);

        boolean registroEncontrado = this.emailRepository.findById(id).isPresent();
        Email emailAtualizada;

        if(registroEncontrado) {
            entity.setId(id);
            emailAtualizada = this.emailRepository.save(entity);
        }
        else {
            log.error("Error: EmailService.updatePatch ao atualizar registro: {} {}",
                    entity, id);
            throw new Exception("Erro ao atualizar regitro");
        }


        log.debug("Valores atualizados em EmailService.updatePatch são {}", emailAtualizada);

        return emailAtualizada;
    }

    @Override
    @Transactional
    public Email updatePut(Email entity, Integer id) {
        log.info("Método EmailService.updatePatch invocado");
        log.debug("Valores informados EmailService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em EmailService.updatePatch são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public Email deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Email delete(Email entity) {
        return null;
    }
}
