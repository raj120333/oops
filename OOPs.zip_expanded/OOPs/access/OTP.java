package OOPs.access;
import java.util.Random;
public class OTP {
	int otp;
	
	OTP()
	{
		Random r = new Random();
		otp = r.nextInt(1000000);
		//send otp somehow to user
	}
	boolean verify()
	{
		System.out.println("Enter OTP");
		int i = 0;
		//Accept input
		return i==otp;
	}
}
