package ren.junsong.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ren.junsong.util.Calculator;
import ren.junsong.util.Property;
import ren.junsong.util.Region1;
import ren.junsong.util.Region2;
import ren.junsong.util.Region3;
import ren.junsong.util.Region5;

public class StaUIFrame extends JFrame {
	private JLabel labelAll;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label_v;
	private JLabel label_w;
	private JLabel label_h;
	private JLabel label_u;
	private JLabel label_s;
	private JLabel label_Cp;
	private JLabel label_g; // 设置分标签
	private JLabel labeltarget; // 设置总的标签
	private JLabel labelRegion1;
	private JLabel labelRegion2;
	private JLabel labelRegion3;
	private JLabel labelRegion5;
	private JLabel labelp_T1;
	private JLabel labelp_T2;
	Font font1 = new Font("Microsoft JhengHei UI", Font.BOLD, 15);
	private JTextField text1;
	private JButton btn1;
	private JEditorPane editor1;
	private JPanel contentPane;
	private static boolean flag = false;
	private static boolean flag2 = false;
	private static boolean flag3 = false;
	private static boolean flagCombo = false;
	private Font font = new Font("Microsoft JhengHei", Font.PLAIN, 19);
	private JLabel labelRegion0;
	private JTextField text2;
	JFreeChart lineChart;
	private JLabel lblNewLabel_1;
	private JTextField text3;
	private JLabel lblNewLabel_2;
	private JTextField text4;
	private JLabel lblNewLabel_3;
	private JTextField text5;
	private JTextField text6;

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public StaUIFrame() throws URISyntaxException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIFrame.class.getResource("/resource/black.png")));
		setBackground(ConstantForUI.BACK_COLOR);
		setResizable(false);
		setTitle("Water vapor property calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 685);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(ConstantForUI.BACK_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		// UIManager.setLookAndFeel(lookAndFeel);
		labelAll = new JLabel("\u7B80\u7EA6>");
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
		String title = "";
		String axis_xtitle = "x";
		String axis_ytitle = "y";
		lineChart = ChartFactory.createXYLineChart(title, axis_xtitle, axis_ytitle, preXYSeriesCollection(),
				PlotOrientation.VERTICAL, false, true, false);

		lineChart.setBackgroundPaint(ConstantForUI.BACK_COLOR);

		/**
		 * 以下代码为了解决乱码问题，将标题和子件的字体都重新设置
		 */

		lineChart.getTitle().setFont(font);
		ValueAxis valueAxis = lineChart.getXYPlot().getDomainAxis();
		valueAxis.setLabelFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));

		// 以上获得图标中间部分，即plot，这个就是中间的很重要的部分,不同的类型有不同的plot，一般的叫做CategoryPlot，但是XY类型叫做XYPlot
		// 然后获取横坐标，可以修改字体，这样就不会乱码

		valueAxis.setAxisLineVisible(false);
		valueAxis.setLabelPaint(Color.black);
		Plot plot = lineChart.getXYPlot();

		plot.setNoDataMessage("No Data"); // 没有数据时显示的消息
		plot.setNoDataMessageFont(new Font("Microsoft JhengHei UI", Font.ITALIC, 30));
		plot.setBackgroundPaint(ConstantForUI.BACK_COLOR);
		lineChart.getXYPlot().getRangeAxis().setLabelFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lineChart.getXYPlot().getRangeAxis().setAxisLineVisible(false);

		// 设置纵坐标
		lineChart.getXYPlot().getRangeAxis().setAutoRange(true);
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setBackground(Color.GREEN);
		chartPanel.setBounds(342, 83, 760, 552);
		contentPane.add(chartPanel);

		createComboBox(); // 用于模拟下选框—_4区p，T选择
		createComboBoxRegion(); // 用于模拟区域选择
		createComboBox2();
		labeltarget = new JLabel();
		label_g = new JLabel();
		label_w = new JLabel();
		label_s = new JLabel();
		label_u = new JLabel();
		label_Cp = new JLabel();
		label_v = new JLabel();
		label_h = new JLabel();
		label_w = new JLabel();
		List<JLabel> combo = createCombo(labeltarget, font1);
		addJLabel(combo, label_g, font1, "g(kJ/mol)", 185, 182, 86, 28);
		addJLabel(combo, label_w, font1, "w(m/s)", 185, 207, 86, 28);
		addJLabel(combo, label_v, font1, "v(m^3/kg)", 185, 232, 86, 28);
		addJLabel(combo, label_h, font1, "h(kJ/kg)", 185, 257, 86, 28);
		addJLabel(combo, label_u, font1, "u(kJ/kg)", 185, 283, 86, 28);
		addJLabel(combo, label_s, font1, "s(kJ/(kg*k))", 185, 308, 86, 28);
		addJLabel(combo, label_Cp, font1, "cp(kJ/(kg*k))", 185, 333, 86, 28);
		runCombo(combo);
		text1 = new JTextField();
		text1.setBackground(ConstantForUI.BACK_COLOR);
		text1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		text1.setBounds(133, 498, 129, 25);

		text2 = new JTextField();
		text2.setBounds(210, 115, 86, 25);
		text2.setBackground(ConstantForUI.BACK_COLOR);
		text2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));

		text3 = new JTextField();
		text3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		text3.setBackground(ConstantForUI.BACK_COLOR);
		text3.setBounds(104, 193, 77, 25);
		text3.setColumns(10);

		text4 = new JTextField();
		text4.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		text4.setBounds(104, 228, 77, 25);
		text4.setBackground(ConstantForUI.BACK_COLOR);
		text4.setColumns(10);

		text5 = new JTextField();
		text5.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		text5.setBounds(104, 265, 77, 25);
		text5.setBackground(ConstantForUI.BACK_COLOR);
		text5.setColumns(10);
		btn1 = new JButton("\u8BA1\u7B97");
		btn1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btn1.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn1);
		btn1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				calRegion4();
			}
		});
		btn1.setBounds(143, 538, 103, 32);
		editor1 = new JEditorPane();
		editor1.setBackground(ConstantForUI.BACK_COLOR);
		editor1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 16));
		editor1.setBounds(21, 580, 286, 55);
		contentPane.setLayout(null);
		contentPane.add(labelAll);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(text1);
		contentPane.add(btn1);
		contentPane.add(editor1);

		lblNewLabel_1 = new JLabel("\u6700\u5C0F\u503C\uFF1A");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(31, 193, 77, 25);

		lblNewLabel_2 = new JLabel("\u6700\u5927\u503C\uFF1A");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(31, 228, 75, 25);

		lblNewLabel_3 = new JLabel("\u6B65  \u957F\uFF1A");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(31, 266, 75, 25);

		JLabel lblNewLabel = new JLabel("--------\u9971\u548C\u51FD\u6570\u65F6\u7684\u8BA1\u7B97--------\r\n");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(15, 442, 324, 39);
		contentPane.add(lblNewLabel);

		JLabel Label4 = new JLabel("\u8BF7\u9009\u62E9\u5206\u533A\uFF1A ");
		Label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		Label4.setBounds(31, 70, 115, 25);
		

		JLabel Label5 = new JLabel("\u56FA\u5B9A\u7C7B\u578B:");
		Label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		Label5.setBounds(31, 116, 77, 21);
		contentPane.add(Label5);

		JLabel label6 = new JLabel("\u9009\u62E9\u76EE\u6807\u51FD\u6570\uFF1A");
		label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label6.setBounds(31, 151, 129, 32);
		contentPane.add(label6);

		JButton btn2 = new JButton("\u8BA1\u7B97\u5E76\u7ED8\u56FE");
		btn2.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.getXYPlot().setDataset(createXYSeriesCollection());
				
			}
		});
		btn2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btn2.setBounds(31, 314, 148, 39);
		
		JButton btn3 = new JButton("\u8BA1\u7B97T_p\u51FD\u6570");
		btn3.setBounds(185, 392, 129, 27);
		btn3.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btn3.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.getXYPlot().setDataset(createXYSeriesCollection());
				
			}
		});
		
		contentPane.add(btn2);

		contentPane.setLayout(null);
	//	contentPane.add(Label4);
		contentPane.add(labelAll);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(text1);
		contentPane.add(btn1);
		contentPane.add(editor1);
		//contentPane.add(labelRegion1);
		//contentPane.add(labelRegion2);
		//contentPane.add(labelRegion3);
		//contentPane.add(labelRegion5);
		//contentPane.add(labelRegion0);
		contentPane.add(labelp_T1);
		contentPane.add(labelp_T2);
		contentPane.add(text2);
		contentPane.add(labeltarget);
		contentPane.add(label_g);
		contentPane.add(label_w);
		contentPane.add(label_v);
		contentPane.add(label_h);
		contentPane.add(label_u);
		contentPane.add(label_s);
		contentPane.add(label_Cp);
		contentPane.add(lblNewLabel_1);
		contentPane.add(text3);
		contentPane.add(lblNewLabel_2);
		contentPane.add(text4);

		contentPane.add(lblNewLabel_3);

		contentPane.add(text5);
		
		
		contentPane.add(btn3);
		
		text6 = new JTextField();
		text6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		text6.setColumns(10);
		text6.setBackground(new Color(235, 235, 235));
		text6.setBounds(104, 392, 77, 25);
		contentPane.add(text6);
		
		JLabel lblg = new JLabel("\u8F93\u5165g:");
		lblg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblg.setBounds(31, 394, 77, 21);
		contentPane.add(lblg);

		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { chartPanel, labelAll, label1,
				label2, label3, text1, labelRegion1, labelRegion2, labelRegion5, btn1, labelRegion0, labelRegion3,
				editor1, lblNewLabel, Label4, Label5, btn2, labelp_T1, label6, labelp_T2, text2 }));

	}

	private void runCombo(List<JLabel> combo) {
		if (combo.size() == 1) {
			System.out.println("未知错误");
			return;
		}
		// 初始化
		combo.get(0).setText(combo.get(1).getText()); // 初始化第一个JLabel
		UtilForUI.glorifyLabel(combo.get(0));
		combo.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		combo.get(0).setBackground(ConstantForUI.BACK_COLOR);
		combo.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchSelectCombo(combo);
			}
		});
		for (int i = 1; i < combo.size(); i++) {
			JLabel temp = combo.get(i);
			temp.setOpaque(true);
			temp.setBackground(new Color(235, 235, 235));
			UtilForUI.glorifyLabel(temp, new Color(210, 210, 210), new Color(235, 235, 235));
			combo.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					switchText(e, combo);
					switchSelectCombo(combo);
				}

			});
		}
	}

	private void switchText(MouseEvent e, List<JLabel> combo) {
		combo.get(0).setText(((JLabel) e.getSource()).getText());
	}

	protected void switchSelectCombo(List<JLabel> combo) {
		flagCombo = !flagCombo;

		for (int i = 1; i < combo.size(); i++) {
			combo.get(i).setVisible(flagCombo);
		}
	}

	private List<JLabel> createCombo(JLabel labeltarget2, Font font12) {
		String str0 = "title";
		labeltarget2.setText(str0);
		labeltarget2.setIcon(new ImageIcon(StaUIFrame.class.getResource("/resource/down.png")));
		labeltarget2.setBounds(157, 156, 120, 25);
		labeltarget2.setFont(font12);
		List<JLabel> set = new ArrayList<JLabel>();
		set.add(labeltarget2);
		return set;
	}

	private List<JLabel> addJLabel(List<JLabel> set, JLabel label, Font font, String text, int x, int y, int w, int h) {
		label.setText(text);
		label.setBounds(x, y, w, h);
		label.setFont(font);
		label.setVisible(false);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		set.add(label);
		return set;
	}

	private void createComboBox2() {
		// 用于模拟ComboBox的组件
		String str1 = "p(Mpa)";
		String str2 = "T(K)";
		String str3 = "未知错误";
		labelp_T1 = new JLabel(str1);
		labelp_T2 = new JLabel(str2);
		labelp_T2.setVisible(false);
		labelp_T2.setBorder(BorderFactory.createLineBorder(Color.black));
		labelp_T1.setIcon(new ImageIcon(StaUIFrame.class.getResource("/resource/down.png")));
		labelp_T1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchSelect3(labelp_T2, str3);
			}
		});
		UtilForUI.glorifyLabel(labelp_T1);
		labelp_T1.setHorizontalAlignment(SwingConstants.CENTER);
		labelp_T1.setBackground(ConstantForUI.BACK_COLOR);
		labelp_T1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		labelp_T1.setBounds(104, 116, 94, 21);
		// 打开的剩余组件
		labelp_T2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String temp;
				temp = switchSelect3(labelp_T2, str3);
				labelp_T2.setText(labelp_T1.getText());
				labelp_T1.setText(temp);
			}

		});
		labelp_T2.setHorizontalAlignment(SwingConstants.CENTER);

		// 用以下代码能达到标签不透明
		labelp_T2.setOpaque(true);
		labelp_T2.setBackground(new Color(235, 235, 235));

		UtilForUI.glorifyLabel(labelp_T2, new Color(210, 210, 210), new Color(235, 235, 235));
		labelp_T2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		labelp_T2.setBounds(104, 137, 75, 21);

	}

	private static String switchSelect3(JLabel label2, String str3) {
		flag3 = !flag3;
		label2.setVisible(flag3);
		str3 = label2.getText();

		return str3;
	}

	protected void calRegion4() {
		if (UtilForUI.checkNum(text1.getText())) {
			Calculator calRegion4 = new Calculator();
			if (label1.getText().equals("\u5DF2\u77E5p(Mpa)")) {
				String sb = "温度T（k）为：";
				editor1.setText(sb + calRegion4.calRegion4_p(Double.parseDouble(text1.getText())));
			} else if (label1.getText().equals("\u5DF2\u77E5T(K)")) {
				String sb = "压强p（Mpa）为：";
				editor1.setText(sb + calRegion4.calRegion4_T(Double.parseDouble(text1.getText())));
			} else {
				JOptionPane.showMessageDialog(null, "未知错误");
			}
		} else {
			JOptionPane.showMessageDialog(null, "请检查输入内容是否为数字");
		}

	}

	private static void switchSelect(JLabel label2, JLabel label3) {
		flag = !flag;
		label2.setVisible(flag);
		label3.setVisible(flag);
	}

	private void createComboBox() {
		// 用于模拟ComboBox的组件
		String str1 = "\u5DF2\u77E5p(Mpa)";
		String str2 = "\u5DF2\u77E5T(K)";
		label1 = new JLabel(str1);
		label2 = new JLabel("---\u5DF2\u77E5p---");
		label3 = new JLabel("---\u5DF2\u77E5T---");
		label2.setVisible(false);
		label3.setVisible(false);
		label2.setBorder(BorderFactory.createLineBorder(Color.black));
		label3.setBorder(BorderFactory.createLineBorder(Color.black));

		label1.setIcon(new ImageIcon(StaUIFrame.class.getResource("/resource/down.png")));
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchSelect(label2, label3);
			}
		});
		UtilForUI.glorifyLabel(label1);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setBackground(ConstantForUI.BACK_COLOR);
		label1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label1.setBounds(14, 490, 115, 32);
		// 打开的剩余组件
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label1.setText(str1);
				switchSelect(label2, label3);
			}

		});
		label2.setHorizontalAlignment(SwingConstants.CENTER);

		// 用以下代码能达到标签不透明
		label2.setOpaque(true);
		label2.setBackground(new Color(235, 235, 235));
		label3.setOpaque(true);
		label3.setBackground(new Color(235, 235, 235));
		UtilForUI.glorifyLabel(label2, new Color(210, 210, 210), new Color(235, 235, 235));
		label2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label2.setBounds(14, 522, 115, 25);

		label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label1.setText(str2);
				switchSelect(label2, label3);
			}

		});
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		UtilForUI.glorifyLabel(label3, new Color(210, 210, 210), new Color(235, 235, 235));
		label3.setBackground(ConstantForUI.BACK_COLOR);
		label3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label3.setBounds(14, 547, 115, 25);

	}

	private XYSeriesCollection preXYSeriesCollection() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		return dataset;
	}

	private XYSeriesCollection createXYSeriesCollection() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		if(text6!= null&&text6.getText().length()>=1){
			Calculator cal_g=new Calculator();
			double g=Double.parseDouble(text6.getText());
			XYSeries series_p = new XYSeries("T_p");
			lineChart.getTitle().setText("p关于T的函数");
			lineChart.getXYPlot().getRangeAxis().setLabel("p(Mpa)");
			lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
			for (double T=273.15;T<750; T += 1) {
				series_p.add(T, cal_g.p_gT(g, T));
			}
			dataset.addSeries(series_p);
			return dataset;
		}
		if (!UtilForUI.checkNum(text2.getText()) && !UtilForUI.checkNum(text3.getText())
				&& !UtilForUI.checkNum(text4.getText()) && !UtilForUI.checkNum(text5.getText())) {
			JOptionPane.showMessageDialog(null, "请检查输入内容是否为数字");
		}
		Calculator cal=new Calculator();
		if (labelp_T1.getText().equals("p(Mpa)")) {
			XYSeries series = new XYSeries("real");
			XYSeries series_ideal = new XYSeries("ideal gas");
			XYSeries series_vanDer = new XYSeries("vanDer gas");
			double p = Double.parseDouble(text2.getText());
			switch (labeltarget.getText()) {
			
			case "g(kJ/mol)":
				lineChart.getTitle().setText("g关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("g(KJ/mol)");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T,cal.drawRegion(1, p, T));
					series_ideal.add(T,cal.drawIdealGas(0, p, T));
					series_vanDer.add(T,cal.drawIdealGas(1, p, T));
				} 
				break;
			case "w(m/s)":
				lineChart.getTitle().setText("w关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("w(m/s)");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T, cal.drawRegion(2, p, T));
				}
				break;
			case "v(m^3/kg)":
				
				lineChart.getTitle().setText("v关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("v(m^3/kg)");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T, cal.drawRegion(3, p, T));
				}
				break;
			case "h(kJ/kg)":
				lineChart.getTitle().setText("h关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("h(kJ/kg)");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T, cal.drawRegion(4, p, T));
				}
				break;
			case "u(kJ/kg)":
				lineChart.getTitle().setText("u关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("u(kJ/kg)");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T, cal.drawRegion(5, p, T));
				}
				break;
			case "s(kJ/(kg*k))":
				lineChart.getTitle().setText("s关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("s(kJ/(kg*k))");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T, cal.drawRegion(6, p, T));
				}
				break;
			case "cp(kJ/(kg*k))":
				lineChart.getTitle().setText("Cp关于T的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("cp(kJ/(kg*k))");
				lineChart.getXYPlot().getDomainAxis().setLabel("T(K)");
				for (double T = Double.parseDouble(text3.getText()); T < Double
						.parseDouble(text4.getText()); T += Double.parseDouble(text5.getText())) {
					series.add(T,cal.drawRegion(7, p, T));
				}
				break;
			}

			dataset.addSeries(series_vanDer);
			dataset.addSeries(series_ideal);
			dataset.addSeries(series);

		} else if (labelp_T1.getText().equals("T(K)")) {
			XYSeries series = new XYSeries("real");
			XYSeries series_ideal = new XYSeries("ideal gas");
			XYSeries series_vanDer = new XYSeries("vanDer gas");
			double T = Double.parseDouble(text2.getText());
			switch (labeltarget.getText()) {

			case "g(kJ/mol)":
				lineChart.getTitle().setText("g关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("g(kJ/mol)");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p,cal.drawRegion(1, p, T));
					series_ideal.add(p,cal.drawIdealGas(0, p, T));
					series_vanDer.add(p,cal.drawIdealGas(1, p, T));
				}
				break;
			case "w(m/s)":
				lineChart.getTitle().setText("w关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("w(m/s)");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p, cal.drawRegion(2, p, T));
				}
				break;
			case "v(m^3/kg)":
				lineChart.getTitle().setText("v关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("v(m^3/kg)");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p,cal.drawRegion(3, p, T));
				}
				break;
			case "h(kJ/kg)":
				lineChart.getTitle().setText("h关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("h(kJ/kg)");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p, cal.drawRegion(4, p, T));
				}
				break;
			case "u(kJ/kg)":
				lineChart.getTitle().setText("u关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("u(kJ/kg)");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p,cal.drawRegion(5, p, T));
				}
				break;
			case "s(kJ/(kg*k))":
				lineChart.getTitle().setText("s关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("s(kJ/(kg*k))");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p, cal.drawRegion(6, p, T));
				}
				break;
			case "cp(kJ/(kg*k))":
				lineChart.getTitle().setText("Cp关于p的函数");
				lineChart.getXYPlot().getRangeAxis().setLabel("cp(kJ/(kg*k))");
				lineChart.getXYPlot().getDomainAxis().setLabel("p(Mpa)");
				for (double p = Double.parseDouble(text3.getText()); p < Double
						.parseDouble(text4.getText()); p += Double.parseDouble(text5.getText())) {
					series.add(p, cal.drawRegion(7, p, T));
				}
				break;
			}

		//	dataset.addSeries(series_vanDer);
		//	dataset.addSeries(series_ideal);
			dataset.addSeries(series);
		} else {
			System.out.println("打扰了");
		}
		return dataset;
	}

	protected void switchMode() {
		this.dispose();
		try {
			new UIFrame().setVisible(true);
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}

	}

	private void createComboBoxRegion() {
		// 用于模拟ComboBox的组件
		String str1 = "1\u533A";
		String str2 = "2\u533A";
		String str3 = "3\u533A";
		String str5 = "5\u533A";

		labelRegion0 = new JLabel(str1);
		labelRegion0.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		labelRegion0.setBounds(135, 74, 54, 15);
		labelRegion1 = new JLabel(str1);
		labelRegion1.setBounds(200, 53, 65, 20);
		labelRegion2 = new JLabel(str2);
		labelRegion2.setBounds(200, 83, 65, 20);
		labelRegion3 = new JLabel(str3);
		labelRegion3.setBounds(275, 53, 65, 20);
		labelRegion5 = new JLabel(str5);
		labelRegion5.setBounds(275, 83, 65, 20);

		labelRegion1.setVisible(false);
		labelRegion2.setVisible(false);
		labelRegion3.setVisible(false);
		labelRegion5.setVisible(false);

		labelRegion1.setBorder(BorderFactory.createLineBorder(Color.black));
		labelRegion2.setBorder(BorderFactory.createLineBorder(Color.black));
		labelRegion3.setBorder(BorderFactory.createLineBorder(Color.black));
		labelRegion5.setBorder(BorderFactory.createLineBorder(Color.black));

		labelRegion0.setIcon(new ImageIcon(StaUIFrame.class.getResource("/resource/down.png")));
		labelRegion0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchSelect(labelRegion1, labelRegion2, labelRegion3, labelRegion5);
			}
		});
		UtilForUI.glorifyLabel(labelRegion0);
		labelRegion0.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRegion0.setBackground(ConstantForUI.BACK_COLOR);
		labelRegion1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		labelRegion2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		labelRegion3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		labelRegion5.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));

		labelRegion1.setHorizontalAlignment(SwingConstants.CENTER);

		// 用以下代码能达到标签不透明
		labelRegion1.setOpaque(true);
		labelRegion1.setBackground(new Color(235, 235, 235));
		labelRegion3.setOpaque(true);
		labelRegion3.setBackground(new Color(235, 235, 235));
		labelRegion5.setOpaque(true);
		labelRegion5.setBackground(new Color(235, 235, 235));
		labelRegion2.setOpaque(true);
		labelRegion2.setBackground(new Color(235, 235, 235));
		UtilForUI.glorifyLabel(labelRegion1, new Color(210, 210, 210), new Color(235, 235, 235));
		UtilForUI.glorifyLabel(labelRegion2, new Color(210, 210, 210), new Color(235, 235, 235));
		UtilForUI.glorifyLabel(labelRegion3, new Color(210, 210, 210), new Color(235, 235, 235));
		UtilForUI.glorifyLabel(labelRegion5, new Color(210, 210, 210), new Color(235, 235, 235));

		// 打开的剩余组件
		labelRegion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelRegion0.setText(str1);
				switchSelect(labelRegion1, labelRegion2, labelRegion3, labelRegion5);
			}

		});
		labelRegion1.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelRegion0.setText(str2);
				switchSelect(labelRegion1, labelRegion2, labelRegion3, labelRegion5);
			}

		});
		labelRegion2.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelRegion0.setText(str3);
				switchSelect(labelRegion1, labelRegion2, labelRegion3, labelRegion5);
			}

		});
		labelRegion3.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegion5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelRegion0.setText(str5);
				switchSelect(labelRegion1, labelRegion2, labelRegion3, labelRegion5);
			}

		});
		labelRegion5.setHorizontalAlignment(SwingConstants.CENTER);

	}

	protected void switchSelect(JLabel labelRegion12, JLabel labelRegion22, JLabel labelRegion32,
			JLabel labelRegion52) {
		flag2 = !flag2;
		labelRegion12.setVisible(flag2);
		labelRegion22.setVisible(flag2);
		labelRegion32.setVisible(flag2);
		labelRegion52.setVisible(flag2);

	}
}
