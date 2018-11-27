/*
Name: Matthew Temple
Class: CSC-142
Date: 11/7/17
Description: System Log-in box
*/

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;

public class SystemLogIn extends JFrame
{
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JLabel username;
    private JLabel password;
    private JLabel invalid;
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JTextField invalidTF;
    private JPasswordField Jpassword;
    private JButton loginButton;
    private JButton exitButton;
    private JCheckBox caseSens;
    private JCheckBox showPass;
    
    final int WIN_WIDTH = 650;
    final int WIN_HEIGHT = 300;
    
    final String USERNAME = "Frank";
    final String PASSWORD = "password";
    
//-------------------CONSTRUCTOR----------------------
    public SystemLogIn()
    {
        setTitle ("System Log-in");
        setSize (WIN_WIDTH, WIN_HEIGHT);
        
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        setLayout (new BorderLayout());
        ConstructComponents();
        
        add (northPanel, BorderLayout.NORTH);
        add (southPanel, BorderLayout.SOUTH);
        add (eastPanel, BorderLayout.EAST);
        add (westPanel, BorderLayout.WEST);
        add (centerPanel, BorderLayout.CENTER);
        
        setVisible (true);
    }
    
//------------------CONSTRUCT COMPONENTS---------------
    private void ConstructComponents()
    {
        loginButton = new JButton ("Login");
        loginButton.addActionListener(new ButtonListener());
        exitButton = new JButton ("Exit");
        exitButton.addActionListener(new ButtonListener());
        invalid = new JLabel ("Max # of Invalid Attempts: ");
        invalidTF = new JTextField (2);
        invalidTF.setText("3");
        invalidTF.setEditable(false);
        caseSens = new JCheckBox ("Case Sensitive", false); //False leaves it unchecked when started
        caseSens.addItemListener(new CheckBoxListener());
        showPass = new JCheckBox ("Show password", false);
        showPass.setEnabled(true);
        showPass.addItemListener(new CheckBoxListener());
        username = new JLabel ("Username: ");
        usernameTF = new JTextField (10);
        password = new JLabel ("Password: ");
        Jpassword = new JPasswordField (10);
        Jpassword.setEchoChar('*');
        
       
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        centerPanel = new JPanel();

        
        southPanel.add(loginButton);
        southPanel.add(exitButton);
        centerPanel.add (invalid);
        centerPanel.add (invalidTF);
        centerPanel.add (caseSens);
        centerPanel.add (showPass);
        westPanel.add (username);
        westPanel.add (usernameTF);
        westPanel.add (password);
        westPanel.add (Jpassword);
        
        northPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        southPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        eastPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        westPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        centerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
//-------------------BUTTON LISTENER--------------------
    private class ButtonListener implements ActionListener
    {
        int count = 3;
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == loginButton)
            {
                if(usernameTF.getText().equals(USERNAME))
                {
                    if(Jpassword.getText().equals(PASSWORD))
                    {
                        JOptionPane.showMessageDialog(null, "Welcome to my system!");
                        System.exit(0);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect password");
                        count--;
                        JOptionPane.showMessageDialog(null, "Invalid login attempt, " + count + " attempts remaining");
                        
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect username");
                    count--;
                    JOptionPane.showMessageDialog(null, "Invalid login attempt, " + count + " attempts remaining");
                }
                if (count == 0)
                {
                    JOptionPane.showMessageDialog(null, "Max number of attempts tried, system closing");
                    usernameTF.setEditable(false);
                    Jpassword.setEditable(false);
                    usernameTF.setText("");
                    Jpassword.setText("");
                    System.exit(0);
                }
                
            }
            else if(e.getSource() == exitButton)
            {
                JOptionPane.showMessageDialog(null, "Goodbye");
                System.exit(0);
            }
        }
    }
    
//------------------ITEM LISTENER-----------------------
    private class CheckBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if(caseSens.isSelected())
            {
                
            }
            else
            {
                
            }
            
                
            if(showPass.isSelected())
            {
                Jpassword.setEchoChar((char)0);
            }
            else 
            {
                Jpassword.setEchoChar('*');
            }
            
        }
    }
    
//-------------------MAIN METHOD------------------------
    public static void main (String[] args)
    {
        new SystemLogIn();
        
        
    }
}
