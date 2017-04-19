/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author THUSHAN
 */
public class SlotMachineGui extends JFrame {
    //create objects
    Main main = new Main();
    event event = new event();
    event2 event2 = new event2();
    event3 event3 = new event3();
    event4 event4 = new event4();
    event5 event5 = new event5();
    event6 event6 = new event6();

    Reel reel1 = new Reel();
    Reel reel2 = new Reel();
    Reel reel3 = new Reel();
    Symbol symbol = new Symbol();

    ImageIcon image1, image2, image3;
    private int value1, value2, value3;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private JLabel slotImg1, slotImg2, slotImg3, txtLbl1, txtLbl2;
    private JLabel winLbl, lossesLbl, avgCreditsLbl;
    private JLabel txtLbl3, txtLbl4, txtLbl5;
    private JLabel txtLbl6, txtLbl7, txtLbl8;
    private static boolean mouse;
    Container contentPane;

    static int noOfWins = 0;
    static int noOfLose = 0;
    static int noOfSpin = 0;
    static int noOfFreeSpins = 0;

    public ArrayList<Symbol> spinValue;

    SlotMachineGui() {

        contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new FlowLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 5, 5, 5);

        addSlotImages();
        addButton();
        event();
        event2();
        event3();
        event4();
        event5();
        event6();

    }
    //button functionalities
    public void addButton() {
        Border border = BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(229, 229, 204));

        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 5, 5, 5);

        btn1 = new JButton("SPIN");
        btn2 = new JButton("Bet One");
        btn3 = new JButton("Bet Max");
        btn4 = new JButton("Reset");
        btn5 = new JButton("Add Coin");
        btn6 = new JButton("Statistics");

        btn1.setForeground(new Color(116, 37, 37));
        btn2.setForeground(new Color(116, 37, 37));
        btn3.setForeground(new Color(116, 37, 37));
        btn4.setForeground(new Color(116, 37, 37));
        btn5.setForeground(new Color(116, 37, 37));
        btn6.setForeground(new Color(116, 37, 37));

        btn1.setBackground(new Color(230, 230, 255));
        btn1.setSize(500, 500);
        //create JLabel to display credits...
        txtLbl1 = new JLabel("      $ " + Integer.toString(main.credits));
        txtLbl1.setBorder(BorderFactory.createTitledBorder(border, "CREDIT AREA"));
        //create JLabel to display bet credits
        txtLbl2 = new JLabel("      $ " + Integer.toString(main.betCredits));
        txtLbl2.setBorder(BorderFactory.createTitledBorder(border, "BET AREA"));
        //create three JLabels to display current status of the slot game 
        txtLbl6 = new JLabel("                      STATUS  >>>");
        txtLbl7 = new JLabel();
        txtLbl8 = new JLabel();
        //set font color of this JLabels
        txtLbl7.setForeground(new Color(255, 26, 26));
        txtLbl8.setForeground(new Color(255, 26, 26));

        //set location for buttons in grid layout
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPane.add(btn1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPane.add(btn2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        contentPane.add(btn3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        contentPane.add(btn4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        contentPane.add(btn5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        contentPane.add(btn6, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        contentPane.add(txtLbl1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 10;
        contentPane.add(txtLbl2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        contentPane.add(txtLbl6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        contentPane.add(txtLbl7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 14;
        contentPane.add(txtLbl8, gbc);
    }

    public void addSlotImages() {
        Border border = BorderFactory.createLineBorder(new Color(229, 229, 204), 5);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.ipadx = 2;
        gbc.ipady = 2;

        image1 = new ImageIcon(reel1.symbol.get(0).getImage());
        //create new JLabel to store slot images
        slotImg1 = new JLabel(image1);
        //  slotImg1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        slotImg1.setBorder(BorderFactory.createTitledBorder(border, "REEL01"));

        image2 = new ImageIcon(reel2.symbol.get(1).getImage());
        //create new JLabel to store slot images
        slotImg2 = new JLabel(image2);
        // slotImg2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        slotImg2.setBorder(BorderFactory.createTitledBorder(border, "REEL02"));

        image3 = new ImageIcon(reel3.symbol.get(2).getImage());
        //create new JLabel to store slot images
        slotImg3 = new JLabel(image3);
        // slotImg3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        slotImg3.setBorder(BorderFactory.createTitledBorder(border, "REEL03"));

        //set location for image labels in grid layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(slotImg1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        contentPane.add(slotImg2, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        contentPane.add(slotImg3, gbc);

    }

    //eventHandling for AddCoin button
    public void event() {
        btn5.addActionListener((ActionListener) event);

    }

    //eventHandling for BetOne button
    public void event2() {
        btn2.addActionListener((ActionListener) event2);

    }

    //eventHandling for BetMax button
    public void event3() {
        btn3.addActionListener((ActionListener) event3);

    }

    //eventHandling for Reset button
    public void event4() {
        btn4.addActionListener((ActionListener) event4);

    }

    //eventHandling for Statistics button
    public void event5() {
        btn6.addActionListener((ActionListener) event5);

    }

    //eventHandling for SPIN button
    public void event6() {
        btn1.addActionListener((ActionListener) event6);

    }

//create class in SlotMachineGui class for implements ActionListener for AddCoin button
    public class event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (main.credits == 0) {
                txtLbl7.setText("You can't add more credits");
                txtLbl8.setText("");
            } else {
                main.credits++;
                txtLbl1.setText("      $ " + Integer.toString(main.credits));
            }
        }

    }

    //create class in SlotMachineGui class for implements ActionListener for BetOne button
    public class event2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event2) {
            if (main.betCredits < 3) {
                if (main.credits > 0) {
                    main.betCredits++;
                    main.credits--;
                    txtLbl1.setText("      $ " + Integer.toString(main.credits));
                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
                } else {
                    txtLbl7.setText("You have not enough credits to play");
                    txtLbl8.setText("");
                }
            } else {
                txtLbl7.setText("You can't bet that amount!");
                txtLbl8.setText("");
            }
        }
    }

    //create class in SlotMachineGui class for implements ActionListener for BetMax button
    public class event3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event3) {
            if (main.betCredits < 3) {
                if (main.credits >= 3) {
                    main.betCredits += 3;
                    main.credits -= 3;
                    txtLbl1.setText("      $ " + Integer.toString(main.credits));
                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
                } else {
                    txtLbl7.setText("You can't bet that amount!");
                    txtLbl8.setText("");
                }

            } else {
                txtLbl7.setText("You can't bet that amount!");
                txtLbl8.setText("");
            }
        }
    }

    //create class in SlotMachineGui class for implements ActionListener for Reset button
    public class event4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event4) {
            main.credits = main.credits + main.betCredits;
            main.betCredits = 0;
            txtLbl1.setText("      $ " + Integer.toString(main.credits));
            txtLbl2.setText("      $ " + Integer.toString(main.betCredits));

        }
    }

    //create class in SlotMachineGui class for implements ActionListener for Statistics button
    public class event5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event5) {
            //create new JFrame for Statistics window 
            StackWindow stackWindow = new StackWindow(noOfWins, noOfLose, noOfSpin);
            stackWindow.setTitle("SLOT GAME/STATISTICS");
            stackWindow.setSize(600, 500);
            stackWindow.getContentPane().setBackground(new Color(178, 178, 102));
            stackWindow.setLocationRelativeTo(null);
            //  stackWindow.pack();
            stackWindow.setVisible(true);

//            JFrame stacWindow = new JFrame("SLOT GAME/STATISTICS");
//            stacWindow.setSize(500, 400);
//            stacWindow.getContentPane().setBackground(new Color(170, 170, 85));
//            stacWindow.setLocationRelativeTo(null);
//            stacWindow.setVisible(true);
//
//            JPanel panel = new JPanel();
//             contentPane2 = getContentPane();
//            contentPane2.setLayout(new GridBagLayout());
//            contentPane2.setLayout(new FlowLayout());
//           
//            panel.setBackground(new Color(170, 170, 85));
//            setLayout(new GridLayout(4, 2));
//            winLbl = new JLabel("Wins >>>");
//            panel.add(winLbl);
//            txtLbl3 = new JLabel();
//            panel.add(txtLbl3);
//            lossesLbl = new JLabel("Losses  >>>");
//            panel.add(lossesLbl);
//            txtLbl4 = new JLabel();
//            panel.add(txtLbl4);
//            avgCreditsLbl = new JLabel("Average Credits >>>");
//            panel.add(avgCreditsLbl);
//            txtLbl5 = new JLabel();
//            panel.add(txtLbl5);
//
//            btn7 = new JButton("Save Statistics");
//            GridBagConstraints gbc2 = new GridBagConstraints();
//            gbc2.fill = GridBagConstraints.HORIZONTAL;
//            gbc2.insets = new Insets(8, 5, 5, 5);
//
//            winLbl = new JLabel("Wins >>>");
//            txtLbl3 = new JLabel();
//            lossesLbl = new JLabel("Losses  >>>");
//            txtLbl4 = new JLabel();
//            avgCreditsLbl = new JLabel("Average Credits >>>");
//            txtLbl5 = new JLabel();
//            btn7 = new JButton("Save Statistics");
//
//            gbc2.gridx = 0;
//            gbc2.gridy = 0;
//            contentPane2.add(winLbl, gbc2);
//
//            gbc2.gridx = 0;
//            gbc2.gridy = 1;
//            contentPane2.add(lossesLbl, gbc2);
//
//            gbc2.gridx = 0;
//            gbc2.gridy = 2;
//            contentPane2.add(avgCreditsLbl, gbc2);
//
//             stacWindow.add(panel);
//             panel.add(contentPane2);
        }

    }

    //create class in SlotMachineGui class for implements ActionListener for SPIN button
    public class event6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event6) {
            if (main.betCredits > 0) {
                if (main.betCredits <= 3) {
                    spinValue = new ArrayList<Symbol>();
                    noOfSpin++;
                    reel1.Spin(reel1.symbol);
                    reel2.Spin(reel2.symbol);
                    reel3.Spin(reel3.symbol);

                    start(reel1, 10, image1, slotImg1);
                    start(reel2, 20, image2, slotImg2);
                    start(reel3, 30, image3, slotImg3);

                } else {
                    txtLbl7.setText("Your BetCredit is High!");
                    txtLbl8.setText("");
                }
            } else {
                txtLbl7.setText("Sorry!! Your BetCredit is $0");
                txtLbl8.setText("");
            }

        }

        //get values of symbols
        public void setReelValue(Symbol s1, Symbol s2, Symbol s3) {
//            value1 = (reel1.symbol.get(0).getValue());
//            value2 = (reel2.symbol.get(0).getValue());
//            value3 = (reel3.symbol.get(0).getValue());

            value1 = (s1.getValue());
            value2 = (s2.getValue());
            value3 = (s3.getValue());

//            System.out.println(value1);
//            System.out.println(value2);
//            System.out.println(value3);
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//        public void checkThreeSymbols() {
//            if (main.betCredits > 0) {
//                if (slotReel1 == slotReel2 && slotReel2 == slotReel3) {
//                    txtLbl7.setText("Congratulations!!YOU WON");
//                    int wonCredits = main.betCredits * value1;
//                    txtLbl8.setText("You Won $ " + wonCredits + " Credits");
//                    main.credits = main.credits + wonCredits;
//                    main.betCredits = 0;
//                    txtLbl1.setText("      $ " + Integer.toString(main.credits));
//                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
//
//                } else if (slotReel1 == slotReel2) {
//                    txtLbl7.setText("       YOU HAVE FREE SPIN");
//                    txtLbl8.setText("");
//                    // main.betCredits = 0;
//                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
//
//                } else if (slotReel1 == slotReel3) {
//                    txtLbl7.setText("       YOU HAVE FREE SPIN");
//                    txtLbl8.setText("");
//                    // main.betCredits = 0;
//                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
//
//                } else if (slotReel2 == slotReel3) {
//                    txtLbl7.setText("       YOU HAVE FREE SPIN");
//                    txtLbl8.setText("");
//                    // main.betCredits = 0;
//                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
//
//                } else {
//                    txtLbl7.setText("       Sorry!!  YOU LOSE");
//                    txtLbl8.setText("");
//                    main.betCredits = 0;
//                    txtLbl2.setText("      $ " + Integer.toString(main.betCredits));
//                }
//            } else {
//                txtLbl7.setText("Sorry!! Your BetCredit is $0");
//                txtLbl8.setText("");
//            }
//        }
        public void checkThreeSymbols(Symbol s1, Symbol s2, Symbol s3) {
            //  System.out.println(symbol.matchSymbols);
            if (symbol.checkThreeSymbols(s1, s2, s3) == 3) {
                noOfWins++;
                txtLbl7.setText("Congratulations!!YOU WON");
                int wonCredits = main.betCredits * value1;
                txtLbl8.setText("You Won $ " + wonCredits + " Credits");
                main.credits = main.credits + wonCredits;
                main.betCredits = 0;
                txtLbl1.setText("      $ " + Integer.toString(main.credits));
                txtLbl2.setText("      $ " + Integer.toString(main.betCredits));

            } else if (symbol.checkThreeSymbols(s1, s2, s3) == 2) {
                noOfFreeSpins++;
                txtLbl7.setText("       YOU HAVE FREE SPIN");
                txtLbl8.setText("");
                // main.betCredits = 0;
                txtLbl2.setText("      $ " + Integer.toString(main.betCredits));

            } else if (symbol.checkThreeSymbols(s1, s2, s3) == 0) {
                noOfLose++;
                txtLbl7.setText("       Sorry!!  YOU LOSE");
                txtLbl8.setText("");
                main.betCredits = 0;
                txtLbl2.setText("      $ " + Integer.toString(main.betCredits));

            }

        }

        private void start(Reel reel, int sleepTime, ImageIcon icon, JLabel label) {
            SwingWorker<Boolean, Symbol> worker = new SwingWorker<Boolean, Symbol>() {
                @Override
                protected Boolean doInBackground() throws Exception {
                    // Simulate doing something useful.
                    int n = 0;
                    if (mouse == false) {
                        do {

                            // The type we pass to publish() is determined
                            // by the second template parameter.
                            Random Dice = new Random();
                            n = Dice.nextInt(5);

                            //publish(slot[n]);
                            publish(reel.symbol.get(n));
                            // setReelIcon();
                            try {
                                Thread.sleep(10);
                            } catch (Exception e) {
                                System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

                            }

                            events e = new events();
                            label.addMouseListener(e);

                        } while (mouse != true);
                        // }
                        //  }while(mouse = true);
                    }

                    if (mouse = true) {
                        //System.out.println("The value of the Symbol " + reel.symbol.get(n).getValue() + " - " + "The index of the Symbol " + n);
                        //System.out.println(reel.symbol.toString());
                        //assigning the symbols to an arraylist
                        spinValue.add(reel.symbol.get(n));
                        //setting the spinnned symbol values
                        setReelValue(spinValue.get(0), spinValue.get(1), spinValue.get(2));
                        //checking for any similarities
                        checkThreeSymbols(spinValue.get(0), spinValue.get(1), spinValue.get(2));
                        //  lblBetArea.setText(betString + Integer.toString(bet));
                    }
                    // Here we can return some object of whatever type
                    // we specified for the first template parameter.
                    // (in this case we're auto-boxing 'true').
                    return true;

                }
                // Can safely update the GUI from this method.

                protected void done() {
                    boolean status;
                    try {
                        // Retrieve the return value of doInBackground.
                        status = get();
                        mouse = false;
                        // statusLabel.setText("Completed with status: " + status);
                    } catch (InterruptedException e) {
                        // This is thrown if the thread's interrupted.
                    } catch (ExecutionException e) {
                        // This is thrown if we throw an exception
                        // from doInBackground.
                    }
                }

                @Override
                // Can safely update the GUI from this method.
                protected void process(java.util.List<Symbol> chunks) {
                    // Here we receive the values that we publish().
                    // They may come grouped in chunks.
                    Symbol mostRecentValue = chunks.get(chunks.size() - 1);
                    //countLabel1.setText(Integer.toString(mostRecentValue.getValue()));
                    //countLabel1.setText((mostRecentValue.getImage()));
                    try {
                        //icon = new ImageIcon(mostRecentValue.getImage());
                        label.setIcon(new ImageIcon(mostRecentValue.getImage()));
                    } catch (Exception e) {
                    }
                    //System.out.println();
                }
            };
            worker.execute();
        }

        public class events implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                mouse = true;
               //checkThreeSymbols(reel1.symbol.get(0), reel2.symbol.get(0), reel3.symbol.get(0));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouse = true;
            }

            public void mouseReleased(MouseEvent e) {
                //mouse = true;
            }

            public void mouseEntered(MouseEvent e) {
                ///mouse = true;
            }

            public void mouseExited(MouseEvent e) {
                //mouse = true;
            }
        }

    }
}
