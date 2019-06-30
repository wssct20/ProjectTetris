package CT12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ui {
	
	//=========================================================
	
	
	
	//=========================================================
	
	public static void main(String[] args) {
		backend.main(args);
	}
	public static void UIstart(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(backend.gamematrix[1][1].split("-")[0]);
		
		JFrame frame = new JFrame("Tetris Game CT12"); 				//create new Frame
		frame.setSize(600, 1000);									//set start size 		
		frame.setVisible(true);										//Window becomes visible
		frame.setLayout(new GridLayout(15, 10));					//Elements in the container "frame" are displayed in a GridLayout
	    for (int i=0; i<15*10; i++) {
	    	JPanel J = new JPanel();
	    	switch ((int)(Math.random()*6)) {
	    	case 0:
	    		J.setBackground(Color.BLACK);
	    		break;
	    	case 1:
	    		J.setBackground(Color.GREEN);
	    		break;
	    	case 2:
	    		J.setBackground(Color.BLUE);
	    		break;
	    	case 3:
	    		J.setBackground(Color.MAGENTA);
	    		break;
	    	case 4:
	    		J.setBackground(Color.RED);
	    		break;
	    	case 5:
	    		J.setBackground(Color.ORANGE);
	    		break;
	    	}
	    	frame.add(J);
	    }
	    
	    
	 // Keyboard controls
 		frame.addKeyListener(new KeyListener() {
 			public void keyTyped(KeyEvent key) {
 			}
 			
 			public void keyPressed(KeyEvent key) {
 				System.out.println("pressed key \""+key.getKeyChar()+"\" with KeyCode " + key.getKeyCode());
 				try {
 				switch (key.getKeyCode()) {
 				case KeyEvent.VK_UP:
 					backend.currentstone.rotate();
 					break;
 				case KeyEvent.VK_DOWN:
 					if (!backend.fastdropping) {
	 					backend.fastdropping = true;
	 					backend.Dropper.interrupt();
 					}
 					break;
 				case KeyEvent.VK_LEFT:
 					backend.currentstone.move(-1);
 					break;
 				case KeyEvent.VK_RIGHT:
 					backend.currentstone.move(+1);
 					break;
 				case KeyEvent.VK_SPACE:
 					backend.currentstone.drop();
 					break;
 				}
 				} catch (NullPointerException e) {} //catch error if currentstone is null
 			}
 			
 			public void keyReleased(KeyEvent key) {
 				System.out.println("released key \""+key.getKeyChar()+"\" with KeyCode " + key.getKeyCode());
 				switch (key.getKeyCode()) {
 				case KeyEvent.VK_DOWN:
 					backend.fastdropping = false;
 					break;
 				}
 			}
 		});
	    
		
		//==========================================================
		
		
		
		//==========================================================
 		
	}
	
	
}