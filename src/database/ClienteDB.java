package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;

public class ClienteDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Clientes.txt";

    public void adicionarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(cliente.toStringW());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();

            while(linha != null) {
                String[] atributos = linha.split(";");
                String nome = atributos[0];
                String dataNasci = atributos[1];
                String cpf = atributos[2];
                String sexo = atributos[3];

                Cliente cliente = new Cliente(nome, dataNasci, cpf, sexo);
                clientes.add(cliente);

                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        return clientes;
    }
}
