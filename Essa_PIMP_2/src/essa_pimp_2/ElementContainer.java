/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ElementContainer implements Serializable {
    public static ArrayList<Element> elements = new ArrayList<>();
  //  public static ArrayList<Element> tab2;

    public static void sort() {
        int licznik = 0;
        boolean czy_zmiana;

        for (int j = 0; j < elements.size(); j++) {
            czy_zmiana = false;
            for (int i = 0; i < elements.size() - 1; i++) {
                Element actual = elements.get(i);
                Element next = elements.get(i + 1);

                ++licznik;

                if (actual.compareTo(next) < 0) {
                    czy_zmiana = true;
                    elements.set(i, next);
                    elements.set(i + 1, actual);
                }
            }
            if (!czy_zmiana) {
                break;
            }
        }

        System.out.println("Liczba porównań: " + licznik);
    }

    public static class GreedyKnapsack {
        public static void greedyKnapsack(ArrayList<Element> inputElements, int capacity) {
            for (Element element : inputElements) {
                element.calculateValueToWeightRatio();
            }

            Collections.sort(inputElements, Collections.reverseOrder());

            int currentWeight = 0;
            int totalValue = 0;

            for (Element element : inputElements) {
                if (currentWeight + element.getWidth() <= capacity) {
                    element.setPosX(currentWeight);
                    element.setPosY(0);
                    currentWeight += element.getWidth();
                    totalValue += element.getHeight();
                }
            }

            System.out.println("Total value: " + totalValue);
        }
    }}

    /*public static class Element implements Comparable<Element>, Serializable {
        private int width;
        private int height;
        private int posX;
        private int posY;

        public Element(int width, int height, int posX, int posY) {
            this.width = width;
            this.height = height;
            this.posX = posX;
            this.posY = posY;
        }

        public void setPosX(int x) {
            this.posX = x;
        }

        public void setPosY(int y) {
            this.posY = y;
        }

        public void calculateValueToWeightRatio() {
            // Implementacja obliczania stosunku wartości do wagi
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public int getPosX() {
            return this.posX;
        }

        public int getPosY() {
            return this.posY;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.width, other.width);
        }

        void draw(Graphics g) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        void setHeight(int h) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        void setWidth(int w) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    

    
        }
    }*/



