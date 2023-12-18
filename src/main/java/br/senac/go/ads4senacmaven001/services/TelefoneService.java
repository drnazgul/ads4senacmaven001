package br.senac.go.ads4senacmaven001.services;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.domain.Telefone;
import br.senac.go.ads4senacmaven001.generics.IService;
import br.senac.go.ads4senacmaven001.repositories.PessoaRepository;
import br.senac.go.ads4senacmaven001.repositories.TelefoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class TelefoneService implements IService<Telefone, Integer> {

    /**
     * @Autowired fazer a injeção de dependênciada classe
     */
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public Telefone create(Telefone entity) {
        log.info("Método TelefoneService.create invocado.");
        log.debug("Valores informados TelefoneService.create {}", entity);

        return this.telefoneRepository.save(entity);
    }

    @Override
    public Telefone readById(Integer id) throws Exception {
        log.info("Método TelefoneService.readById invocado");
        log.debug("Valores informados TelefoneService.readById {}", id);

        Telefone telefone = this.telefoneRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em TelefoneService.readById são {}", telefone);
        return telefone;
    }

    @Override
    public Telefone read(Telefone entity) throws Exception {

        log.info("Método TelefoneService.read invocado");
        log.debug("Valores informados TelefoneService.read {}", entity);

        Example<Telefone> telefoneAprocurar = Example.of(entity);
        Telefone telefone = this.telefoneRepository
                .findOne(telefoneAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em TelefoneService.read são {}", telefone);

        return telefone;
    }


    @Override
    public List<Telefone> readAll() {

        log.info("Método TelefoneService.read invocado");

        List<Telefone> telefones = this.telefoneRepository
                .findAll();

        log.debug("Valores recuperados em TelefoneService.read são {}", telefones);

        return telefones;
    }

    @Override
    @Transactional
    public Telefone updatePatch(Telefone entity, Integer id) throws Exception {
        log.info("Método TelefoneService.updatePatch invocado");
        log.debug("Valores informados TelefoneService.updatePatch {} {}", entity, id);


        boolean registroEncontrado = this.telefoneRepository.findById(id).isPresent();
        Telefone telefoneAtualizada;

        if(registroEncontrado) {
            entity.setId(id);
            telefoneAtualizada = this.telefoneRepository.save(entity);
        }
        else {
            log.error("Error: TelefoneService.updatePatch ao atualizar registro: {} {}",
                    entity, id);
            throw new Exception("Erro ao atualizar regitro");
        }


        log.debug("Valores atualizados em TelefoneService.updatePatch são {}", telefoneAtualizada);

        return telefoneAtualizada;
    }

    @Override
    @Transactional
    public Telefone updatePut(Telefone entity, Integer id) {
        log.info("Método TelefoneService.updatePatch invocado");
        log.debug("Valores informados TelefoneService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em TelefoneService.updatePatch são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public Telefone deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Telefone delete(Telefone entity) {
        return null;
    }
}
