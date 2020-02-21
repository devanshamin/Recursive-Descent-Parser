//Created by Devansh Amin
public class Error {
	public Error(String message, int line) {
		System.out.println("Line "+line+": "+message);
		System.exit(0);
	}
	
}
