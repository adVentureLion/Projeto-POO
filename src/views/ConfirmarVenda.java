package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ConfirmarVenda {
	
	private MaskFormatter mask(String mascara){ 
		MaskFormatter mask = null;
		try{ 
			mask = new MaskFormatter(mascara); 
			}catch(java.text.ParseException ex){
				
			} 
		return mask; 
		}

	private JFrame ConVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmarVenda window = new ConfirmarVenda();
					window.ConVenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfirmarVenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ConVenda = new JFrame();
		ConVenda.setBounds(100, 100, 344, 280);
		ConVenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ConVenda.getContentPane().setLayout(null);
		
		JLabel lblOK = new JLabel("");
		lblOK.setIcon(new ImageIcon(ConfirmarVenda.class.getResource("/util/check-bold.png")));
		lblOK.setBounds(294, 70, 24, 14);
		ConVenda.getContentPane().add(lblOK);
		lblOK.setVisible(false);
		
		JLabel lblNotOK = new JLabel("");
		lblNotOK.setIcon(new ImageIcon(ConfirmarVenda.class.getResource("/util/alpha-x.png")));
		lblNotOK.setBounds(294, 70, 24, 14);
		ConVenda.getContentPane().add(lblNotOK);
		lblNotOK.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("CPF do CLIENTE");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 19, 148, 40);
		ConVenda.getContentPane().add(lblNewLabel);
		
		JLabel lblValor = new JLabel("");
		lblValor.setFont(new Font("Century", Font.PLAIN, 16));
		lblValor.setBounds(168, 98, 150, 40);
		ConVenda.getContentPane().add(lblValor);
		
		JFormattedTextField tfCPF = new JFormattedTextField(mask("###.###.###-##"));
		tfCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(true) {
					lblOK.setVisible(true);					
				}else {
					lblNotOK.setVisible(true);
				}
			}
		});
		tfCPF.setFont(new Font("Century", Font.PLAIN, 10));
		tfCPF.setBounds(168, 19, 150, 40);
		ConVenda.getContentPane().add(tfCPF);
		
		JLabel lblNewLabel2 = new JLabel("VALOR");
		lblNewLabel2.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel2.setBounds(10, 98, 65, 40);
		ConVenda.getContentPane().add(lblNewLabel2);
		
		JButton btnVender = new JButton("CONFIRMAR");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(lblOK.isVisible()) {
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						 String data = dtf.format(LocalDateTime.now()).toString();
						 String Valor = lblValor.getText();
						 String CPF = tfCPF.getText();
						 
						 
					} else {
						throw new NullPointerException();
					}
				} catch (NullPointerException w) {
					JOptionPane.showMessageDialog(null, "CPF INV�LIDO", "ERRO", 2);
				}
			}
		});
		btnVender.setFont(new Font("Century", Font.PLAIN, 16));
		btnVender.setBounds(168, 190, 150, 40);
		ConVenda.getContentPane().add(btnVender);
		
		
		

		
		
	}
}
