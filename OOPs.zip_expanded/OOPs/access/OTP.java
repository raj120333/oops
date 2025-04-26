package OOPs.access;
import java.io.Console;
import java.util.Random;
public class OTP {
	int otp;
	Console con = System.console();
	OTP()
	{
		
		Random r = new Random();
		otp = r.nextInt(1000000);
		//send otp somehow to user
	}
	boolean verify(long phone, String email)
	{
		int i;
		while (true) {
			
			System.out.println("Enter OTP");
			String s = con.readLine();
		    s = con.readLine();
		    try {
		        i = Integer.parseInt(s);
		        break; // Exit the loop if parsing is successful
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid OTP entered.\nPlease enter a valid OTP.");
		    }
		}
		return i == otp;
	}
}
