package dao;

import java.util.Set;

import models.Cliente;

public interface InterClienteDAO {
    public boolean adicionarCliente(Cliente cliente);

    public void excluirCliente(String nome);

    //public boolean atualizarDadosCliente(Cliente cliente);

    public Set<Cliente> exibirClientes();
}
