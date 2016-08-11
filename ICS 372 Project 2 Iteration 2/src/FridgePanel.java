/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 
 * Customizes the fridge and the freezer panels
 *
 */

public class FridgePanel extends JPanel {

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Image image;

	    public FridgePanel(URL url) {
	    	
	    	java.net.URL imgURL = url;
	        if (imgURL != null) {
	           
	        this.image = new ImageIcon(url).getImage();
	        }
	    }
	    /**
	     * does the drawing on the panels
	     */
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
	    
	}
}
