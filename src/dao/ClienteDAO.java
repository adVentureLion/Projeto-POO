package dao;

import java.util.Iterator;
import java.util.Set;
import database.ClienteDB;
import models.Cliente;

public class ClienteDAO extends ClienteDB implements InterClienteDAO {
    private Set<Cliente> clientes;
    private Set<Cliente> clientesExcluidos;
   
    public ClienteDAO() {
        this.clientes = super.listarClientes();
        this.clientesExcluidos = super.listarClientesExcluidos();
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
    public boolean excluirCliente(String nome) {
        Iterator<Cliente> cIterator = this.clientes.iterator();
        boolean excluiu = false;
        while(cIterator.hasNext()) {
            Cliente c = cIterator.next();
            if(c.getNome().equals(nome)) {
                this.clientesExcluidos.add(c);
                excluiu = true;
            }
        }
        this.clientes.removeIf(cliente -> cliente.getNome().equals(nome));
        return excluiu;
    }

    @Override
    public Set<Cliente> exibirClientes() {
        return this.clientes;
    }

    @Override
    public Set<Cliente> exibirClientesExcluidos() {
        return this.clientesExcluidos;
    }
}
