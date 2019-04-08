import java.util.Random;
import javax.swing.JOptionPane;

public class DriverMemoryGame
{
   public static void main (String[] args)
   {
      Random r = new Random();
      String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Black", "White", "Magenta", "Brown", "Pink"};
      String[] colorSeq = new String[5];
      
      for (int i = 0; i < colorSeq.length; i++)
      {
         colorSeq[i] = colors[r.nextInt(10)];
      }
      
   
      JOptionPane.showMessageDialog(null, "How good is your memory?\nTry to memorize this color sequence: \n\n"  + colorSeq[0]+ " " + colorSeq[1]
          +" "+ colorSeq[2] +" " + colorSeq[3] + " " + colorSeq[4]);
      MemoryGame m = new MemoryGame(colorSeq);
     
     
   }