package br.senac.go.ads4senacmaven001.repositories;

import br.senac.go.ads4senacmaven001.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    List<Email> searchById(Integer id);
}
