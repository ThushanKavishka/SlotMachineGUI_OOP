/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import static SlotMachine.SlotMachineGui.noOfFreeSpins;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author THUSHAN
 */
public class StackWindow extends JFrame {

    private static int creditaverage;
    private double winAveragePerGame, equalAveragePerGame;
    private JProgressBar creditAverageBar;

    private JLabel winLbl, lossesLbl, avgCreditsLbl;
    private JLabel txtLbl3, txtLbl4, txtLbl5, txtLbl9, txtLbl10, txtLbl11;
    private JButton btn7;

    //create object of SlotMachineGui class
    SlotMachineGui gui2 = new SlotMachineGui();
    GridBagConstraints gbc = new GridBagConstraints();
    //create object of event7 class use in eventHandling
    event7 event7 = new event7();

    public StackWindow(int noOfWins, int noOfLose, int noOfSpin) {
        setLayout(new GridBagLayout());

        Border border = BorderFactory.createLineBorder(new Color(229, 229, 204), 3);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 2;
        gbc.ipady = 12;

        //create new Jlabel for set no of wins
        txtLbl3 = new JLabel();
        txtLbl3.setBorder(BorderFactory.createTitledBorder(border, "WINS"));
        //create new Jlabel for set no of losses
        txtLbl4 = new JLabel();
        txtLbl4.setBorder(BorderFactory.createTitledBorder(border, "LOSSES"));
        //create new Jlabel for set no of free spins
        txtLbl11 = new JLabel();
        txtLbl11.setBorder(BorderFactory.createTitledBorder(border, "FREE SPINS"));
        ////create new Jlabel for set no of spins
        txtLbl10 = new JLabel();
        txtLbl10.setBorder(BorderFactory.createTitledBorder(border, "SPINS"));
        //create new JButton for save data into a file
        btn7 = new JButton("Save Statistics");

        //create new Jlabel for set file saved status 
        txtLbl9 = new JLabel();
        txtLbl9.setForeground(new Color(255, 26, 26));
        //set location for all JLabels, JButtons and JProgressbar in gridLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(txtLbl3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(txtLbl4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(txtLbl10, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(txtLbl11, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(btn7, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        add(txtLbl9, gbc);
        //set all data
        txtLbl3.setText("           " + (Integer.toString(gui2.noOfWins)));
        txtLbl4.setText("           " + (Integer.toString(gui2.noOfLose)));
        txtLbl10.setText("           " + (Integer.toString(gui2.noOfSpin)));
        txtLbl11.setText("           " + (Integer.toString(gui2.noOfFreeSpins)));

        winAveragePerGame = (double) (gui2.noOfWins) / (double) (gui2.noOfLose);
        creditaverage = (int) (winAveragePerGame * 10);
        

        //create new JProgressBar for set credit average,  
        creditAverageBar = new JProgressBar(0, 100);
        creditAverageBar.setBackground(new Color(230, 243, 255));
        creditAverageBar.setStringPainted(true);
        //avgBar.setBounds(40,40,200,30);  
        creditAverageBar.setString("AVERAGE: " + winAveragePerGame + "%");

        creditAverageBar.setValue(creditaverage);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(creditAverageBar, gbc);

        event7();

    }

    //eventHandling for SaveStatistics button
    public void event7() {
        btn7.addActionListener((ActionListener) event7);

    }

    //create class in StcakWindow class for implements ActionListener for SaveStatistics button
    public class event7 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event7) {
                Date date = new Date();
     // create a file name using current date and time
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            try {
                int totWins = gui2.noOfWins;
                int totLose = gui2.noOfLose;
                int totSpin = gui2.noOfSpin;
                int totFreeSpins = gui2.noOfFreeSpins;
                int average = creditaverage;

                if (totWins == 0 && totLose == 0 && totSpin == 0 && totFreeSpins == 0) {
                    txtLbl9.setText("DATA IS ALREADY EMPTY");

                } else {
                   // String fileName = String.valueOf(totSpin);
                    //String fileName = String.valueOf(timeStamp.format(date) + ".txt");
                    //String fileName =dateFormat.format(date);
                    //File file = new File(timeSlot);
                     File file = new File(dateFormat.format(date)+".txt");

                    //Creates the text file if doesn't exist
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    //  bw.write("totWins-" + totWins + " totLose-" + totLose + " totFreeSpins-" + totFreeSpins + " totSpins-" + totSpin);
                    bw.write(totWins + "-" + totLose + "-" + totFreeSpins + "-" + totSpin + "-" + average);

                    bw.newLine();

                    bw.close();

                    txtLbl9.setText("       ALL DATA SAVED");
                    //System.out.println("");
                }
            } catch (IOException e) {
                System.out.println("Sorry! The Program Could Not Locate The Text File");
                System.out.println("");
            }
        }

    }
}
