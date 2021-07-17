package controller;

import java.util.Set;

import dao.ClienteDAO;
import models.Cliente;

public class ControleCliente {
    private ClienteDAO clienteDAO;

    public void iniciarClientes() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean adicionarClienteController(Cliente cliente) {
        return this.clienteDAO.adicionarCliente(cliente);
    }
    
    public boolean excluirCliente(String nome){
        return this.clienteDAO.excluirCliente(nome);
    }

    public Set<Cliente> listarClienteController() {
        return this.clienteDAO.exibirClientes();
    }

    public Set<Cliente> listarClienteExcluidosController() {
        return this.clienteDAO.exibirClientesExcluidos();
    }

    public void atualizarClientesController() {
        this.clienteDAO.atualizarClientes();
    }
}

