package ren.junsong.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ren.junsong.util.Calculator;

public class StaUIFrame extends JFrame {
	private JLabel labelAll;
	private JPanel contentPane;
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
		setBounds(100, 100, 992, 685);
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
		
		JFreeChart lineChart = ChartFactory.createLineChart("����", "ѹǿp", "���� s", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		/**
		 * ���´���Ϊ�˽���������⣬��������Լ������嶼��������
		 */
		//lineChart.setBackgroundPaint(getBackground());
		//lineChart.setBorderVisible(false);
		//lineChart.getTextAntiAlias(
		//lineChart.geta;
		//lineChart.getLegend().g
		lineChart.getTitle().setFont(font);
		lineChart.getLegend().setItemFont(font);  
		CategoryPlot plot=(CategoryPlot)lineChart.getPlot();//���ͼ���м䲿�֣���plot����������м�ĺ���Ҫ�Ĳ���
        CategoryAxis categoryAxis=plot.getDomainAxis();//��ú�����
        categoryAxis.setLabelFont(new Font("΢���ź�",Font.BOLD,12));//���ú���������
       // categoryAxis.setUpperMargin(20.2);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setBounds(410, 27, 515, 374);
		contentPane.add(chartPanel);
		
		contentPane.setLayout(null);
		contentPane.add(labelAll);
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		double T=1000;
		Calculator cal=new Calculator();
		for(double p=10;p<100;p++){
			dataset.addValue(cal.test(p, T), "s=f(p,T)", Double.toString(p));
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

}
