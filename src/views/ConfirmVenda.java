package views;

import java.awt.BorderLayout;
import controller.ControllerProduto;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class ConfirmVenda extends JFrame {
	
	ControllerProduto Prod = new ControllerProduto();
	
	String ValorFinal;
	
	
	private MaskFormatter mask(String mascara){ 
		MaskFormatter mask = null;
		try{ 
			mask = new MaskFormatter(mascara); 
			}catch(java.text.ParseException ex){
				
			} 
		return mask; 
		}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmVenda frame = new ConfirmVenda();
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
	public ConfirmVenda() {
		setTitle("VALIDA\u00C7\u00C3O DE CPF");
	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 344, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF do CLIENTE");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 19, 148, 40);
		contentPane.add(lblNewLabel);
		
		JLabel cpfOK = new JLabel("New label");
		cpfOK.setIcon(new ImageIcon(ConfirmVenda.class.getResource("/util/check-bold.png")));
		cpfOK.setBounds(294, 70, 24, 14);
		contentPane.add(cpfOK);
		
		JLabel CPFNotOK = new JLabel("New label");
		CPFNotOK.setIcon(new ImageIcon(ConfirmVenda.class.getResource("/util/alpha-x.png")));
		CPFNotOK.setBounds(294, 70, 24, 14);
		contentPane.add(CPFNotOK);
		cpfOK.setVisible(false);
		CPFNotOK.setVisible(false);
		
		JFormattedTextField tfCPF = new JFormattedTextField(mask("###.###.###-##"));
		tfCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(true) {
					cpfOK.setVisible(true);					
				}else {
					CPFNotOK.setVisible(true);
				}
			}
		});
		tfCPF.setBounds(168, 19, 150, 40);
		contentPane.add(tfCPF);
		
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 16));
		btnNewButton.setBounds(168, 105, 150, 40);
		contentPane.add(btnNewButton);
		
	}
}