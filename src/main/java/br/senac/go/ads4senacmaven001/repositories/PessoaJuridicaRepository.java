package br.senac.go.ads4senacmaven001.repositories;

import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.domain.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Integer> {

    //List<Pessoa> findPessoaByNomeAndAndDataInicioOrDataFimAndContatos();
    List<PessoaJuridica> searchById(Integer id);
}
