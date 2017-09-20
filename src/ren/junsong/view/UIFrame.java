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
		
		JCheckBox checkBox1 = new JCheckBox("\u538B\u529B");
		checkBox1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkBox1.setBackground(ConstantForUI.ACT_COLOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!checkBox1.isSelected()){
					checkBox1.setBackground(ConstantForUI.COM_COLOR);
				}
			}
		});
		checkBox1.setBounds(34, 63, 100, 40);
		checkBox1.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox1.setBackground(ConstantForUI.COM_COLOR);
		checkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(checkBox1.isSelected()){
				System.out.println("is on");
				text1.setEnabled(true);
			}else{
				System.out.println("is out");
				text1.setEnabled(false);
				text1.setText(null);
			}
			}
		});
		checkBox1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		JCheckBox checkBox2 = new JCheckBox("\u6E29\u5EA6");
		checkBox2.setBounds(152, 63, 100, 41);
		checkBox2.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox2.setBackground(ConstantForUI.COM_COLOR);
		checkBox2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkBox2.setBackground(ConstantForUI.ACT_COLOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!checkBox2.isSelected()){
					checkBox2.setBackground(ConstantForUI.COM_COLOR);
				}
			}
		});
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
		
		JCheckBox checkBox3 = new JCheckBox("\u6BD4\u7113");
		checkBox3.setBounds(270, 65, 100, 40);
		checkBox3.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox3.setBackground(ConstantForUI.COM_COLOR);
		checkBox3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		JCheckBox checkBox4 = new JCheckBox("\u6BD4\u71B5");
		checkBox4.setBounds(388, 65, 100, 40);
		checkBox4.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox4.setBackground(ConstantForUI.COM_COLOR);
		checkBox4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		JCheckBox checkBox5 = new JCheckBox("\u6BD4\u5BB9");
		checkBox5.setBounds(34, 143, 100, 40);
		checkBox5.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox5.setBackground(ConstantForUI.COM_COLOR);
		checkBox5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		JCheckBox checkBox6 = new JCheckBox("\u5E72\u5EA6");
		checkBox6.setBounds(152, 143, 100, 40);
		checkBox6.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox6.setBackground(ConstantForUI.COM_COLOR);
		checkBox6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		
		JEditorPane editor = new JEditorPane();
		editor.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		editor.setBounds(28, 363, 472, 313);
		editor.setBackground(ConstantForUI.BACK_COLOR);
		JButton btn1 = new JButton("\u8BA1\u7B97");
		btn1.setBounds(388, 144, 100, 40);
		btn1.setBackground(ConstantForUI.COM_COLOR);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1.setBackground(ConstantForUI.BTN_COLOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn1.setBackground(ConstantForUI.COM_COLOR);
			}
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Calculator cal=new Calculator(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
			editor.setText(Double.toString(cal.result()));
			}
		});
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
		
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
		
		JButton btn2 = new JButton("\u91CD\u7F6E");
		btn2.setBounds(270, 144, 100, 40);
		btn2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 20));
		btn2.setBackground(ConstantForUI.COM_COLOR);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn2.setBackground(ConstantForUI.AL_COLOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn2.setBackground(ConstantForUI.COM_COLOR);
			}
		});
		
		JLabel label1 = new JLabel("\u538B\u529Bp()=");
		label1.setBounds(96, 241, 100, 23);
		label1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		
		JLabel label2 = new JLabel("\u6E29\u5EA6T()=");
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
}