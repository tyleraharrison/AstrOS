package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Commands.Commands;
import HomePanels.Appetizers;
import HomePanels.Desserts;
import HomePanels.Entrees;
import HomePanels.Options;
import HomePanels.Pizza;
import HomePanels.Ticket;
import Main.MenuItem;
import Vars.Vars;

public class Home {
	public static JPanel panel = new JPanel();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		Appetizers.createView(g);
		Entrees.createView(g);
		Pizza.createView(g);
		Desserts.createView(g);
		Ticket.createView(g);
		Options.createView(g);

		MenuItem buttonHeadAppetizers = Commands.createHeaderButton("Appetizers", 5);
		MenuItem buttonHeadEntrees = Commands.createHeaderButton("Misc. Entrees", 215);
		MenuItem buttonHeadPizza = Commands.createHeaderButton("Pizza", 425);
		MenuItem buttonHeadDesserts = Commands.createHeaderButton("Desserts", 635);
		buttonHeadAppetizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Entrees.panel);
				panel.remove(Pizza.panel);
				panel.remove(Desserts.panel);
				panel.add(Appetizers.panel);
				Commands.changeButtonColor(buttonHeadEntrees, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadPizza, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadDesserts, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadAppetizers, Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		Commands.changeButtonColor(buttonHeadAppetizers, Vars.colorDefaultHeaderButtonSelected);
		panel.add(buttonHeadAppetizers);
		buttonHeadEntrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Appetizers.panel);
				panel.remove(Pizza.panel);
				panel.remove(Desserts.panel);
				panel.add(Entrees.panel);
				Commands.changeButtonColor(buttonHeadAppetizers, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadPizza, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadDesserts, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadEntrees, Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel.add(buttonHeadEntrees);
		buttonHeadPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Appetizers.panel);
				panel.remove(Entrees.panel);
				panel.remove(Desserts.panel);
				panel.add(Pizza.panel);
				Commands.changeButtonColor(buttonHeadAppetizers, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadEntrees, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadDesserts, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadPizza, Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel.add(buttonHeadPizza);
		buttonHeadDesserts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Appetizers.panel);
				panel.remove(Pizza.panel);
				panel.remove(Entrees.panel);
				panel.add(Desserts.panel);
				Commands.changeButtonColor(buttonHeadAppetizers, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadPizza, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadEntrees, Vars.colorDefaultHeaderButton);
				Commands.changeButtonColor(buttonHeadDesserts, Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel.add(buttonHeadDesserts);

		panel.add(Options.panel);
		panel.add(Appetizers.panel);
		panel.add(Ticket.panel);
	}
}
