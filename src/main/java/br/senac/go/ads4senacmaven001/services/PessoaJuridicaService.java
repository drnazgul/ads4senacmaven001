package br.senac.go.ads4senacmaven001.services;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.domain.PessoaJuridica;
import br.senac.go.ads4senacmaven001.generics.IService;
import br.senac.go.ads4senacmaven001.repositories.PessoaJuridicaRepository;
import br.senac.go.ads4senacmaven001.repositories.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class PessoaJuridicaService implements IService<PessoaJuridica, Integer> {

    /**
     * @Autowired fazer a injeção de dependênciada classe
     */
    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Override
    @Transactional
    public PessoaJuridica create(PessoaJuridica entity) {
        log.info("Método PessoaJuridicaService.create invocado.");
        log.debug("Valores informados PessoaJuridicaService.create {}", entity);

        return this.pessoaJuridicaRepository.save(entity);
    }

    @Override
    public PessoaJuridica readById(Integer id) throws Exception {
        log.info("Método PessoaJuridicaService.readById invocado");
        log.debug("Valores informados PessoaJuridicaService.readById {}", id);

        PessoaJuridica pessoaJuridica = this.pessoaJuridicaRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaJuridicaService.readById são {}", pessoaJuridica);
        return pessoaJuridica;
    }

    @Override
    public PessoaJuridica read(PessoaJuridica entity) throws Exception {

        log.info("Método PessoaJuridicaService.read invocado");
        log.debug("Valores informados PessoaJuridicaService.read {}", entity);

        Example<PessoaJuridica> pessoaJuridicaAprocurar = Example.of(entity);
        PessoaJuridica pessoaJuridica = this.pessoaJuridicaRepository
                .findOne(pessoaJuridicaAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em PessoaService.read são {}", pessoaJuridica);

        return pessoaJuridica;
    }


    @Override
    public List<PessoaJuridica> readAll() {

        log.info("Método PessoaJuridicaService.read invocado");

        List<PessoaJuridica> pessoaJuridicas = this.pessoaJuridicaRepository
                .findAll();

        log.debug("Valores recuperados em PessoaJuridicaService.read são {}", pessoaJuridicas);

        return pessoaJuridicas;
    }

    @Override
    @Transactional
    public PessoaJuridica updatePatch(PessoaJuridica entity, Integer id) throws Exception {
        log.info("Método PessoaJuridicaService.updatePatch invocado");
        log.debug("Valores informados PessoaJuridicaService.updatePatch {} {}", entity, id);

        boolean registroEncontrado = this.pessoaJuridicaRepository.findById(id).isPresent();
        PessoaJuridica pessoaJuridicaAtualizada;

        if(registroEncontrado) {
            entity.setId(id);
            pessoaJuridicaAtualizada = this.pessoaJuridicaRepository.save(entity);
        }
        else {
            log.error("Error: PessoaJuridicaService.updatePatch ao atualizar registro: {} {}",
                    entity, id);
            throw new Exception("Erro ao atualizar regitro");
        }


        log.debug("Valores atualizados em PessoaJuridicaService.updatePatch são {}", pessoaJuridicaAtualizada);

        return pessoaJuridicaAtualizada;
    }

    @Override
    @Transactional
    public PessoaJuridica updatePut(PessoaJuridica entity, Integer id) {
        log.info("Método PessoaJuridicaService.updatePatch invocado");
        log.debug("Valores informados PessoaJuridicaService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em PessoaJuridicaService.updatePatch são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public PessoaJuridica deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public PessoaJuridica delete(PessoaJuridica entity) {
        return null;
    }
}
