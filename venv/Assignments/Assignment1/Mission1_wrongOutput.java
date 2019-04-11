import java.util.Scanner;
import java.math.BigInteger;
// one comment
public class Mission1_wrongOutput {
	public static void main(String[] args) {
      String text = "Ahhh my bits are showing";
      String binary = new BigInteger(text.getBytes()).toString(2);
      System.out.println(binary);
		System.out.print("My favorite movie is Alan Turing");
	}
}