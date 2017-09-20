package ren.junsong.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 * 用于UI美化的类
 * @author RenJunsong
 *
 */
public class UtilForUI {
	public static void glorify(JCheckBox checkBox){
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkBox.setBackground(ConstantForUI.ACT_COLOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!checkBox.isSelected()){
					checkBox.setBackground(ConstantForUI.COM_COLOR);
				}
			}
		});
	}
	public static void glorifycl(JButton btn){
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
	public static void glorifycal(JButton btn){
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(ConstantForUI.BTN_COLOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(ConstantForUI.COM_COLOR);
			}
		});
	}
}
