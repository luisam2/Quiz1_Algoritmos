package model;

import processing.core.PApplet;

public class Triangulo {

	 private PApplet app;
	private int tam;
	private int posX;
	private int posY;
	private int dir;
	private int valor;
	private boolean stop;

	public Triangulo(PApplet app, int tam, int posX, int posY, int dir, int valor) 
		// TODO Auto-generated constructor stub
	 {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.tam = tam;
		this.posX = posX;
		this.posY = posY;
		this.dir = dir;
		this.valor = valor;
		this.stop = true;
	}
	
	public void pintar() {
		// TODO Auto-generated method stub
		
		
		this.app.triangle(posX-tam, posY+tam, posX, posY-tam, posX+tam,posY+tam);
		this.getApp().fill(0);
		this.getApp().text(""+ getValor(), getPosX(), getPosY());
	}
	
	public void mover() {
		if(stop) {
			this.posX += this.dir;
			this.posY += this.dir;
			
			if(this.posX < 0|| this.posX>500 || this.posY <0 || this.posY>500) {
				this.dir*= -1;
			}
		} 
		
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}