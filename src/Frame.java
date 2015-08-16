import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.xml.soap.Text;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.*;
import java.util.jar.JarException;
import java.awt.Window.Type;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblStatus;
	private CulcDestinyV culcDestinyt1 = new CulcDestinyV();
	private CulcDestinyV culcDestinyt2 = new CulcDestinyV();
	private DecimalFormat df1 = new DecimalFormat("##0.00#");
	private DecimalFormat df2 = new DecimalFormat("######0.###");
	private JTabbedPane tabbedPane;

	private String statusTb1Text = "pn=80.00, p1=3.00";
	private String statusTb2Text = "p1=3.00, n=53";
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setResizable(false);
		setTitle("\u904B\u547D\u529B\u8A08\u7B97\u6A5F");
		Init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 190, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("メイリオ", Font.PLAIN, 11));
		contentPane.add(tabbedPane);
		tabbedPane.addChangeListener(new TabChangeListener());

		JPanel panel = new JPanel();
		tabbedPane.addTab("回数計算", null, panel, null);

		JLabel lblNewLabel = new JLabel("\u904B\u547D\u529B(%)\uFF1A");
		lblNewLabel.setFont(new Font("メイリオ", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 160, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		textField = new JTextField();
		textField.setText(df1.format(culcDestinyt1.getpn()));
		textField.setBounds(20, 30, 100, 20);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocListenert1());
		textField.addActionListener(new textActListenert1());
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(textField);

		JLabel lblNewLabel_1 = new JLabel(
				"\u4E00\u56DE\u306E\u8A66\u884C\u306E\u78BA\u7387(%)\uFF1A");
		lblNewLabel_1.setFont(new Font("メイリオ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 60, 171, 15);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setText(df1.format(culcDestinyt1.getp1()));
		textField_1.setBounds(20, 80, 100, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.getDocument().addDocumentListener(new DocListenert1());
		textField_1.addActionListener(new textActListenert1());

		JLabel lblNewLabel_2 = new JLabel(
				"\u5FC5\u8981\u306A\u8A66\u884C\u56DE\u6570\uFF1A");
		lblNewLabel_2.setFont(new Font("メイリオ", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 150, 169, 15);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(20, 170, 100, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		// I/O
		// culcDestinyt1.setValues(Double.parseDouble(textField.getText()),
		// Double.parseDouble(textField_1.getText()), -1);
		textField_2.setText(df2.format(Math.ceil(culcDestinyt1.getn())));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("運命力計算", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E00\u56DE\u306E\u8A66\u884C\u306E\u78BA\u7387(%)\uFF1A");
		lblNewLabel_3.setFont(new Font("メイリオ", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 10, 160, 15);
		panel_1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setText(df1.format(culcDestinyt2.getp1()));
		textField_3.setBounds(20, 30, 100, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_3.getDocument().addDocumentListener(new DocListenert2());
		textField_3.addActionListener(new textActListenert2());
		
		JLabel lblNewLabel_4 = new JLabel("\u8A66\u884C\u56DE\u6570\uFF1A");
		lblNewLabel_4.setFont(new Font("メイリオ", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 60, 160, 15);
		panel_1.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setText(df2.format(culcDestinyt2.getn()));
		textField_4.setBounds(20, 80, 100, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		textField_4.getDocument().addDocumentListener(new DocListenert2());
		textField_4.addActionListener(new textActListenert2());
		
		JLabel lblNewLabel_5 = new JLabel("\u904B\u547D\u529B(%)\uFF1A");
		lblNewLabel_5.setFont(new Font("メイリオ", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(12, 150, 160, 15);
		panel_1.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(20, 170, 100, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(df1.format(culcDestinyt2.getpn()));
		
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		lblStatus.addPropertyChangeListener(new StatusPropChangeListener());
	}

	private void Init() {
		lblStatus = new JLabel("pn=80.00, p1=3.00");
		culcDestinyt1.setValues(80, 3, -1);
		culcDestinyt2.setValues(-1, 3, 53);
		culcDestinyt1.culcn();
		culcDestinyt2.culcpn();
		

	}

	private boolean checkParcentValue(double input) {
		if (input <= 100 && input >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private boolean checkNValue(double n){
		return n>= 0;
	}
	

	class DocListenert1 implements DocumentListener {
		FixText fixtext;
		public DocListenert1() {
			fixtext = new FixText();
		}
		
		public void changedUpdate(DocumentEvent de) {
			updates(de);
		}

		public void insertUpdate(DocumentEvent de) {
			updates(de);
		}

		public void removeUpdate(DocumentEvent de) {
			updates(de);
		}

		public void updates(DocumentEvent de) {

			try {
				
				double pn = Double.parseDouble(fixtext.Fix(textField.getText()));
				double p1 = Double.parseDouble(fixtext.Fix(textField_1.getText()));
				
				lblStatus.setText("pn=" + df1.format(pn) + ", p1="
						+ df1.format(p1));

				if(!checkParcentValue(pn) || !checkParcentValue(p1)){
					textField_2.setText("Error");
					lblStatus.setText("範囲を超えた入力です");
				}else if(p1 == 0 && pn == 0){
					textField_2.setText("Error");
					lblStatus.setText("矛盾");
				//}else if (p1 == 100 && pn == 100) {
				//	textField_2.setText("1");
				}else if(p1 == 0){
					textField_2.setText("Infty");
					lblStatus.setText("小数点以下の確率で可能");
				}else if(pn ==0){
					textField_2.setText("0");
					lblStatus.setText("試行なしで引ける");
				}else if (p1 == 100) {
					textField_2.setText("1");
				}else if (pn == 100) {
					textField_2.setText("Infty");
				}else if (checkParcentValue(pn) && checkParcentValue(p1)) {
					culcDestinyt1.setValues(pn, p1, -1);
					culcDestinyt1.culcn();
					textField_2.setText(df2.format(Math.ceil(culcDestinyt1
							.getn())));
					
				} else {
					textField_2.setText("Error");
					lblStatus.setText("範囲を超えた入力です");
				}
				// textField_2.setText(Double.toString(culcDestinyt1.getn()));
			} catch (java.lang.NumberFormatException e) {

				lblStatus.setText("ピリオドの数が不正です");
				textField_2.setText("Error");

			}
		}
	}

	class textActListenert1 implements ActionListener {
		FixText fixtext;
		public textActListenert1() {
			fixtext = new FixText();
		}
		public void actionPerformed(ActionEvent e) {
			

			try {
				textField.setText(df1.format(Double.parseDouble(fixtext
						.Fix(textField.getText()))));
				textField_1.setText(df1.format(Double.parseDouble(fixtext
						.Fix(textField_1.getText()))));
			} catch (java.lang.NumberFormatException ex) {
				textField.setText(fixtext.Fix(textField.getText()));
				textField_1.setText(fixtext.Fix(textField_1.getText()));
			}

		}

	}
	
	class DocListenert2 implements DocumentListener {
		FixText fixtext;
		public DocListenert2() {
			fixtext = new FixText();
		}
		
		public void changedUpdate(DocumentEvent de) {
			updates(de);
		}

		public void insertUpdate(DocumentEvent de) {
			updates(de);
		}

		public void removeUpdate(DocumentEvent de) {
			updates(de);
		}

		public void updates(DocumentEvent de) {

			try {
				
				double p1 = Double.parseDouble(fixtext.Fix(textField_3.getText()));
				double n = Double.parseDouble(fixtext.Fix(textField_4.getText()));

				lblStatus.setText("p1=" + df1.format(p1) + ", n="
						+ df2.format(n));
				
				if(!checkParcentValue(p1) || !checkNValue(n)){
					textField_5.setText("Error");
					lblStatus.setText("範囲を超えた入力です");
				}else if(n == 0){
					textField_5.setText("0");
					lblStatus.setText("試行してください");
				}else if(p1 == 0){
					textField_5.setText("0");
					lblStatus.setText("運命力は小数点以下");
				}else if(p1 ==100){
					textField_5.setText("Error");
					lblStatus.setText("計測不能");
				}else if (checkNValue(n) && checkParcentValue(p1)) {
					culcDestinyt2.setValues(-1, p1, n);
					culcDestinyt2.culcpn();
					textField_5.setText(df1.format(culcDestinyt2
							.getpn()));
					

				} else {
					textField_5.setText("Error");
					lblStatus.setText("範囲を超えた入力です");
				}
				// textField_2.setText(Double.toString(culcDestinyt1.getn()));
			} catch (java.lang.NumberFormatException e) {

				lblStatus.setText("ピリオドの数が不正です");
				textField_5.setText("Error");

			}
		}
	}
	
	class textActListenert2 implements ActionListener {
		FixText fixtext;
		public textActListenert2() {
			fixtext = new FixText();
		}
		public void actionPerformed(ActionEvent e) {
			

			try {
				textField_3.setText(df1.format(Double.parseDouble(fixtext
						.Fix(textField_3.getText()))));
				textField_4.setText(df2.format(Double.parseDouble(fixtext
						.Fix(textField_4.getText()))));
			} catch (java.lang.NumberFormatException ex) {
				textField_3.setText(fixtext.Fix(textField_3.getText()));
				textField_4.setText(fixtext.Fix(textField_4.getText()));
			}

		}

	}
	

	private class FixText {
		public String Fix(String input) {

			input = EmtoEn(input);
			input = input.replaceAll("[^0-9.]", "");
			if (input.equals("")) {
				input = "0";
			}
			return input;
		}

		private String EmtoEn(String input) {
			StringBuffer sb = new StringBuffer(input);
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c >= '０' && c <= '９') {
					sb.setCharAt(i, (char) (c + '0' - '０'));
				} else if (c == '．') {
					sb.setCharAt(i, '.');
				}
			}
			return sb.toString();
		}

	}
	
	class StatusPropChangeListener implements PropertyChangeListener{

		public void propertyChange(PropertyChangeEvent pce){
			update();
		}
		
		
		private void update(){
			int tbindex = tabbedPane.getSelectedIndex();
			if(tbindex == 0){
				updatetb1();
			}else if(tbindex == 1){
				updatetb2();
			}
		
		}
		
		private void updatetb1(){
			statusTb1Text = lblStatus.getText();
		}
		
		private void updatetb2(){
			statusTb2Text = lblStatus.getText();
		}
		
	}
	
	class TabChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent ce){
			int tbindex = tabbedPane.getSelectedIndex();
			if(tbindex == 0){
				lblStatus.setText(statusTb1Text);
			}else if(tbindex == 1){
				lblStatus.setText(statusTb2Text);
			}
			
		}
	}
}
