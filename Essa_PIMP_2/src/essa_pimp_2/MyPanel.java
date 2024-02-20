/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static essa_pimp_2.ElementContainer.elements;
/**
 *
 * @author Pawel.Figat
 */
public class MyPanel  extends JPanel
{

     @Override
    public void paint(Graphics g)
    {
   //     super.paint(g); //To change body of generated methods, choose Tools | Templates.
    
        g.setColor(Color.white);
        g.fillRect(0, 0,getWidth(), getHeight());

                g.setColor(Color.black);

  ///  g.drawLine(10,10,500, 500);
    for (Element elem :   elements)
          {
           // jPanel2.getGraphics().drawRect( elem.getPosX() , elem.getPosY(), elem.getWidth(), elem.getHeight());
            elem.draw( getGraphics());
          }
      
    
    }
    
  void costam()
  {
      System.out.println("costam");  
  }
    
    
}
