/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Pawel.Figat
 */
public class SteelElement extends Element  
{

    public SteelElement(int posX, int posY, int width, int height)
    {
        super(posX, posY, width, height);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.LIGHT_GRAY);
     //  g.setColor(new Color(123,123,123));
       g.fillRect(posX, posY, width, height);
        g.setColor(Color.GRAY);  
        g.drawRect(posX, posY, width, height);
    
    }
    
}
