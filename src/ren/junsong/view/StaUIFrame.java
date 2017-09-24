package ren.junsong.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import ren.junsong.util.Calculator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaUIFrame extends JFrame {
	private JLabel labelAll;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextPane text1;
	private JButton btn1;
	private JEditorPane editor1;
	private JPanel contentPane;
	private static boolean flag = false;
	private Font font = new Font("Microsoft JhengHei", Font.PLAIN, 19);

	/**
	 * Create the frame.
	 */
	public StaUIFrame() throws URISyntaxException {
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

		JFreeChart lineChart = ChartFactory.createXYLineChart("自能能g（p）在T=1000的时候函数", "压强p", "自由能g", createXYSeriesCollection(),
				PlotOrientation.VERTICAL, false, true, false);

		Paint paint1 = new Color(250, 250, 250);
		Paint paint2 = new Color(0, 0, 0);
		Paint paint3 = new Color(0, 0, 0);
		Paint paint4 = new Color(240, 240, 240);
		lineChart.setBackgroundPaint(paint1);
		lineChart.getTitle().setPaint(paint2);

		/**
		 * 以下代码为了解决乱码问题，将标题和子件的字体都重新设置
		 */

		lineChart.getTitle().setFont(font);
		// lineChart.getLegend().setItemFont(font); 当有图例的时候可以这样做

		// lineChart.setBackgroundImageAlpha(0.9f);
		ValueAxis valueAxis = lineChart.getXYPlot().getDomainAxis();
		// 以上获得图标中间部分，即plot，这个就是中间的很重要的部分,不同的类型有不同的plot，一般的叫做CategoryPlot，但是XY类型叫做XYPlot
		// 然后获取横坐标，可以修改字体，这样就不会乱码
		valueAxis.setLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
		valueAxis.setAxisLinePaint(paint3);
		valueAxis.setLabelPaint(paint3);
		Plot plot = lineChart.getXYPlot();
		plot.setBackgroundPaint(paint4);
		plot.setOutlinePaint(paint3);
		lineChart.getXYPlot().getRangeAxis().setLabelFont(font);
		; // 设置纵坐标
			// lineChart.getXYPlot().getRangeAxis().setAutoRange(true);;
		//lineChart.getXYPlot().getRangeAxis().setLowerBound(5.0);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setBackground(Color.GREEN);
		chartPanel.setBounds(238, 13, 864, 617);
		contentPane.add(chartPanel);

		String[] s = new String[] { "已知p", "已知T" };

		createComboBox();

		text1 = new JTextPane();
		text1.setBounds(100, 423, 106, 32);
		btn1 = new JButton("\u8BA1\u7B97\u9971\u548C\u51FD\u6570");
		btn1.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btn1.setBackground(ConstantForUI.COM_COLOR);
		UtilForUI.glorifycal(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			calRegion4();
			}
		});
		btn1.setBounds(39, 521, 155, 32);
		editor1 = new JEditorPane();
		editor1.setBounds(70, 590, 106, 21);
		contentPane.setLayout(null);
		contentPane.add(labelAll);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(text1);
		contentPane.add(btn1);
		contentPane.add(editor1);
		
		JLabel lblNewLabel = new JLabel("\u9971\u548C\u51FD\u6570\u65F6\u7684\u8BA1\u7B97---");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(21, 373, 248, 40);
		contentPane.add(lblNewLabel);
		
		JLabel Label4 = new JLabel("\u8BF7\u9009\u62E9\u5206\u533A\uFF1A 2\u533A");
		Label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		Label4.setBounds(31, 70, 150, 23);
		contentPane.add(Label4);
		
		JLabel Label5 = new JLabel("\u56FA\u5B9A\u7C7B\u578B T =1000");
		Label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		Label5.setBounds(33, 114, 173, 21);
		contentPane.add(Label5);
		
		JLabel label6 = new JLabel("\u9009\u62E9\u76EE\u6807\u51FD\u6570\uFF1A \u81EA\u7531\u80FDg");
		label6.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		label6.setBounds(21, 151, 210, 32);
		contentPane.add(label6);
		
		JButton btn2 = new JButton("\u8BA1\u7B97\u5E76\u7ED8\u56FE");
		btn2.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btn2.setBounds(41, 242, 165, 32);
		contentPane.add(btn2);
	}

	protected void calRegion4() {
		if (UtilForUI.checkNum(text1.getText())) {
			Calculator calRegion4 = new Calculator();
			if(label1.getText().equals("\u5DF2\u77E5p")){
				editor1.setText(calRegion4.calRegion4_p(Double.parseDouble(text1.getText())));
			}else if(label1.getText().equals("\u5DF2\u77E5T")){
				editor1.setText(calRegion4.calRegion4_T(Double.parseDouble(text1.getText())));
			}else{
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
		String str1 = "\u5DF2\u77E5p";
		String str2 = "\u5DF2\u77E5T";

		label1 = new JLabel(str1);
		label2 = new JLabel("---\u5DF2\u77E5p---");
		label3 = new JLabel("---\u5DF2\u77E5T---");
		label2.setVisible(false);
		label3.setVisible(false);
		label2.setBorder(BorderFactory.createLineBorder(Color.red));
		label3.setBorder(BorderFactory.createLineBorder(Color.red));
		
		label1.setIcon(new ImageIcon(StaUIFrame.class.getResource("/resource/down.png")));
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchSelect(label2, label3);
			}
		});
		UtilForUI.glorifyLabel(label1);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBackground(ConstantForUI.BACK_COLOR);
		label1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label1.setBounds(0, 423, 118, 32);
		// 打开的剩余组件
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label1.setText(str1);
				switchSelect(label2, label3);
			}

		});
		UtilForUI.glorifyLabel(label2);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		
		//用以下代码能达到标签不透明
		label2.setOpaque(true);
		label2.setBackground(Color.CYAN);
		
		label2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label2.setBounds(0, 449, 142, 25);

		label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label1.setText(str2);
				switchSelect(label2, label3);
			}

		});
		UtilForUI.glorifyLabel(label3);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBackground(ConstantForUI.BACK_COLOR);
		label3.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		label3.setBounds(0, 474, 141, 25);

	}

	private XYSeriesCollection createXYSeriesCollection() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		double T = 1000;
		double p = 10;
		Calculator cal = new Calculator();
		double valueMax = cal.test(p, T);
		double valueMin = cal.test(p, T);
		XYSeries series = new XYSeries("s=f(p,T)");

		for (; p < 100; p++) {
			if (cal.test(p, T) > valueMax) {
				valueMax = cal.test(p, T);
			} else if (cal.test(p, T) < valueMin) {
				valueMin = cal.test(p, T);
			}
			series.add(p, cal.test(p, T));
		}
		dataset.addSeries(series);
		System.out.println(valueMin + "*" + valueMax);
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
}
