package br.senac.go.ads4senacmaven001.services;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Email;
import br.senac.go.ads4senacmaven001.domain.Endereco;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.generics.IService;
import br.senac.go.ads4senacmaven001.repositories.EnderecoRepository;
import br.senac.go.ads4senacmaven001.repositories.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class EnderecoService implements IService<Endereco, Integer> {

    /**
     * @Autowired fazer a injeção de dependênciada classe
     */
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public Endereco create(Endereco entity) {
        log.info("Método EnderecoService.create invocado.");
        log.debug("Valores informados EnderecoService.create {}", entity);

        return this.enderecoRepository.save(entity);
    }

    @Override
    public Endereco readById(Integer id) throws Exception {
        log.info("Método EnderecoService.readById invocado");
        log.debug("Valores informados EnderecoService.readById {}", id);

        Endereco endereco = this.enderecoRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em EnderecoService.readById são {}", endereco);
        return endereco;
    }

    @Override
    public Endereco read(Endereco entity) throws Exception {

        log.info("Método EnderecoService.read invocado");
        log.debug("Valores informados EnderecoService.read {}", entity);

        Example<Endereco> enderecoAprocurar = Example.of(entity);
        Endereco endereco = this.enderecoRepository
                .findOne(enderecoAprocurar)
                .orElseThrow(() -> new Exception("Registro não encontrado."));

        log.debug("Valores recuperados em EnderecoService.read são {}", endereco);

        return endereco;
    }

    @Override
    public List<Endereco> readAll() {

        log.info("Método EnderecoService.read invocado");

        List<Endereco> enderecos = this.enderecoRepository
                .findAll();

        log.debug("Valores recuperados em EnderecoService.read são {}", enderecos);

        return enderecos;
    }

    @Override
    @Transactional
    public Endereco updatePatch(Endereco entity, Integer id) throws Exception {
        log.info("Método EnderecoService.updatePatch invocado");
        log.debug("Valores informados EnderecoService.updatePatch {} {}", entity, id);

        boolean registroEncontrado = this.enderecoRepository.findById(id).isPresent();
        Endereco enderecoAtualizada;

        if(registroEncontrado) {
            entity.setId(id);
            enderecoAtualizada = this.enderecoRepository.save(entity);
        }
        else {
            log.error("Error: EnderecoService.updatePatch ao atualizar registro: {} {}",
                    entity, id);
            throw new Exception("Erro ao atualizar regitro");
        }


        log.debug("Valores atualizados em EnderecoService.updatePatch são {}", enderecoAtualizada);

        return enderecoAtualizada;
    }

    @Override
    @Transactional
    public Endereco updatePut(Endereco entity, Integer id) {
        log.info("Método EnderecoService.updatePatch invocado");
        log.debug("Valores informados EnderecoService.updatePatch {} {}", entity, id);

        log.debug("Valores recuperados em EnderecoService.updatePatch são {}", entity);

        return null;
    }

    @Override
    @Transactional
    public Endereco deleteById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Endereco delete(Endereco entity) {
        return null;
    }
}
