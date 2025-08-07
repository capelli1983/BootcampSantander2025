package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Optional<Cliente> buscarPorIdOptional(Long id);

    void inserir(Cliente cliente);

    void salvarClienteComCep(Cliente cliente);

    boolean atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}


