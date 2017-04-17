/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

/**
 *
 * @author THUSHAN
 */
public class Reel {
   // create an arraylist to assign images...
    public ArrayList<Symbol> symbol = new ArrayList<Symbol>();

    public Reel() {

        Symbol bell = new Symbol();
        bell.setImage("images/bell.png");
        bell.setValue(6);

        Symbol cherry = new Symbol();
        cherry.setImage("images/cherry.png");
        cherry.setValue(2);

        Symbol lemon = new Symbol();
        lemon.setImage("images/lemon.png");
        lemon.setValue(3);

        Symbol plum = new Symbol();
        plum.setImage("images/plum.png");
        plum.setValue(4);

        Symbol redseven = new Symbol();
        redseven.setImage("images/redseven.png");
        redseven.setValue(7);

        Symbol watermelon = new Symbol();
        watermelon.setImage("images/watermelon.png");
        watermelon.setValue(5);

        symbol.add(bell);
        symbol.add(cherry);
        symbol.add(lemon);
        symbol.add(plum);
        symbol.add(redseven);
        symbol.add(watermelon);

    }
    //shuffle the images in the arraylist
    public ArrayList Spin(ArrayList images) {
        Collections.shuffle(images);
        return images;
    }

}
