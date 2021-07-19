package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import models.Cliente;
import models.Produto;
import models.VendaCliente;
import models.VendaProduto;

public class VendasDB {
    private static final String caminho = "src" + System.getProperty("file.separator")+ "arquivos" +
                                           System.getProperty("file.separator") + "Vendas.txt";

    
    protected static void atualizarAqurivoVendas(List<VendaCliente> vendas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            bw.write(vendas.toString() + System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static List<VendaCliente> listarVendas() {
        List<VendaCliente> vendas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            List<VendaProduto> vendaProdutos = new ArrayList<>();
            System.out.println(linha);
            while(linha != null) {
                System.out.println("as");
                String[] atributos = linha.split(";");
                String nomeCliente = atributos[0];
                String cpfCliente = atributos[1];
                String produtos = atributos[2];
                System.out.println(produtos.length());
                while(produtos != null) {
                    String[] produto = produtos.split(":");
                    for (String string : produto) {
                        System.out.println(string);
                    }
                    for(int i=0; i < produto.length; i++){
                        String[] atribProd = produto[i].split(",");
                        String nomeProduto = atribProd[0];
                        System.out.println(nomeProduto);
                        Double valorProduto = Double.parseDouble(atribProd[1]);
                        System.out.println(valorProduto);
                        Produto p = new Produto(nomeProduto, valorProduto);
                        VendaProduto vendaProduto = new VendaProduto(p);
                        vendaProdutos.add(vendaProduto);
                    }
                    
                }
                Double valorVenda = Double.parseDouble(atributos[3]);
                SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date dt = new Date();
                try {
                    dt = dataFormatada.parse(atributos[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                GregorianCalendar dataDaVenda = new GregorianCalendar();
                dataDaVenda.setTime(dt);
                Cliente cliente = new Cliente(nomeCliente, cpfCliente);
                VendaCliente vendaFeita = new VendaCliente(vendaProdutos, cliente);
                vendaFeita.setValorDaVenda(valorVenda);
                vendaFeita.setDataVenda(dataDaVenda);
                vendas.add(vendaFeita);
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return vendas;
    }
}
