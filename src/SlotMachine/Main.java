/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author THUSHAN
 */
public class Main {

    static int credits = 10;
    static int betCredits = 0;

    public static void main(String[] args) throws IOException {
        //create JFrame in the main window
        SlotMachineGui obj = new SlotMachineGui();
        obj.setTitle("SLOT GAME");
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setSize(700, 550);
        obj.getContentPane().setBackground(new Color(170, 170, 85));
        obj.setLocationRelativeTo(null);
        //obj.pack();
        obj.setVisible(true);

    }
}
