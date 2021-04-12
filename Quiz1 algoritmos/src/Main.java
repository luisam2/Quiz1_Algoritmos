


import model.Logic;
import processing.core.PApplet;

public class Main extends PApplet {
	

	public static void main(String[]args) {
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(500,500);
		
	}
	
	Logic logic;
	public void setup() {
		
		 logic = new Logic(this);
	}
	
	public void draw() {
		background(255);
		logic.pintar();
	}

	public void mousePressed() {
		
			if(mouseButton == RIGHT) {
				logic.nuevaFigura();
			}
			//control.getLogic().moverFigura();
		
	}
	
	

}//FINAL 
