/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objets;

/**
 *
 * @author Daniel-PC
 */
public class BarrierBlock extends Element{

    public BarrierBlock(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    @Override
    public void move(){
        
    }
    
    @Override
    public boolean itsPisable(){
        return false;
    }
    
    @Override
    public boolean itsIndestructible(){
        return true;
    }
}
