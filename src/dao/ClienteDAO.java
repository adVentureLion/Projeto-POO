package dao;

import java.util.Iterator;
import java.util.Set;
import database.ClienteDB;
import models.Cliente;

public class ClienteDAO extends ClienteDB implements InterClienteDAO {
    private Set<Cliente> clientes;
   
    public ClienteDAO() {
        this.clientes = super.listarClientes();
    }

    @Override
    public boolean adicionarCliente(Cliente cliente) {
        Iterator<Cliente> cIterator = this.clientes.iterator();
        boolean adicionou = true;

        while(cIterator.hasNext()) {
            Cliente c = cIterator.next();
            if(c.getCpf().equals(cliente.getCpf()))
                adicionou = false;
            else
                adicionou = true;
        }
        if(adicionou)
            this.clientes.add(cliente);

        return adicionou;
    }

    @Override
    public void excluirCliente(String nome) {
        this.clientes.removeIf(cliente -> cliente.getNome() == nome);
    }

    // @Override
    // public boolean atualizarDadosCliente(Cliente cliente) {
    //     Iterator<Cliente> cIterator = this.clientes.iterator();
    //     while(cIterator.hasNext()) {
    //         Cliente c = cIterator.next();
    //         if(c.getNome().equals(cliente.getNome())) {
    //             c.ge
    //         }
    //     }
    // }

    @Override
    public Set<Cliente> exibirClientes() {
        return this.clientes;
    }
}
