/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author THUSHAN
 */
public interface ISymbol {
     //create all the public abstract methods
    public void setImage(String imgPath);

    public String getImage();

    public void setValue(int v);

    public int getValue();
}
