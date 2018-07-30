package hunterSolidayProgram1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HunterSolidayProgram7{

	public int x;
	public int y;
	public int coorX;
	public int coorY;
	public int mouseX;
	public int mouseY;
	public boolean mouseFlag;
	Point pt;
	
	public static void main(String[] args)
	{
		JFrame frame= new JFrame("testo"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		frame.add(panel);
		JButton oval =new JButton("Oval");
		JButton image =new JButton("Image");
		JButton center =new JButton("Center");
		JButton name =new JButton("Hunter Soliday");
		HelloArcade o = new HelloArcade();
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		panel.setLayout(gridbag);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor=GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(oval, c);
		panel.add(oval);
		
		
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(image, c);
		panel.add(image);
		
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(center, c);
		panel.add(center);
		
		c.gridx = 3;
		c.gridy = 0;
		gridbag.setConstraints(name, c);
		panel.add(name);
		
		frame.setSize(7680, 4320);// oval messes up at resolutions higher than the frame size at this point, so I just set it at 8k, and it will work on all displays
		c.gridwidth=4;
		c.ipady=frame.getHeight()-oval.getHeight();
		c.weightx=0;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty=1.0;
		o.setBackground(Color.GREEN);
		gridbag.setConstraints(o, c);
		panel.add(o);
		frame.setSize(800, 600);	
		o.drawPanel.model.object.x=(int)((double)frame.getWidth()/(double)2-(double)o.drawPanel.model.object.w);
		o.drawPanel.model.object.y=((frame.getHeight())/2)-o.drawPanel.model.object.y;
		o.repaint();
		frame.setVisible(true);
	}
	
}
