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

import gif.Gif;
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
import java.io.File;
import java.net.URISyntaxException;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class UIFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private JEditorPane editor;
	private JButton btn1;
	private JLabel label1;
	private JLabel label2;
	public int a, b, count;
	private JLabel labelAll;

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
	 * 
	 * @throws URISyntaxException
	 */
	public UIFrame() throws URISyntaxException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIFrame.class.getResource("/resource/black.png")));
		setBackground(ConstantForUI.BACK_COLOR);
		setResizable(false);
		setTitle("Water vapor property calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 685);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(ConstantForUI.BACK_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		editor = new JEditorPane();
		editor.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 19));
		editor.setBounds(52, 303, 478, 343);
		editor.setBackground(ConstantForUI.BACK_COLOR);

		btn1 = new JButton("\u8BA1\u7B97");
		btn1.setBounds((ConstantForUI.FRAME_WIDTH - 150) / 2, 210, 150, 50);

		btn1.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc(e);

			}
		});
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));

		text1 = new JTextField();
		text1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		text1.setBounds(245, 90, 194, 30);
		text1.setBackground(ConstantForUI.BACK_COLOR);
		text1.setColumns(10);

		text2 = new JTextField();
		text2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
		text2.setBounds(245, 135, 194, 30);
		text2.setBackground(ConstantForUI.BACK_COLOR);
		text2.setColumns(10);

		label1 = new JLabel("\u538B\u529Bp(Mpa)=");
		label1.setBounds(76, 90, 160, 30);
		label1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));

		label2 = new JLabel("\u6E29\u5EA6T (K)  =");
		label2.setBounds(76, 135, 150, 30);
		label2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));

		labelAll = new JLabel("\u6807\u51C6>");
		labelAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchMode();
			}
		});
		UtilForUI.glorifyLabel(labelAll);
		labelAll.setHorizontalAlignment(SwingConstants.CENTER);
		labelAll.setBackground(ConstantForUI.BACK_COLOR);
		labelAll.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		labelAll.setBounds(21, 10, 97, 50);
		

		contentPane.setLayout(null);

		contentPane.add(labelAll);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(btn1);
		contentPane.add(editor);
		contentPane.add(text1);
		contentPane.add(text2);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { text1, text2 }));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane }));

	}

	protected void switchMode() {
		this.dispose();
		try {
			new StaUIFrame().setVisible(true);
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		
	}

	protected void calc(ActionEvent e) {
		if (UtilForUI.checkNum(text1.getText())) {

			Calculator cal = new Calculator();
			cal.setP(Double.parseDouble(text1.getText()));
			cal.setT(Double.parseDouble(text2.getText()));
			editor.setText(cal.resultpT());
		} else {
			JOptionPane.showMessageDialog(null, "请检查输入内容是否为数字");
		}

	}

	public static void myexception(int ex) {
		switch (ex) {
		case 0:
			JOptionPane.showMessageDialog(null, "打扰了，未知错误");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "输入内容越界");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "请检查输入内容是否为数字");
			break;
		}
	}
}