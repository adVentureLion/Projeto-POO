package dao;

import java.util.List;

import models.Cliente;

public interface InterClienteDAO {
    public void adicionarCliente(Cliente cliente);

    public void excluirCliente(Cliente cliente);

    public void atualizarDados(Cliente cliente);

    public List<Cliente> listarClientes();
}
