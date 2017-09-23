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
		
		JFreeChart lineChart = ChartFactory.createLineChart("标题", "压强p", "关于 s", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		/**
		 * 以下代码为了解决乱码问题，将标题和自件的字体都重新设置
		 */
		//lineChart.setBackgroundPaint(getBackground());
		//lineChart.setBorderVisible(false);
		//lineChart.getTextAntiAlias(
		//lineChart.geta;
		//lineChart.getLegend().g
		lineChart.getTitle().setFont(font);
		lineChart.getLegend().setItemFont(font);  
		CategoryPlot plot=(CategoryPlot)lineChart.getPlot();//获得图标中间部分，即plot，这个就是中间的很重要的部分
        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,12));//设置横坐标字体
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
