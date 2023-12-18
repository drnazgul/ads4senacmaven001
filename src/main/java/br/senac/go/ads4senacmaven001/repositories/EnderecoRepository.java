package br.senac.go.ads4senacmaven001.repositories;

import br.senac.go.ads4senacmaven001.domain.Endereco;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    //List<Pessoa> findPessoaByNomeAndAndDataInicioOrDataFimAndContatos();
    List<Endereco> searchById(Integer id);
}
