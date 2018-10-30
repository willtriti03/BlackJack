package blackjackFrame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image img;
	public ImagePanel(){}
	public ImagePanel(String path){
		this(new ImageIcon(path).getImage());
	} 
	public ImagePanel(Image img) {
		this.img =img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void setImage(String img) {
		// TODO Auto-generated method stub
		this.img = new ImageIcon(img).getImage();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, 0, 0, null);
	}

}
