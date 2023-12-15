package br.senac.go.ads4senacmaven001.resources;

import br.senac.go.ads4senacmaven001.domain.Endereco;
import br.senac.go.ads4senacmaven001.generics.GenericOperationsResource;

import java.util.List;

public class EnderecoResource implements GenericOperationsResource<Endereco, Integer> {

    @Override
    public Endereco post(Endereco entity) {
        return null;
    }

    @Override
    public List<Endereco> get(int i) {
        return null;
    }

    @Override
    public void put(Endereco entity, Integer id) {

    }

    @Override
    public void patch(Endereco entity, Integer id) throws Exception {

    }

    @Override
    public void delete(Endereco entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
