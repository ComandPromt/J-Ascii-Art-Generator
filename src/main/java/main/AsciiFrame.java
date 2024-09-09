package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.textField.text.NTextField;

@SuppressWarnings("serial")

public class AsciiFrame extends JFrame {

	private Ascii ascii;

	private javax.swing.JButton jButton1;

	private javax.swing.JLabel jLabel2;

	private javax.swing.JLabel jLabel3;

	private javax.swing.JPanel jPanel1;

	private javax.swing.JPanel jPanel2;

	private javax.swing.JScrollPane jScrollPane1;

	private javax.swing.JSpinner jSpinner1;

	private javax.swing.JSpinner jSpinner2;

	private javax.swing.JTextArea jTextArea1;

	private NTextField jTextField1;

	private JPanel left;

	private JLabel lblNewLabel;

	public AsciiFrame() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(AsciiFrame.class.getResource("/image/th-2808681252.png")));

		initComponents();

		setTitle("JTEXT 2 ASCII");

		ascii = new Ascii();

		jPanel2.setLayout(null);

		jSpinner1.setValue(ascii.getBlanco());

		jSpinner2.setValue(ascii.getNegro());

		jPanel2.add(jPanel1);

		left = new JPanel();

		left.setBorder(null);

		jTextField1 = new NTextField();

		jTextField1.setText("TEXT");

		jTextField1.setBackground(Color.WHITE);

		left.setLayout(new GridLayout(0, 1, 0, 0));

		lblNewLabel = new JLabel("Texto:");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		left.add(lblNewLabel);

		left.add(jTextField1);

		left.setBackground(Color.WHITE);

		left.setBounds(0, 0, 349, 100);

		jPanel2.add(left);

		jTextField1.setHorizontalAlignment(SwingConstants.CENTER);

		jTextField1.setPreferredSize(new java.awt.Dimension(200, 20));

		jButton1 = new javax.swing.JButton();

		jPanel2.add(jButton1);

		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jButton1.setText("GO");

		jButton1.setPreferredSize(new java.awt.Dimension(80, 80));

		jButton1.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {

				jButton1ActionPerformed(evt);

			}

		});

		setSize(600, 500);

		setLocationRelativeTo(null);

		addComponentListener(new ComponentAdapter() {

			@Override

			public void componentResized(ComponentEvent e) {

				left.setBounds(0, 0, Math.round(getWidth() * 0.5f), 100);

				lblNewLabel.setBounds(0, 0, Math.round(getWidth() * 0.5f), 50);

				jTextField1.setBounds(0, 50, Math.round(getWidth() * 0.5f), 50);

				jPanel1.setBounds(Math.round(getWidth() * 0.5f), 0, 200, 100);

				jButton1.setBounds(Math.round(getWidth() * 0.85f), 0, Math.round(getWidth() * 0.1f), 100);

			}

		});

	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();

		jTextArea1 = new javax.swing.JTextArea();

		jPanel2 = new javax.swing.JPanel();

		jPanel2.setBackground(Color.WHITE);

		jPanel1 = new javax.swing.JPanel();

		jPanel1.setBackground(Color.WHITE);

		jPanel1.setBounds(463, 0, 637, 100);

		jLabel2 = new javax.swing.JLabel();

		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jSpinner1 = new javax.swing.JSpinner();

		jSpinner1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jSpinner2 = new javax.swing.JSpinner();

		jSpinner2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jScrollPane1.setPreferredSize(new java.awt.Dimension(1100, 400));

		jTextArea1.setColumns(20);

		jTextArea1.setRows(5);

		jScrollPane1.setViewportView(jTextArea1);

		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

		jPanel2.setPreferredSize(new java.awt.Dimension(0, 100));

		jPanel1.setLayout(new GridLayout(0, 2, 0, 0));

		jLabel2.setText("Fondo :");

		jPanel1.add(jLabel2);

		jSpinner1.setModel(new javax.swing.SpinnerListModel(
				new String[] { "#", "$", "%", "O", "_", "-", "*", "+", "X", "x", "|", " ", "?", "@", ":" }));

		jSpinner1.setPreferredSize(new java.awt.Dimension(60, 20));

		jPanel1.add(jSpinner1);

		jLabel3 = new javax.swing.JLabel();

		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jLabel3.setText("Texto :");

		jPanel1.add(jLabel3);

		jSpinner2.setModel(new javax.swing.SpinnerListModel(
				new String[] { "#", "$", "%", "O", "_", "-", "*", "+", "X", "x", "|", " ", "?", "@", ":" }));

		jSpinner2.setPreferredSize(new java.awt.Dimension(60, 20));

		jPanel1.add(jSpinner2);

		getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

		pack();

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

		String text = this.jTextField1.getText().trim();

		if (!text.isEmpty()) {

			ascii.setBlanco(jSpinner1.getValue().toString());

			ascii.setNegro(jSpinner2.getValue().toString());

			jTextArea1.setText(ascii.crear(text.toUpperCase()).toString());

		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {

			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

				if ("Windows".equals(info.getName())) {

					javax.swing.UIManager.setLookAndFeel(info.getClassName());

					break;

				}

			}

		}

		catch (ClassNotFoundException ex) {

			java.util.logging.Logger.getLogger(AsciiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);

		}

		catch (InstantiationException ex) {

			java.util.logging.Logger.getLogger(AsciiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);

		}

		catch (IllegalAccessException ex) {

			java.util.logging.Logger.getLogger(AsciiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);

		}

		catch (javax.swing.UnsupportedLookAndFeelException ex) {

			java.util.logging.Logger.getLogger(AsciiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);

		}

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {

				new AsciiFrame().setVisible(true);

			}

		});

	}

}
