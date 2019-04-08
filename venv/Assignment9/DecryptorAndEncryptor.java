import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;



public class DecryptorAndEncryptor 
{

  public static void main(String[] args)
  {

    Scanner in = new Scanner (System.in);
    File g;
    Scanner fileIn;
    String fileName = "";
    String doWhat;
    ArrayList<Character> eachLetter = new ArrayList<Character>();
    String sentence = " ";
    char characterAt = ' ';
    int count = 0;
    int countB = 0;
    PrintWriter fileOut;
    PrintWriter fileOutD;
    boolean foundError = true;                                                                        //Used to close do loop that if file name is not found

    do
    {
      try                                                                                            //Try catch will promote user to re renter a file if it cannot find a file.
      {
        System.out.print("Please enter the name of the file: ");
        fileName = in.nextLine();
        g = new File (fileName);                                                                    
        fileIn = new Scanner (g);                                                                    //Adding file user choose to import to Scanner 

        do                                                                                           //This loop will make sure the user enters either encrypt or decrypt
        {
          System.out.print("Would you like to encrypt or decrypt? ");
          doWhat = in.nextLine();
          
          if(!doWhat.equalsIgnoreCase("decrypt") && !doWhat.equalsIgnoreCase("encrypt"))
          {
            System.out.println("Not recongnized");
          }
        }while(!doWhat.equalsIgnoreCase("decrypt") && !doWhat.equalsIgnoreCase("encrypt"));
        
        if (doWhat.equalsIgnoreCase("encrypt"))                                                       //Loop used for encrypting a file
        {
          foundError =false;
          System.out.println("File has been encrypted to Encrypted.txt");                          
          fileOut = new PrintWriter(System.getProperty("user.dir") + "\\Encrypted.txt");                     //Where encrypted file will be saved to
          
          while (fileIn.hasNext()) 
          {
            sentence = fileIn.nextLine();                                                             
            count++;                                                                                  //count used to keep track of number of sentences
            
            for (int i = 0; i < sentence.length(); i++)                                               //This will loop will decrpyt the file  
            {
              countB++;                                                                               //countB used to keep track of number of characters in array
              characterAt = sentence.charAt(i);
              characterAt++;                                                                          //will increment each character in file
              eachLetter.add(characterAt);                                                            //Will add incremented character to array
            }

            if (count == 1)                                                                           //This loop will print first line to the outputfile
            {
              for (int j = 0; j < sentence.length(); j++)
              {
                fileOut.print(eachLetter.get(j));
              }
            }

            if (count > 1)                                                                             //This loop will execute if there is more then one line to be printed to outputfile
            {
              fileOut.print("\r\n");                                                                  //This will print to the next line                                                                                                                                    
              for (int j = (countB - sentence.length()) ; j <= countB - 1; j++) 
              {
                fileOut.print(eachLetter.get(j));
              }
            }
          }
          fileOut.close();                                                                            //close output file
        }
        if (doWhat.equalsIgnoreCase("decrypt"))                                                       //Loop used for decrypting a file.
        {
          foundError = false;
          System.out.print("File has been decrypted to Decrypted.txt");
          fileOutD = new PrintWriter(System.getProperty("user.dir") + "\\Decrypted.txt");                    //Where decrypted file will be saved to.
          while (fileIn.hasNext()) 
          {
            sentence = fileIn.nextLine();
            count++;                                                                                  //count used to keep track of number of sentences
            for (int i = 0; i < sentence.length(); i++)                                               //This will loop will decrpyt the file 
            {                                                                                         
              countB++;                                                                               //countB used to keep track of number of characters in array
              characterAt = sentence.charAt(i);                                                       
              --characterAt;                                                                          //Will decriment each character in file      
              eachLetter.add(characterAt);                                                            //Will add decrimented character to array
            }

            if (count == 1)                                                                           //This loop will print first line to the outputfile
            {
              for (int j = 0; j < sentence.length(); j++) 
              {
                fileOutD.print(eachLetter.get(j));
              }
            }

            if (count > 1)                                                                             //This loop will execute if there is more then one line to be printed to outputfile
            {
              fileOutD.print("\r\n");                                                                  //This will print to the next line

              for (int j = (countB - sentence.length()) ; j <= countB - 1; j++) 
              {
                fileOutD.print(eachLetter.get(j));
              }
            }
          }
          fileOutD.close();                                                                             //Close output file
        }
      }
      catch (FileNotFoundException e) 
      {
        System.out.println("File not Found");
      }
    }while(foundError);
  } //end main
} //end class DecryptorAndDecryptor