 
package essa_pimp_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Essa_PIMP_2 extends JFrame implements ActionListener
{

    public Essa_PIMP_2()
    {
        setSize(600,700);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton b1 = new JButton("kliknij mnie");
         JButton b2 = new JButton("kliknij mnie");
     /*  b1.addActionListener(new ActionListener() //w locie
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("klinieto");
            }
        }); 
        
         b1.addActionListener(new MyListener()); //obiekt zewnetrznej klasy*/
  
        b1.addActionListener(this); //obiekt biezacej klasy
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setBackground(Color.red);
         p2.setBackground(Color.green);
       // setLayout(new BorderLayout()); //zarzadca rozmieszczeniem kompe
        
      //  setLayout(new FlowLayout()); //zarzadca rozmieszczeniem kompe
        
      //   setLayout(new GridLayout(2,3)); //zarzadca rozmieszczeniem kompe
        
         setLayout(null);
         
        add(p1,"Center");  
        
        p1.setBounds(10, 10, 100, 10);
         p2.setBounds(10, 40, 100, 10);
        add(b1,BorderLayout.SOUTH );
         b1.setBounds(10, 70, 100, 10);
        add(p2,"Center");  
        add(b2,BorderLayout.SOUTH ); 
          b2.setBounds(10, 90, 100, 10);
        
        setVisible(true);
    }

   
    
 public static void main(String[] args)
    {
   /*   Element el = new Element(0, 0, 0, 0);
      
      el.setPosX(120);
      el.setWidth(10);
      el.setHeight(10);
            
      System.out.pri/*"+ el);*/
      
     new  Essa_PIMP_2();
      
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        System.out.println("klinieto 3");
    }
  
 
 
 
}



class MyListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        System.out.println("klinieto 2");
    
    
    }

 
     



}