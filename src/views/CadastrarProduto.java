package views;

import java.awt.BorderLayout;
import models.Produto;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerCliente;
import controller.ControllerProduto;
import models.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.event.ActionEvent;

public class CadastrarProduto extends JFrame {
	
	ControllerProduto controle= new ControllerProduto();
	
	ControllerCliente c = new ControllerCliente();
	
	Set<Produto> produtos;
	

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCod;
	private JTextField tfValor;
	private JTextField tfQTD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ControllerProduto controle= new ControllerProduto();
		controle.iniciarProdutos();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProduto frame = new CadastrarProduto();
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
	public CadastrarProduto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				controle.atualizarProdutosController();
				c.atualizarClientesController();
			}
			@Override
			public void windowActivated(WindowEvent e) {
				controle.iniciarProdutos();
				c.iniciarClientes();
				
			}
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 52, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblCdigo = new JLabel("C\u00D3DIGO");
		lblCdigo.setFont(new Font("Century", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 60, 68, 25);
		contentPane.add(lblCdigo);
		
		JLabel lblValorUnitrio = new JLabel("VALOR UNIT\u00C1RIO");
		lblValorUnitrio.setFont(new Font("Century", Font.PLAIN, 14));
		lblValorUnitrio.setBounds(10, 110, 134, 25);
		contentPane.add(lblValorUnitrio);
		
		JLabel lblQuantidadeInicial = new JLabel("QUANTIDADE INICIAL");
		lblQuantidadeInicial.setFont(new Font("Century", Font.PLAIN, 14));
		lblQuantidadeInicial.setBounds(10, 160, 173, 25);
		contentPane.add(lblQuantidadeInicial);
		
		tfNome = new JTextField();
		tfNome.setBounds(121, 8, 173, 33);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCod = new JTextField();
		tfCod.setBounds(121, 58, 173, 33);
		contentPane.add(tfCod);
		tfCod.setColumns(10);
		
		tfValor = new JTextField();
		tfValor.setBounds(187, 108, 107, 33);
		contentPane.add(tfValor);
		tfValor.setColumns(10);
		
		tfQTD = new JTextField();
		tfQTD.setBounds(187, 158, 107, 33);
		contentPane.add(tfQTD);
		tfQTD.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("R$:");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(164, 117, 19, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

							String nome = tfNome.getText();
							int cod = Integer.parseInt(tfCod.getText());
							double valor = Double.valueOf(tfValor.getText());
							int qtd = Integer.parseInt(tfQTD.getText());
							Produto produto = new Produto(cod, nome, valor, qtd);
							if(controle.adicionarProdutoController(produto)) {
							
							JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
							
							controle.atualizarProdutosController();	
						}
				}catch(NullPointerException w) {
					JOptionPane.showMessageDialog(null, "CAMPO(S) OBRIGATÓRIOS NÃO PREENCHIDOS", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception q) {
					JOptionPane.showMessageDialog(null, "DIGITE OS VALORES DO TIPO CERTO NOS CAMPOS.\n 'nome' é caractere\n 'código', 'valor', e 'quantidade' são números ", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/util/book-plus.png")));
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 227, 284, 23);
		contentPane.add(btnNewButton);
	}
}
