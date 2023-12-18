package br.senac.go.ads4senacmaven001.services;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.generics.IService;
import br.senac.go.ads4senacmaven001.repositories.ContatoRepository;
import br.senac.go.ads4senacmaven001.repositories.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ContatoService implements IService<Contato, Integer> {

    /**
     * @Autowired fazer a injeção de dependênciada classe
     */
    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    @Transactional
    public Contato create(Contato entity) {
        log.info("Método ContatoService.create invocado.");
        log.debug("Valores informados ContatoService.create {}", entity);

        return this.contatoRepository.save(entity);
    }

    @Override
    public Contato readById(Integer id) throws Exception {
        log.info("Método ContatoService.readById invocado");
        log.debug("Valores informados ContatoService.readById {}", id);

        Contato contato = this.contatoRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em ContatoService.readById são {}", contato);
        return contato;
    }

    @Override
    public Contato read(Contato entity) throws Exception {

        log.info("Método ContatoService.read invocado");
        log.debug("Valores informados ContatoService.read {}", entity);

        Example<Contato> contatoAprocurar = Example.of(entity);
        Contato contato = this.contatoRepository
                .findOne(contatoAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em ContatoService.read são {}", contato);

        return contato;
    }

    @Override
    public List<Contato> readAll() {

        log.info("Método ContatoService.read invocado");

        List<Contato> contatos = this.contatoRepository
                .findAll();

        log.debug("Valores recuperados em ContatoService.read são {}", contatos);

        return contatos;
    }

    @Override
    @Transactional
    public Contato updatePatch(Contato entity, Integer id) throws Exception {
        log.info("Método ContatoService.updatePatch invocado");
        log.debug("Valores informados ContatoService.updatePatch {} {}", entity, id);

        boolean registroEncontrado = this.contatoRepository.findById(id).isPresent();
        Contato contatoAtualizada;

        if(registroEncontrado) {
            entity.setId(id);
            contatoAtualizada = this.contatoRepository.save(entity);
        }
        else {
            log.error("Error: ContatoService.updatePatch ao atualizar registro: {} {}",
                    entity, id);
            throw new Exception("Erro ao atualizar regitro");
        }


        log.debug("Valores atualizados em ContatoService.updatePatch são {}", contatoAtualizada);

        return contatoAtualizada;
    }

    @Override
    @Transactional
    public Contato updatePut(Contato entity, Integer id) {
        log.info("Método ContatoService.updatePatch invocado");
        log.debug("Valores informados ContatoService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em ContatoService.updatePatch são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public Contato deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Contato delete(Contato entity) {
        return null;
    }
}
