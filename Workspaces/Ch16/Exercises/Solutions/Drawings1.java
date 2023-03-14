// Chapter 16 Question 1

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawings1 extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int w = getWidth();
    int h = getHeight();
//    g.setColor(Color.RED);
//    g.drawRect(w/4, h/4, w/2, h/2);
//    g.setColor(Color.BLUE);
//    g.setFont(new Font("Serif", Font.PLAIN, 18));
//    g.drawString("Happy Birthday!", w/4 + 15, h/2 + 5);
    //b
//    g.setColor(Color.BLACK);
//    g.fillRoundRect(w/4, h/4, w/2, h/2, w/4, h/4);
//    g.setColor(Color.WHITE);
//    g.fillOval(w/4, h/4, w/4, h/4);
//    g.fillOval(w/2, h/2, w/4, h/4);
//    g.fillOval(w/4, h/2, w/4, h/4);
//    g.fillOval(w/2, h/4, w/4, h/4);
    //c
    int[] xPoints = {w/2, w/4, w/2, 3*w/4};
    int[] yPoints = {h/4,h/2,3*h/4,h/2};
    g.setColor(Color.BLACK);
    g.fillPolygon(xPoints,yPoints, 4);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Drawings");
    window.setBounds(100, 100, 300, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel canvas = new Drawings1();
    canvas.setBackground(Color.WHITE);
    window.getContentPane().add(canvas);
    window.setVisible(true);
  }
}

