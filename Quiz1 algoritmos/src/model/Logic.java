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
		listTriangulos = new ArrayList<>();
		
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
		
		for(int i = 0; i< listTriangulos.size(); i++) {
			listTriangulos.get(i).pintar();
			listTriangulos.get(i).mover();
		}
		
		crearTriangulo();
			
		
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
	
	public void moverFigura() {
		for(int i = 0; i< listCirculos.size(); i++) {
			if(this.app.mouseX> listCirculos.get(i).getPosX() &&
					this.app.mouseX< listCirculos.get(i).getPosX() + listCirculos.get(i).getTam() &&
					this.app.mouseY> listCirculos.get(i).getPosY() &&
					this.app.mouseY< listCirculos.get(i).getPosY() + listCirculos.get(i).getTam()) {
				listCirculos.get(i).setStop(!listCirculos.get(i).isStop());
			}
		}
		
		for(int i = 0; i< listCuadrados.size(); i++) {
			if(this.app.mouseX> listCuadrados.get(i).getPosX() &&
					this.app.mouseX< listCuadrados.get(i).getPosX() + listCuadrados.get(i).getTam() &&
					this.app.mouseY> listCuadrados.get(i).getPosY() &&
					this.app.mouseY< listCuadrados.get(i).getPosY() + listCuadrados.get(i).getTam()) {
				listCuadrados.get(i).setStop(!listCuadrados.get(i).isStop());
			}
		}
		
		
	}
	
	public void crearTriangulo() {
		for(int i=0; i<listCirculos.size(); i++) {
			for(int j=0; j<listCuadrados.size(); j++) {
				if(listCirculos.get(i).getPosX()> listCuadrados.get(j).getPosX()
						&& listCirculos.get(i).getPosX()< (listCuadrados.get(j).getPosX()+listCuadrados.get(j).getTam()) &&
						listCirculos.get(i).getPosY()> listCuadrados.get(j).getPosY() && 
						listCirculos.get(i).getPosY()< (listCuadrados.get(j).getPosY()+listCuadrados.get(j).getTam())	) {
					
					int valor = listCirculos.get(i).getValor() +  listCuadrados.get(j).getValor();
					listTriangulos.add(new Triangulo(this.app, (int) this.app.random(30,100),(int) this.app.random(100,500) , (int) this.app.random(100,500), (int) this.app.random(10), valor));
					
					
					
				}
			}
		}
	}
	
}
