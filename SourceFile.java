//Created by Devansh Amin
import java.io.*;
public class SourceFile {
	public BufferedReader openFile() {
		String fileName="";
		BufferedReader inFile = null;
		/*InputStreamReader r = new InputStreamReader(System.in); //InputStreamReader Reads data from keyboard which is in form of bytes and converts it to character.
		//BufferedReader stdin = new BufferedReader (r); //BufferedReader class can be used to read data line by line by readLine() method.
		//System.out.print("Source File = ");
		System.out.flush();*/
		try {
			//fileName = stdin.readLine();
			//Change File location in FileReader when you run this parser on your system
			FileReader fr = new FileReader("C:\\Devansh\\Parser\\src\\test.txt");
			inFile = new BufferedReader (fr);
		}
		catch(FileNotFoundException e){
			System.out.println("The source file "+ fileName +" was not found");
		}
		return inFile;
	}
	
}
