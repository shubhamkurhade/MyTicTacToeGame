package org.TicTacToe.com.myGame;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
1. ActionListener -> It is std library which helps to notify when we click on certain button or access any menu
*/
public class myGame implements ActionListener {
    // GUI + will be created here

    Random random = new Random(); // random class instance to start the game with first chance of either X or O randomly

    JFrame frame = new JFrame();  // the frame of the UI
    JPanel titlePanel = new JPanel(); // to hold the titles
    JPanel buttonPanel = new JPanel(); // Button Panel
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9]; // for 3X3 matrix we need 9 buttons
    boolean player1Turn; // to check the turns

    // constructor for the myGame class
    public myGame(){
        System.out.println("Creating instance of the game");
        frame.setTitle("My Tic Tac Toe Game");
        ImageIcon icon = new ImageIcon("566294.png");
        frame.setIconImage(icon.getImage());
        // Defining the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Defining the textfields
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe Game");
        textField.setOpaque(true);

        // Defining the title panel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        // Defining the button panel
        buttonPanel.setLayout(new GridLayout(3,3)); // 3 X 3 layout
        buttonPanel.setBackground(new Color(155,150,150));

        // Deifning the buttons
        for(int i=0; i<9; i++)
        {
            buttons[i]=new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // implementing the textfield, titlePanel and buttons with our frame
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);


        firstTurn(); // calling the player turns

    }

    // implementation of the ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(player1Turn) // if its player 1s turn
                {
                    if(buttons[i].getText()=="") // if the block is empty
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X"); // player 1 will enter hsi X mark
                        player1Turn=false;
                        textField.setText("O Turn");
                        check();
                    }
                }else { // else it will be player 2s turn
                    buttons[i].setForeground(new Color(0,0,255));
                    buttons[i].setText("O"); // player 2 will enter his O mark
                    player1Turn=true;
                    textField.setText("X Turn");
                    check();
                }
            }
        }
    }
    // to choose whose turn it is X or O
    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(random.nextInt(2)==0) // we will assign the random numbers - 0 and 1
        {
            // if the random number is 0 then it wil be player 1's turn
            player1Turn=true;
            textField.setText("X Turn");
        }else {
            // else it will be player 2's turn
            player1Turn=false;
            textField.setText("O Turn");
        }
    }

    // to check the wining actions
    public void check()
    {
        // check for the X win condition
        if(
                (buttons[0].getText()=="X")  &&
                (buttons[1].getText()=="X")  &&
                (buttons[2].getText()=="X")
        ) {
            XWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X")  &&
                        (buttons[4].getText()=="X")  &&
                        (buttons[5].getText()=="X")
        ) {
            XWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X")  &&
                        (buttons[7].getText()=="X")  &&
                        (buttons[8].getText()=="X")
        ) {
            XWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X")  &&
                        (buttons[3].getText()=="X")  &&
                        (buttons[6].getText()=="X")
        ) {
            XWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X")  &&
                        (buttons[4].getText()=="X")  &&
                        (buttons[7].getText()=="X")
        ) {
            XWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X")  &&
                        (buttons[5].getText()=="X")  &&
                        (buttons[8].getText()=="X")
        ) {
            XWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X")  &&
                        (buttons[4].getText()=="X")  &&
                        (buttons[8].getText()=="X")
        ) {
            XWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X")  &&
                        (buttons[4].getText()=="X")  &&
                        (buttons[6].getText()=="X")
        ) {
            XWins(2,4,6);
        }


        // Check for the O win condition

        if(
                (buttons[0].getText()=="O")  &&
                        (buttons[1].getText()=="O")  &&
                        (buttons[2].getText()=="O")
        ) {
            OWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O")  &&
                        (buttons[4].getText()=="O")  &&
                        (buttons[5].getText()=="O")
        ) {
            OWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O")  &&
                        (buttons[7].getText()=="O")  &&
                        (buttons[8].getText()=="O")
        ) {
            OWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O")  &&
                        (buttons[3].getText()=="O")  &&
                        (buttons[6].getText()=="O")
        ) {
            OWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O")  &&
                        (buttons[4].getText()=="O")  &&
                        (buttons[7].getText()=="O")
        ) {
            OWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O")  &&
                        (buttons[5].getText()=="O")  &&
                        (buttons[8].getText()=="O")
        ) {
            OWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O")  &&
                        (buttons[4].getText()=="O")  &&
                        (buttons[8].getText()=="O")
        ) {
            OWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O")  &&
                        (buttons[4].getText()=="O")  &&
                        (buttons[6].getText()=="O")
        ) {
            OWins(2,4,6);
        }
    }

    // if X wins the game then this method is to be called
    public void XWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins the Game");
    }

    // if O wins the game tgen this method is to be called
    public void OWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0; i<9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins the Game");

    }
}
