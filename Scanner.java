//Created by Devansh Amin
import java.io.*;

public class Scanner{
  private char currentChar;
  private byte currentKind;
  private StringBuffer currentSpelling;
  private BufferedReader inFile;
  private static int line = 1;
  private static byte finalkind;      //Created this variable to test scanner.java

  public Scanner(BufferedReader inFile){
    this.inFile = inFile;
    try{
      int i = this.inFile.read();
      if(i == -1) //end of file
        currentChar = '\u0000';
      else
        currentChar = (char)i;
    }
    catch(IOException e){
        System.out.println(e);
    }
  }

  private void takeIt(){
    currentSpelling.append(currentChar);
    try{
      int i = inFile.read();
      if(i == -1) //end of file
        currentChar = '\u0000';
      else
        currentChar = (char)i;
    }
    catch(IOException e){
        System.out.println(e);
    }
  }

  private void discard(){
    try{
      int i = inFile.read();
      if(i == -1) //end of file
        currentChar = '\u0000';
      else
        currentChar = (char)i;
    }
    catch(IOException e){
        System.out.println(e);
    }
  }
  
  private byte scanToken(){
	byte result = 0;  
	
    switch(currentChar){
    	case '(': result = Token.LPAREN;  takeIt(); break;	
    	case ')': result = Token.RPAREN;  takeIt(); break;
    	case '\u0000': result = Token.EOT; break;
    	default: 
    		
    		if(isLetter(currentChar)) {
    			while(isLetter(currentChar)) {  
    				takeIt();
    				result = Token.IDENTIFIER;
    				}
    		break;
    		}
    		else if(isDigit(currentChar)) {
    			while(isDigit(currentChar)) {
    				takeIt();	
    				result = Token.LITERAL;
    				}
    		break;
    		}
    		else if(isGraphic(currentChar)) { 
    			while(isGraphic(currentChar)) {
    				takeIt();
    				result = operator(currentSpelling);  //This method returns NOTHING if there is a unknown operator
    				if(isLetter(currentChar) || isDigit(currentChar))
    					break;
    			}
    			break;
    		}
    }
    return result;                 
  }

  private void scanSeparator(){
    switch(currentChar){
      case ' ': case '\n': case '\r': case '\t':
        if(currentChar == '\n')
          line++;
        discard();
    }
  }

  public Token scan(){
    currentSpelling = new StringBuffer("");
    while(currentChar == ' ' || currentChar == '\n' || currentChar == '\r')
      scanSeparator();
    currentKind = scanToken();
    finalkind = currentKind;
    return new Token(currentKind, currentSpelling.toString(), line);
  }
  
  private byte operator(StringBuffer s) {                  
	  byte r=0;
	  String ss = s.toString();
	  boolean flag=false;
	  String[] op = {"+" ,"-" , "*" , "/" , "<" , "<=" , ">", ">=", "=", "!=" };
	  for(int i=0; i<op.length;i++) {
		  if(ss.equals(op[i])) {
			  r = Token.OPERATOR;
			  flag = true;
			  break;
		  }
	  }
	  if(flag == false) {
		  r = Token.NOTHING;
	  }
	  return r;
  }
  
  
  private boolean isGraphic(char c){
    return c == '\t' ||(' ' < c && c <= '~');       // ' ' <= c changed to ' ' < c         
  }

  private boolean isDigit(char c){
    return '0' <= c && c <= '9';
  }

  private boolean isLetter(char c){
    return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
  }
  
  //Before running this file go to Token.java and in constructor Token comment print()
  public static void main(String[] args) throws IOException {  
	  SourceFile sf = new SourceFile();
	  BufferedReader br = sf.openFile();
	  Scanner sc = new Scanner(br);
	  Token a1;
	 
	  while(finalkind != 13) {              
	  a1 = sc.scan();						
	  a1.print();
	  }
	  
  }
  
  
}