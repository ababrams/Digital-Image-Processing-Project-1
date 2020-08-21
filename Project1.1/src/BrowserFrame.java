import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BrowserFrame extends JFrame {
	public BrowserFrame() {
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent a) {
				if(a.getKeyChar() == 'n' || a.getKeyCode() == KeyEvent.VK_SPACE) {
					// nextImage();
					// System.out.println("Next Image");
				}
				
				if(a.getKeyChar() == 'p') {
					// previousImage();
					// System.out.println("Previous Image");
				}
				
				if(a.getKeyChar() == 'q') {
					// System.out.println("Quit");
					System.exit(0);
				}	
			}

			@Override
			public void keyReleased(KeyEvent a) {
				
			}
			
			@Override
			public void keyTyped(KeyEvent a) {
	
			}
		});
	}
}
