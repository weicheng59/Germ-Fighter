package view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.GermFighter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class GameGraphicView extends JPanel implements Observer{
	private Image ground, wbc, germ, item;
	private TextViewGame germFighter;
	
	public GameGraphicView(TextViewGame germFighter){
		this.germFighter = germFighter;
		try {
			ground = ImageIO.read(new File("images/Ground.png"));
			wbc = ImageIO.read(new File("images/Basic Cell.png"));
			germ = ImageIO.read(new File("images/Basic Germ.png"));
			item = ImageIO.read(new File("images/Attack Booster.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Observable observed, Object arg) {
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    for (int imagesX = 0; imagesX < 5; imagesX++) {
	    	for(int imagesY = 0; imagesY < 5; imagesY++){
	    			g2.drawImage(ground, imagesX*35, imagesY*35, null);// paints the ground
	    		if(germFighter.getRoom(imagesY, imagesX).toString().equals("[G]")){// paints the Germ
	    			g2.drawImage(germ, imagesX*35, imagesY*35, null);
	    		}
	    		else if(germFighter.getRoom(imagesY, imagesX).toString() == "[W]"){// paints the WBC
	    			g2.drawImage(wbc, imagesX*35, imagesY*35, null);
	    		}
	    		else if(germFighter.getRoom(imagesY, imagesX).toString() == "[I]"){// paints Item
	    			g2.drawImage(item, imagesX*35, imagesY*35, null);
	    		}
	    		repaint();
	    	}
	    }
	}
}