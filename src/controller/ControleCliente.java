package controller;

import java.util.Set;

import dao.ClienteDAO;
import models.Cliente;

public class ControleCliente {
    private ClienteDAO clienteDAO;

    public ControleCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean adicionarClienteController(Cliente cliente) {
        return this.clienteDAO.adicionarCliente(cliente);
    }
    
    public void excluirCliente(String nome){
        this.clienteDAO.excluirCliente(nome);
    }

    public Set<Cliente> listarClienteController() {
        return this.clienteDAO.listarClientes();
    }
}
