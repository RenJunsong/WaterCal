package ren.junsong.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 * 用于UI美化的类
 * 
 * @author RenJunsong
 *
 */
public class UtilForUI {
	/**
	 * 检查是否为数字
	 */
	public static boolean checkNum(String str) {
		if(str==null||str.trim().equals("")){
			return false;
		}
		int i = 0;
		for (char temp : str.toCharArray()) {
			if ((temp > '9' || temp < '0') && (temp != '.')) {
				return false;
			} else if (temp == '.') {
				i++;
			}
		}
		if (i < 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void glorify(JCheckBox checkBox) {
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkBox.setBackground(ConstantForUI.ACT_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!checkBox.isSelected()) {
					checkBox.setBackground(ConstantForUI.COM_COLOR);
				}
			}
		});
	}

	public static void glorifycl(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(ConstantForUI.AL_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(ConstantForUI.COM_COLOR);
			}
		});
	}

	public static void glorifycal(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(ConstantForUI.BTN_COLOR);
				btn.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(ConstantForUI.COM_COLOR);
				btn.setForeground(ConstantForUI.FONT_COLOR);
			}
		});
	}

	public static void glorifyLabel(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(ConstantForUI.LINK_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				label.setForeground(ConstantForUI.FONT_COLOR);

			}
		});
	}
}
