package HomePanels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import HomePanels.OptionsPanels.OptionPanel;
import Main.MenuItemButton;
import Vars.LocalSQL;
import Vars.Vars;

public class Appetizers {
	public static JPanel panel = new JPanel();
	public static ArrayList<ArrayList<String>> appetizers;
	public static ArrayList<MenuItemButton> appetizerButtons = new ArrayList<MenuItemButton>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		appetizers = LocalSQL.Appetizers;

		JLabel label = new JLabel("Appetizers");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);

		setAppetizersFromSQL();

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}
	
	public static void setAppetizersFromSQL() {
		for (int i = 0; i < appetizers.size(); i++) {
			if (i < 4) {
				appetizerButtons.add(Commands.createMenuItemButton(appetizers.get(i).get(0), ((i * 210) + 5), 100,Double.parseDouble(appetizers.get(i).get(1))));
			} else if (i < 8) {				
				appetizerButtons.add(Commands.createMenuItemButton(appetizers.get(i).get(0), (((i - 4) * 210) + 5), 210,Double.parseDouble(appetizers.get(i).get(1))));
			} else {
				appetizerButtons.add(Commands.createMenuItemButton(appetizers.get(i).get(0), (((i - 8) * 210) + 5), 320,Double.parseDouble(appetizers.get(i).get(1))));
			}
		}

		for (int i = 0; i < appetizerButtons.size(); i++) {
			String nameOfItem = appetizerButtons.get(i).getName();
			double priceOfItem = appetizerButtons.get(i).getPrice();
			appetizerButtons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Options.assignPanel(nameOfItem);
					 Commands.addToTicket(Commands.ticketSpacing(nameOfItem, priceOfItem),priceOfItem);
					 OptionPanel.updatePanel();
				}});
			panel.add(appetizerButtons.get(i));
		}
	}
}
