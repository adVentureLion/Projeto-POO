package dao;

import java.util.List;

import database.ClienteDB;
import models.Cliente;

public class ClienteDAO extends ClienteDB implements InterClienteDAO {

    @Override
    public void adicionarCliente(Cliente cliente) {
        super.adicionarCliente(cliente);
    }
    @Override
    public void excluirCliente(Cliente cliente) {
    }

    @Override
    public void atualizarDados(Cliente cliente) {

    }

    @Override
    public List<Cliente> listarClientes() {
        return super.listarClientes();
    }
}
