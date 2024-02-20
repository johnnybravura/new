/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

import java.awt.Graphics;

/**
 *
 * @author Pawel.Figat
 */
public abstract class Element extends Object implements MyDrawInterface
{
    
    //atrybuty
     protected int posX;
     protected int posY;
    
     protected int width;
     protected int height;
    
   //konstruktor 

    public Element(int posX, int posY, int width, int height)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

   

    public int getPosX()
    {
        return posX;
    }

    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "Element{" + "posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + '}';
    }
 
  /*
    public void draw(Graphics g)
    {
     g.drawRect(posX, posY, width, height);
    }  */

    int getArea() {
        return height * width;
    }

    int getWeight(int weight) {
        return weight; 
    }
  public void calculateValueToWeightRatio() {
            // Implementacja obliczania stosunku wartości do wagi
        }
        public int compareTo(Element other) {
            return Integer.compare(this.width, other.width);
        }
}
