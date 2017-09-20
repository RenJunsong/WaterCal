package ren.junsong.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dialog.ModalExclusionType;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import ren.junsong.util.Calculator;

import java.awt.Component;
import java.awt.Window.Type;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;
	private JEditorPane editor ;
	private JButton btn1; 
	private JButton btn2; 
	private JLabel label1;
	private JLabel label2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIFrame frame = new UIFrame();
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
	public UIFrame() {
		setBackground(ConstantForUI.BACK_COLOR);
		setResizable(false);
		setTitle("Water vapor property calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(ConstantForUI.FRAME_X,ConstantForUI.FRAME_Y,530,720);
		contentPane = new JPanel();
		contentPane.setBackground(ConstantForUI.BACK_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		checkBox1 = new JCheckBox("\u538B\u529B");
		UtilForUI.glorify(checkBox1);
		checkBox1.setBounds(34, 63, 100, 40);
		checkBox1.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox1.setBackground(ConstantForUI.COM_COLOR);
		checkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickBox(e);
			}
		});
		checkBox1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		checkBox2 = new JCheckBox("\u6E29\u5EA6");
		checkBox2.setBounds(152, 63, 100, 41);
		UtilForUI.glorify(checkBox2);
		checkBox2.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox2.setBackground(ConstantForUI.COM_COLOR);
		checkBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(checkBox2.isSelected()){
				System.out.println("is on");
				text2.setEnabled(true);
			}else{
				System.out.println("is out");
				text2.setEnabled(false);
				text2.setText(null);
			}
			}
		});
		checkBox2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		checkBox3 = new JCheckBox("\u6BD4\u7113");
		checkBox3.setBounds(270, 65, 100, 40);
		UtilForUI.glorify(checkBox3);
		checkBox3.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox3.setBackground(ConstantForUI.COM_COLOR);
		checkBox3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		checkBox4 = new JCheckBox("\u6BD4\u71B5");
		checkBox4.setBounds(388, 65, 100, 40);
		UtilForUI.glorify(checkBox4);
		checkBox4.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox4.setBackground(ConstantForUI.COM_COLOR);
		checkBox4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		checkBox5 = new JCheckBox("\u6BD4\u5BB9");
		checkBox5.setBounds(34, 143, 100, 40);
		UtilForUI.glorify(checkBox5);
		checkBox5.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox5.setBackground(ConstantForUI.COM_COLOR);
		checkBox5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		checkBox6 = new JCheckBox("\u5E72\u5EA6");
		checkBox6.setBounds(152, 143, 100, 40);
		UtilForUI.glorify(checkBox6);
		checkBox6.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox6.setBackground(ConstantForUI.COM_COLOR);
		checkBox6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		
		editor = new JEditorPane();
		editor.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 19));
		editor.setBounds(42, 363, 458, 313);
		editor.setBackground(ConstantForUI.BACK_COLOR);
		btn1 = new JButton("\u8BA1\u7B97");
		btn1.setBounds(388, 144, 100, 40);
		btn1.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Calculator cal=new Calculator(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
			editor.setText(cal.result());
			}
		});
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
		btn2 = new JButton("\u91CD\u7F6E");
		btn2.setBounds(270, 144, 100, 40);
		UtilForUI.glorifycl(btn2);
		btn2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		btn2.setBackground(ConstantForUI.COM_COLOR);
		
		text1 = new JTextField();
		text1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		text1.setBounds(245, 241, 194, 25);
		text1.setBackground(ConstantForUI.BACK_COLOR);
		text1.setEnabled(false);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		text2.setBounds(245, 281, 194, 25);
		text2.setBackground(ConstantForUI.BACK_COLOR);
		text2.setEnabled(false);
		text2.setColumns(10);
		
		
		
		label1 = new JLabel("\u538B\u529Bp()=");
		label1.setBounds(96, 241, 100, 23);
		label1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		
		label2 = new JLabel("\u6E29\u5EA6T()=");
		label2.setBounds(96, 274, 131, 24);
		label2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		contentPane.setLayout(null);
		contentPane.add(checkBox5);
		contentPane.add(label2);
		contentPane.add(label1);
		contentPane.add(checkBox6);
		contentPane.add(btn2);
		contentPane.add(btn1);
		contentPane.add(text2);
		contentPane.add(text1);
		contentPane.add(checkBox1);
		contentPane.add(checkBox2);
		contentPane.add(checkBox3);
		contentPane.add(checkBox4);
		contentPane.add(editor);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{text1, text2}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}

	private void clickBox(ActionEvent e) {
		if(((JCheckBox)e.getSource()).isSelected()){
			text1.setEnabled(true);
		}else{
			text1.setEnabled(false);
			text1.setText(null);
		}
	}
}