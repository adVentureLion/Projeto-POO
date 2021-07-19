package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerCliente;
import controller.ControllerProduto;
import models.Cliente;
import models.Produto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.event.WindowFocusListener;

public class ListarClientesEx extends JFrame {
	
	ControllerProduto Prod = new ControllerProduto();
	
	ControllerCliente c = new ControllerCliente();

	private JPanel contentPane;
	Set<Cliente> clientes;
	private JTable tabela;
	private JScrollPane scTab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientesEx frame = new ListarClientesEx();
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
	public ListarClientesEx() {
		
		
		
		c.iniciarClientes();
		clientes = c.listarClienteExcluidosController();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENTES EXCLUÍDOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 664, 28);
		contentPane.add(lblNewLabel);
		
		tabela = new JTable();
		tabela.setBounds(10, 69, 664, 315);
		contentPane.add(tabela);
		
		scTab = new JScrollPane(tabela);
		scTab.setBounds(10, 69, 664, 315);
		contentPane.add(scTab);
		DefaultTableModel auxCliente = (DefaultTableModel) tabela.getModel();
		
		auxCliente.addColumn("NOME");
		auxCliente.addColumn("DATA DE NASCIMENTO");
		auxCliente.addColumn("CPF");
		
		for (Cliente cliente : clientes) {
			auxCliente.addRow(new String [] {cliente.getNome(), cliente.getDataNasci(), cliente.getCpf()});
		}
		
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Prod.iniciarProdutos();
				c.iniciarClientes();
				
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Prod.atualizarProdutosController();
				c.atualizarClientesController();
				
			}
		});
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				Prod.iniciarProdutos();
				c.iniciarClientes();
				clientes = c.listarClienteExcluidosController();
				
				
				while(auxCliente.getRowCount()>0){
					auxCliente.removeRow(0);
				}
				for (Cliente cliente : clientes) {
					auxCliente.addRow(new String [] {cliente.getNome(), cliente.getDataNasci(), cliente.getCpf()});
				}
				tabela.revalidate();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		
		
		
		
		
	}

}
