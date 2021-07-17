package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import controller.ControleCliente;
import models.Cliente;
import models.Produto;
import controller.ControleProduto;
public class ListarDados extends JFrame {
	
	ControleCliente controle = new ControleCliente();
	private Set<Cliente> clientes;
	ControleProduto controleProd = new ControleProduto();
	Set<Produto> produtos;
	
	private JPanel contentPane;
	private JTable tabelaCliente;
	private JTable tabelaProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarDados frame = new ListarDados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarDados() {
		
		controle.iniciarClientes();
		clientes = controle.listarClienteController();
		controleProd.iniciarProdutos();
		produtos = controleProd.listarProdutosController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(10, 45, 659, 293);
		contentPane.add(scrollPaneCliente);
		
		tabelaCliente = new JTable();
		tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "CPF", "DATA DE NASCIMENTO", "SEXO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(130);
		tabelaCliente.setFont(new Font("Century", Font.PLAIN, 12));
		scrollPaneCliente.setViewportView(tabelaCliente);
		DefaultTableModel auxCliente = (DefaultTableModel) tabelaCliente.getModel();
		
		JScrollPane scrollPaneProduto = new JScrollPane();
		scrollPaneProduto.setBounds(10, 45, 659, 293);
		contentPane.add(scrollPaneProduto);
		
		tabelaProduto = new JTable();
		tabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "C\u00D3DIGO", "VALOR", "QUANTIDADE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaProduto.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaProduto.getColumnModel().getColumn(3).setPreferredWidth(80);
		tabelaProduto.setFont(new Font("Century", Font.PLAIN, 12));
		tabelaProduto.setBounds(258, 361, 1, 1);
		scrollPaneProduto.setViewportView(tabelaProduto);
		DefaultTableModel auxProduto = (DefaultTableModel) tabelaProduto.getModel();
		
		JButton excluirCliente = new JButton("EXCLUIR");
		excluirCliente.setFont(new Font("Century", Font.PLAIN, 12));
		excluirCliente.setBounds(548, 363, 121, 23);
		contentPane.add(excluirCliente);
		
		JButton excluirProduto = new JButton("EXCLUIR");
		excluirProduto.setFont(new Font("Century", Font.PLAIN, 12));
		excluirProduto.setBounds(548, 363, 121, 23);
		contentPane.add(excluirProduto);
		
		JButton Estoque = new JButton("ESTOQUE");
		Estoque.setFont(new Font("Century", Font.PLAIN, 12));
		Estoque.setBounds(399, 363, 121, 23);
		contentPane.add(Estoque);
		
		for(Cliente listagem: clientes) {
			auxCliente.addRow(new String [] {listagem.getNome(), listagem.getCpf(), listagem.getDataNasci(), listagem.getSexo()});;
		}
		
		for(Produto listagemProd: produtos) {
			auxProduto.addRow(new String [] {listagemProd.getNome(), Integer.toString(listagemProd.getCodigo()) , Double.toString(listagemProd.getValor()), Integer.toString(listagemProd.getQtd())});;
		}
		
		
		JButton Cliente = new JButton("CLIENTE");
		Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				scrollPaneCliente.setVisible(true);
				tabelaCliente.setVisible(true);
				excluirProduto.setVisible(false);
				excluirCliente.setVisible(true);
				tabelaProduto.setVisible(false);
				scrollPaneProduto.setVisible(false);
				Estoque.setVisible(false);
			} catch(Exception q) {
				
			}
			}
		});
		Cliente.setFont(new Font("Century", Font.PLAIN, 12));
		Cliente.setBounds(10, 11, 113, 23);
		contentPane.add(Cliente);
		
		
		
		JButton Produto = new JButton("PRODUTO");
		Produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					scrollPaneProduto.setVisible(true);
					tabelaProduto.setVisible(true);
					tabelaCliente.setVisible(false);
					excluirProduto.setVisible(true);
					excluirCliente.setVisible(false);
					scrollPaneCliente.setVisible(false);
					Estoque.setVisible(true);
					
				} catch(Exception w) {
					
				}
			}
		});
		Produto.setFont(new Font("Century", Font.PLAIN, 12));
		Produto.setBounds(157, 11, 113, 23);
		contentPane.add(Produto);
		
		Cliente.setSelected(true);
		tabelaProduto.setVisible(false);
		scrollPaneProduto.setVisible(false);
		excluirProduto.setVisible(false);
		Estoque.setVisible(false);
		
	}
}
