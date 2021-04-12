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
		textStrings = app.loadStrings("./../texto");
		
		listCirculos = new ArrayList<>();
		listCuadrados = new ArrayList<>();
		
		for(int i=0; i< textStrings.length;i++) {
			String [] txtSplit = textStrings[i].split(" ");
			if(txtSplit[0].equals("Cuadrado")) {
				listCuadrados.add(new Cuadrado(app, Integer.parseInt(txtSplit[1]),Integer.parseInt(txtSplit[2]), Integer.parseInt(txtSplit[3]),Integer.parseInt(txtSplit[4]), Integer.parseInt(txtSplit[5])));

			} if(txtSplit[0].equals("Circulo")) {
					listCirculos.add(new Circulo(app, Integer.parseInt(txtSplit[1]),Integer.parseInt(txtSplit[2]), Integer.parseInt(txtSplit[3]),Integer.parseInt(txtSplit[4]), Integer.parseInt(txtSplit[5])));
				}
		}
	}
	
	public void pintar() {
		for(int i = 0; i< listCirculos.size(); i++) {
			listCirculos.get(i).pintar();
			listCirculos.get(i).mover();
		}
		
		for(int i = 0; i< listCuadrados.size(); i++) {
			listCuadrados.get(i).pintar();
			listCuadrados.get(i).mover();
		}
		
		
			
		
	}
	
	public void nuevaFigura() {
		int r = (int)this.app.random(3);
		if(r==1) {
			listCuadrados.add(new Cuadrado(this.app, (int) this.app.random(30,100),(int) this.app.random(100,500) , (int) this.app.random(100,500), (int) this.app.random(10), (int) this.app.random(30)));
		} 
		if(r==2) {
			listCirculos.add(new Circulo(this.app, (int) this.app.random(30,100),(int) this.app.random(100,500) , (int) this.app.random(100,500), (int) this.app.random(10), (int) this.app.random(30)));
		}
	}
	
}
