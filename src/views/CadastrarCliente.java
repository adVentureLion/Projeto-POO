package views;

import java.awt.BorderLayout;
import controller.ControllerCliente;
import controller.ControllerProduto;
import models.Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CadastrarCliente extends JFrame {
	
	ControllerCliente controle = new ControllerCliente();
	
	ControllerProduto Prod = new ControllerProduto();
	
	
	

	private JPanel contentPane;
	private JTextField tfNome;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private MaskFormatter mask(String mascara){ 
		MaskFormatter mask = null;
		try{ 
			mask = new MaskFormatter(mascara); 
			}catch(java.text.ParseException ex){
				
			} 
		return mask; 
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ControllerCliente controle = new ControllerCliente();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
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
	public CadastrarCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				controle.atualizarClientesController();
			}
			@Override
			public void windowActivated(WindowEvent e) {
				controle.iniciarClientes();
				
			}
		});
		
		
		setResizable(false);
		setFont(new Font("Century", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 20, 68, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Century", Font.PLAIN, 16));
		lblCpf.setBounds(10, 80, 68, 25);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setFont(new Font("Century", Font.PLAIN, 16));
		lblSexo.setBounds(10, 140, 68, 25);
		contentPane.add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO");
		lblDataDeNascimento.setFont(new Font("Century", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(10, 200, 203, 25);
		contentPane.add(lblDataDeNascimento);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Century", Font.PLAIN, 12));
		tfNome.setBounds(140, 17, 198, 34);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JFormattedTextField ftfData = new JFormattedTextField(mask("##/##/####"));
		ftfData.setFont(new Font("Century", Font.PLAIN, 12));
		ftfData.setBounds(223, 197, 115, 34);
		contentPane.add(ftfData);
		
		JRadioButton rbF = new JRadioButton("FEMININO");
		buttonGroup.add(rbF);
		rbF.setFont(new Font("Century", Font.PLAIN, 12));
		rbF.setBounds(140, 142, 91, 23);
		contentPane.add(rbF);
		
		JRadioButton rbM = new JRadioButton("MASCULINO");
		buttonGroup.add(rbM);
		rbM.setFont(new Font("Century", Font.PLAIN, 12));
		rbM.setBounds(233, 143, 105, 23);
		contentPane.add(rbM);
		
		JFormattedTextField ftfCPF = new JFormattedTextField(mask("###.###.###-##"));
		ftfCPF.setFont(new Font("Century", Font.PLAIN, 12));
		ftfCPF.setBounds(140, 77, 198, 34);
		contentPane.add(ftfCPF);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
							
							String nome = tfNome.getText().toString();
							String cpf = ftfCPF.getText().toString();
							String data = ftfData.getText().toString();
							String sexo = null;
							if(rbF.isSelected()) {
								sexo = "Feminino";
							}if(rbM.isSelected()) {
								sexo = "Masculino";
							}
							
							Cliente cliente = new Cliente(nome, cpf, data, sexo);
							
							if(controle.adicionarClienteController(cliente)) {
								
								JOptionPane.showMessageDialog(null, "CADASTRADO COM SECESSO", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
							}
							
						
							
						
				}catch(Exception q) {
					JOptionPane.showMessageDialog(null, "ALGO DEU ERRADO", "FALHA", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(CadastrarCliente.class.getResource("/util/account-multiple-plus.png")));
		btnNewButton.setBounds(10, 246, 328, 23);
		contentPane.add(btnNewButton);
		
		
	}
}