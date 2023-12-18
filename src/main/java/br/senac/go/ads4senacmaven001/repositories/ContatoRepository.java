package br.senac.go.ads4senacmaven001.repositories;

import br.senac.go.ads4senacmaven001.domain.Contato;
import br.senac.go.ads4senacmaven001.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    List<Contato> searchById(Integer id);
}
