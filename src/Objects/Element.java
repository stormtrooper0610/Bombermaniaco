/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
import java.awt.Image;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel-PC
 */
public abstract class Element extends Thread{
    private int positionX,positionY;
    JLabel imageLabel;
<<<<<<< HEAD
=======
    private JPanel panel;
>>>>>>> origin/master
    private boolean hasPower,hasDoor,isBomb;
    private Image img;
    

    public Element(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.imageLabel=new JLabel();
        this.hasDoor=false;
        this.hasPower=false;
        this.isBomb=false;
        this.img=null;
    }

    public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Image getImg() {
        return img;
    }
    
    public JLabel getImageLabel(){
        return this.imageLabel;
    }
    
    public boolean isBomb(){
        return this.isBomb;
    }
    
    public void setIsBomb(boolean isBomb){
        this.isBomb=isBomb;
    }
    
    public boolean isBomb(){
        return this.isBomb;
    }
    
    public void setIsBomb(boolean isBomb){
        this.isBomb=isBomb;
    }
    
    public void hasDoor(){
        this.hasDoor=true;
    }
    public boolean checkForDoor(){
        return this.hasDoor;
    }
    
    public boolean checkForPower(){
        return this.hasPower;
    }
    
    public void hasPower(){
        this.hasPower=true;
    }
    
    public void setLabel(String name){
        ImageIcon img = new ImageIcon(Hero.class.getResource("/Images/"+name));
        this.getImageLabel().setIcon(img);
<<<<<<< HEAD
        instance.getPanel().add(this.getImageLabel());
=======
        this.getPanel().add(this.getImageLabel());
>>>>>>> origin/master
    }
    
    public abstract boolean canBeStomped();
    public abstract boolean isIndestructible();
    public abstract Image setImage()throws MalformedURLException;
    public abstract void setLabel();
<<<<<<< HEAD
    public abstract void die();
=======
>>>>>>> origin/master
    
}
