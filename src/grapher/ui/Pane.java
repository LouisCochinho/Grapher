/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher.ui;

import grapher.fc.FunctionFactory;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;

/**
 *
 * @author antoi
 */
public class Pane extends JSplitPane {

	protected Grapher grapher;
	protected LeftPane leftPane;
	protected Vector<String> expressions;

	public Pane() {
		grapher = new Grapher();
		leftPane = new LeftPane();
		this.setLeftComponent(leftPane);
		this.setRightComponent(grapher);
		expressions = new Vector<>();
	}

	public void add(String expression) {
		grapher.add(expression);
		expressions.add(expression);
		leftPane.addListData(expression);
	}

	public Grapher getGrapher() {
		return grapher;
	}

	public void remove(Object o) {
		grapher.removeExpression(o);
		expressions.remove(o);
		leftPane.removeListData(o);
	}

	public LeftPane getLeftPane() {
		return leftPane;
	}

}
