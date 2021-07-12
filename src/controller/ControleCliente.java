package controller;

import java.util.List;

import dao.ClienteDAO;
import models.Cliente;

public class ControleCliente {
    private ClienteDAO clienteDAO;

    public ControleCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clienteDAO.adicionarCliente(cliente);
    }

    public List<Cliente> listarClienteController() {
        return this.clienteDAO.listarClientes();
    }
}
