package grapher.ui;

import java.awt.Color;
import java.util.Random;

public class MyColor extends Color{

	private Color color;
	public MyColor(int r, int g, int b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}

	public MyColor(Color c){
		super(c.getRed(),c.getGreen(),c.getBlue());
		this.color = c;
	}

	public String toString(){
		return "";
	}

	public Color getColor(){
		return this.color;
	}

	public static MyColor chooseRandomColor(){
		Random rand = new Random();
		int choosenIndex = rand.nextInt(3);
		Color choosenColor = Color.WHITE;
		switch(choosenIndex){
		case 0 : choosenColor = Color.RED;break;
		case 1 : choosenColor = Color.GREEN;break;
		case 2 : choosenColor = Color.CYAN;break;
		default : choosenColor = Color.WHITE;break;
		}

		return new MyColor(choosenColor);
	}
}
