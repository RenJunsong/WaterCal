package ren.junsong.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.Toolkit;

public class UIFrame extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField text1;
	private JTextField text2;
	private JTextField text21;
	private JTextField text22;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;
	private JEditorPane editor ;
	private JEditorPane editor2 ;
	private JButton btn1; 
	private JButton btn2; 
	private JButton btn21; 
	private JLabel label1;
	private JLabel label2;
	private JLabel label21;
	private JLabel label22;
	public int a,b,count;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIFrame.class.getResource("/resource/black.png")));
		setBackground(ConstantForUI.BACK_COLOR);
		setResizable(false);
		setTitle("Water vapor property calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,ConstantForUI.FRAME_WIDTH,ConstantForUI.FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane2 = new JPanel();
		contentPane.setBackground(ConstantForUI.BACK_COLOR);
		contentPane2 = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		setContentPane(contentPane2);
		
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
		editor2 = new JEditorPane();
		editor2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 19));
		editor2.setBounds(42, 313, 458, 313);
		editor2.setBackground(ConstantForUI.BACK_COLOR);
		
		btn1 = new JButton("\u8BA1\u7B97");
		btn1.setBounds(388, 144, 100, 40);
		btn1.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			calc(e);
				
			}
		});
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
		btn2 = new JButton("\u91CD\u7F6E");
		btn2.setBounds(388, 144, 100, 40);
		UtilForUI.glorifycl(btn2);
		btn2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		btn2.setBackground(ConstantForUI.COM_COLOR);
		
		btn21 = new JButton("\u8BA1\u7B97");
		btn21.setBounds((ConstantForUI.FRAME_WIDTH-150)/2,210, 150, 50);
		
		btn21.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn21);
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			calc2(e);
				
			}
		});
		btn21.setForeground(Color.BLACK);
		btn21.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
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
		text21 = new JTextField();
		text21.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		text21.setBounds(245, 90, 194, 30);
		text21.setBackground(ConstantForUI.BACK_COLOR);
		text21.setColumns(10);
		
		text22 = new JTextField();
		text22.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		text22.setBounds(245, 135, 194, 30);
		text22.setBackground(ConstantForUI.BACK_COLOR);
		text22.setColumns(10);
		
		
		
		label1 = new JLabel("\u538B\u529Bp(Mpa)=");
		label1.setBounds(86, 241, 154, 23);
		label1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		
		label2 = new JLabel("\u6E29\u5EA6T(K) =");
		label2.setBounds(86, 278, 131, 24);
		label2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		label21 = new JLabel("\u538B\u529Bp(Mpa)=");
		label21.setBounds(76, 90, 160, 30);
		label21.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		
		label22 = new JLabel("\u6E29\u5EA6T (K)  =");
		label22.setBounds(76,135, 150, 30);
		label22.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
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
		contentPane2.setLayout(null);
		contentPane2.add(label21);
		contentPane2.add(label22);
		contentPane2.add(btn21);
		contentPane2.add(editor2);
		contentPane2.add(text21);
		contentPane2.add(text22);
	}
		

	protected void calc2(ActionEvent e) {
		if(UtilForUI.checkNum(text21.getText())){
			
			Calculator cal=new Calculator();
			cal.setP(Double.parseDouble(text21.getText()));
			cal.setT(Double.parseDouble(text22.getText()));
			editor2.setText(cal.result());
			}else{
				JOptionPane.showMessageDialog(null, "请检查输入内容是否为数字");
			}
		
	}

	private void calc(ActionEvent e) {
		if(UtilForUI.checkNum(text1.getText())){
		Calculator cal=new Calculator(Double.parseDouble(text1.getText()),Double.parseDouble(text2.getText()));
		editor.setText(cal.result());
		}else{
			JOptionPane.showMessageDialog(null, "请检查输入内容是否为数字");
		}
	}

	private void clickBox(ActionEvent e) {
		if(((JCheckBox)e.getSource()).isSelected()){
			count++;
			text1.setEnabled(true);
		}else{
			count--;
			text1.setEnabled(false);
			text1.setText(null);
		}
	}
}