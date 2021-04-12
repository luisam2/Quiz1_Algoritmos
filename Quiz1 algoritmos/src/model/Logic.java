package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	String [] textStrings;
	private PApplet app;
	private ArrayList<Cuadrado> listCuadrados;
	private ArrayList<Circulo> listCirculos;
	private ArrayList<Triangulo> listTriangulos;
	
	public Logic(PApplet app) {
		this.app = app;
		
		for(int i=0; i< textStrings.length;i++) {
			String [] txtSplit = textStrings[i].split(" ");
			if(txtSplit[0].equals("Cuadrado")) {
				listCuadrados.add(new Cuadrado(app, Integer.parseInt(txtSplit[1]),Integer.parseInt(txtSplit[2]), Integer.parseInt(txtSplit[3]),Integer.parseInt(txtSplit[4]), Integer.parseInt(txtSplit[5])));

			} if(txtSplit[0].equals("Circulo")) {
					listCirculos.add(new Circulo(app, Integer.parseInt(txtSplit[1]),Integer.parseInt(txtSplit[2]), Integer.parseInt(txtSplit[3]),Integer.parseInt(txtSplit[4]), Integer.parseInt(txtSplit[5])));
				}
		}
	}
	
	
}
