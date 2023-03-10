package clases;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Puzzle extends JFrame{
    
    
	public static Container contenedor;
	public static Board board;
	private BufferedImage img;
	
	public Puzzle(){
		this.setTitle("Rompecabezas");
		this.setSize(605,476);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contenedor = this.getContentPane();
		
		
		try {
			img = ImageIO.read(new File("C:\\Users\\Mario Moreno\\Pictures\\Saved Pictures\\homero.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new Board(3, img);
		contenedor.add(board);
		this.setVisible(true);
	}
	public static void main(String[] args){
                    Puzzle puzzle = new Puzzle();
	}
}