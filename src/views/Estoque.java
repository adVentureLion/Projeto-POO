package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerProduto;
import models.Produto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Estoque extends JFrame {
	
	ControllerProduto controle = new ControllerProduto();
	int cod = 0;
	Set<Produto> produtos;

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfqt;
	private JTextField tfADD;
	private JTextField tfRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				produtos = controle.listarProdutosController();
				for (Produto produto : produtos) {
					if(produto.getCodigo() == cod) {
						tfNome.setText(produto.getNome());
						tfqt.setText(String.valueOf(produto.getQtd()));
					}
				}
			}
		});
		
		controle.iniciarProdutos();
		produtos = controle.listarProdutosController();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(134, 13, 131, 29);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PRODUTO");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 11, 87, 30);
		contentPane.add(lblNewLabel);
		
		tfqt = new JTextField();
		tfqt.setBounds(134, 79, 131, 29);
		contentPane.add(tfqt);
		tfqt.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("QUANTIDADE");
		lblQuantidade.setFont(new Font("Century", Font.PLAIN, 12));
		lblQuantidade.setBounds(23, 77, 87, 30);
		contentPane.add(lblQuantidade);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 138, 100, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADICIONAR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 11, 80, 14);
		panel.add(lblNewLabel_1);
		
		tfADD = new JTextField();
		tfADD.setBounds(10, 36, 80, 28);
		panel.add(tfADD);
		tfADD.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfADD.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPO VAZIO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
					} else {
						int qtd = Integer.parseInt(tfADD.getText());
						controle.adicionarNoEstoque(cod, qtd);
						controle.atualizarProdutosController();
						}
					
					
				}catch(Exception w){
					JOptionPane.showMessageDialog(null, "CAMPO VAZIO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Estoque.class.getResource("/util/check-bold.png")));
		btnNewButton.setBounds(10, 78, 80, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(165, 138, 100, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("SUBTRAIR");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 11, 80, 14);
		panel_1.add(lblNewLabel_1_1);
		
		tfRemove = new JTextField();
		tfRemove.setBounds(10, 36, 80, 28);
		panel_1.add(tfRemove);
		tfRemove.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Estoque.class.getResource("/util/check-bold.png")));
		btnNewButton_1.setBounds(10, 78, 80, 23);
		panel_1.add(btnNewButton_1);
	}
}
