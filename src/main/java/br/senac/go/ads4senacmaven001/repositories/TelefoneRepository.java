package br.senac.go.ads4senacmaven001.repositories;

import br.senac.go.ads4senacmaven001.domain.Pessoa;
import br.senac.go.ads4senacmaven001.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

    //List<Pessoa> findPessoaByNomeAndAndDataInicioOrDataFimAndContatos();
    List<Telefone> searchById(Integer id);
}
