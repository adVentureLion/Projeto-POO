package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		textField = new JTextField();
		textField.setBounds(121, 8, 173, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 58, 173, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 108, 107, 33);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 158, 107, 33);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("R$:");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(164, 117, 19, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setIcon(new ImageIcon(CadastrarProduto.class.getResource("/util/book-plus.png")));
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 227, 284, 23);
		contentPane.add(btnNewButton);
	}
}
