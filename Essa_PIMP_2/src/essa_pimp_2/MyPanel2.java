/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

import static essa_pimp_2.ElementContainer.elements;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Pawel.Figat
 */
public class MyPanel2 extends javax.swing.JPanel
{

    /**
     * Creates new form MyPanel2
     */
    public MyPanel2()
    {
        initComponents();
    }

    @Override
    public void paint(Graphics g)
    {
        //     super.paint(g); //To change body of generated methods, choose Tools | Templates.

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.black);

     //  g.drawLine(10,10,500, 500);
    //   g.drawLine(10,10,510, 500);
    for (Element elem :  elements)
                 {
           // g.drawRect( elem.getPosX() , elem.getPosY(), elem.getWidth(), elem.getHeight());
            elem.draw(g);
       /*    if(elem.getClass() == GlassElement.class) 
             {
             GlassElement el1  =  (GlassElement)elem;
             el1.draw(g);
             }
           if(elem.getClass() == SteelElement.class) 
             {
             SteelElement el1  =  (SteelElement)elem;
             el1.draw(g);
             }
           */
           
          } 

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
