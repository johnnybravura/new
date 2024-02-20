/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

/**
 *
 * @author Pawel.Figat
 */
public class FactoryElement
{
   static Element build(int rodzaj)
   {
     Element el = (rodzaj%2==0)? new GlassElement(0, 0,0, 0) : new SteelElement(0, 0,0, 0);
     return el;
   }
}
