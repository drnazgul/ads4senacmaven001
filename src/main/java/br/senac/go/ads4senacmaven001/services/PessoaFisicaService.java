package br.senac.go.ads4senacmaven001.services;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.domain.PessoaFisica;
import br.senac.go.ads4senacmaven001.generics.IService;
import br.senac.go.ads4senacmaven001.repositories.PessoaFisicaRepository;
import br.senac.go.ads4senacmaven001.repositories.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PessoaFisicaService implements IService<PessoaFisica, Integer> {

    /**
     * @Autowired fazer a injeção de dependênciada classe
     */
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    @Transactional
    public PessoaFisica create(PessoaFisica entity) {
        log.info("Método PessoaFisicaService.create invocado.");
        log.debug("Valores informados PessoaFisicaService.create {}", entity);

        return this.pessoaFisicaRepository.save(entity);
    }

    @Override
    public PessoaFisica readById(Integer id) throws Exception {
        log.info("Método PessoaFisicaService.readById invocado");
        log.debug("Valores informados PessoaFisicaService.readById {}", id);

        PessoaFisica pessoaFisica = this.pessoaFisicaRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaFisicaService.readById são {}", pessoaFisica);
        return pessoaFisica;
    }

    @Override
    public PessoaFisica read(PessoaFisica entity) throws Exception {

        log.info("Método PessoaFisicaService.read invocado");
        log.debug("Valores informados PessoaFisicaService.read {}", entity);

        Example<PessoaFisica> pessoaFisicaAprocurar = Example.of(entity);
        PessoaFisica pessoaFisica = this.pessoaFisicaRepository
                .findOne(pessoaFisicaAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaFisicaService.read são {}", pessoaFisica);

        return pessoaFisica;
    }

    @Override
    public List<PessoaFisica> readAll() {

        log.info("Método PessoaFisicaService.read invocado");

        List<PessoaFisica> pessoaFisicas = this.pessoaFisicaRepository
                .findAll();

        log.debug("Valores recuperados em PessoaFisicaService.read são {}", pessoaFisicas);

        return pessoaFisicas;
    }

    @Override
    @Transactional
    public PessoaFisica updatePatch(PessoaFisica entity, Integer id) throws Exception {
        log.info("Método PessoaFisicaService.updatePatch invocado");
        log.debug("Valores informados PessoaFisicaService.updatePatch {} {}", entity, id);

        boolean registroEncontrado = this.pessoaFisicaRepository.findById(id).isPresent();
        PessoaFisica pessoaFisicaAtualizada;

        if(registroEncontrado) {
            entity.setId(id);
            pessoaFisicaAtualizada = this.pessoaFisicaRepository.save(entity);
        }
        else {
            log.error("Error: PessoaFisicaService.updatePatch ao atualizar registro: {} {}",
                    entity, id);
            throw new Exception("Erro ao atualizar regitro");
        }


        log.debug("Valores atualizados em PessoaFisicaService.updatePatch são {}", pessoaFisicaAtualizada);

        return pessoaFisicaAtualizada;
    }

    @Override
    @Transactional
    public PessoaFisica updatePut(PessoaFisica entity, Integer id) {
        log.info("Método PessoaFisicaService.updatePatch invocado");
        log.debug("Valores informados PessoaFisicaService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em PessoaFisicaService.updatePatch são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public PessoaFisica deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public PessoaFisica delete(PessoaFisica entity) {
        return null;
    }
}
