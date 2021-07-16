package dao;

import java.util.Set;

import models.Cliente;

public interface InterClienteDAO {
    public boolean adicionarCliente(Cliente cliente);

    public boolean excluirCliente(String nome);

    public Set<Cliente> exibirClientes();
    
    public Set<Cliente> exibirClientesExcluidos();


}
