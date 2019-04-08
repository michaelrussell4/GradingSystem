import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MemoryGame
{
   public JFrame screenPrompt;
   public JLabel labelInstructions;
   public JTextField textInput;
   public int n = 1;                                        //Used for counting the number of correct responses 
   public String[] colorS;                                  //String that is passed into MemoryGame
   
   
   
   //Constructor for the frame
   public MemoryGame(String[] a)
   {
      this.colorS = a;
      screenPrompt = new JFrame ();
      screenPrompt.setSize(400,200);
      screenPrompt.setTitle("Memory Game");
      screenPrompt.setDefaultCloseOperation(screenPrompt.EXIT_ON_CLOSE);
      screenPrompt.setLayout(new FlowLayout());
      createContents();
      screenPrompt.setVisible(true);
      
   }     
   //Create the contents of the frame
   public void createContents()
   { 
    labelInstructions = new JLabel();
    textInput = new JTextField(null, 20);
    labelInstructions.setText("Enter color number 1: ");
    screenPrompt.add(labelInstructions);
    screenPrompt.add(textInput);
    textInput.addActionListener( new MyTextListener());
   }
   //Creates the textfield listener
   private class MyTextListener implements ActionListener 
   {
      public void actionPerformed (ActionEvent e)
      {
         String usersColor ="";
         usersColor = textInput.getText();                     // Will get the users input
         
         if (colorS[n-1].equalsIgnoreCase(usersColor))         //This will check to see if the users input correct
         {
            n++;
            labelInstructions.setText("Enter color number " + n +":" );
            textInput.setText("");
         }
         else if (!colorS[n-1].equalsIgnoreCase(usersColor))    //This will check if users input is incorrect
         {
            labelInstructions.setText("Sorry-wrong color. Eat more antioxidants.");
            screenPrompt.remove(textInput);
            screenPrompt.repaint();
         }
         
         if(n == 6)                                               //If the users get all five colors correct it let the user know
         {
            labelInstructions.setText("Congratulations-your memory is perfect!");
            screenPrompt.remove(textInput);
            screenPrompt.repaint();
         }       
      }
   }
   
   
}