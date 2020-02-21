//Created by Devansh Amin
public class Parser {
	private Token currentToken;
	Scanner scanner;
	boolean f= true, f1 = true, p=true;
	int count=0;
	
	private void accept(byte expectedKind) {
		if(currentToken.kind == expectedKind)
			currentToken = scanner.scan();
		else
			new Error("Syntax error: " + currentToken.spelling + " is not expected.", currentToken.line);
	}
	
	private void acceptIt() {
	    currentToken = scanner.scan();
	  }
	private boolean ac(byte expectedKind) {
		return (currentToken.kind == expectedKind);
	}
	public void parse() {
	    SourceFile sourceFile = new SourceFile();
	    scanner = new Scanner(sourceFile.openFile());
	    currentToken = scanner.scan();
	    parseProgram();
	    if (currentToken.kind != Token.EOT)
	      new Error("Syntax error: Redundant characters at the end of program.",
	                currentToken.line);
	  }
	private void parseProgram() {
		System.out.println("Enter parseProgram");
		
		accept(Token.LPAREN);
		parseSequence();
		parseState();
		accept(Token.RPAREN);	
		
		System.out.println("Exit parseProgram");
			
	  }
	
	private void parseSequence(){
		System.out.println("Enter parseSequence");
		
		accept(Token.LPAREN);
		parseStatements();
		accept(Token.RPAREN);
		
		
		System.out.println("Exit parseSequence");
	  }
	  
	  private void parseStatements(){
		  System.out.println("Enter parseStatements");
		  while(f) {   //Statements --> Stmt* 
			  parseStmt();
		  }
		  System.out.println("Exit parseStatements");
	  }

	  private void parseStmt(){
		  System.out.println("Enter parseStmt");
		  boolean flag=true;
		  accept(Token.LPAREN);
		  while(flag) {
			  if (currentToken.kind == Token.SKIP) {
				  parseNullStatement();
			  } 
			  else if (currentToken.kind == Token.ASSIGN) {
				  parseAssignment();
			  }
			  else if (currentToken.kind == Token.CONDITIONAL) {
				  f1=false;
				  parseConditional();
				  f1=true;
			  }
			  else if (currentToken.kind == Token.LOOP) {
				  f1=false;
				  parseLoop();
				  f1=true;
			  }
			  else if (currentToken.kind == Token.BLOCK) {
				  parseBlock();
			  }
			  else 
				  flag= false;
		  }
		  accept(Token.RPAREN);
		  //if( ac(Token.LPAREN)) 
			//  parseStmt();
		  System.out.println("Exit parseStmt");
		  if(f1) {
			  if(ac(Token.RPAREN))
				  f=false;
		  }
		  
	  }

	  private void parseState(){
		    System.out.println("Enter parseState");
			
			accept(Token.LPAREN);
			parsePairs();
			accept(Token.RPAREN);
			
			System.out.println("Exit parseState");
	  }

	  private void parsePairs(){
		  System.out.println("Enter parsePairs");
		  while(p) {   //Pairs --> Pair*
			  parsePair();
		  }
		  System.out.println("Exit parsePairs");
	  }

	  private void parsePair(){
		  System.out.println("Enter parsePair");
		  
		  accept(Token.LPAREN);
		  accept(Token.IDENTIFIER);
		  accept(Token.LITERAL);
		  accept(Token.RPAREN);
		  
		  System.out.println("Exit parsePair");
		  if(ac(Token.RPAREN))
			  p=false;
	  }
	  
	  private void parseNullStatement(){
		  System.out.println("Enter parseNullStatement");
		  
		  accept(Token.SKIP);
		  
		  System.out.println("Exit parseNullStatement");
	  }

	  private void parseAssignment(){
		  System.out.println("Enter parseAssignment");
		  
		  accept(Token.ASSIGN);
		  accept(Token.IDENTIFIER);
		  parseExpression();
		  
		  System.out.println("Exit parseAssignment");
	  }
	  
	  private void parseConditional(){
		  System.out.println("Enter parseConditional");
		  
		  accept(Token.CONDITIONAL);
		  parseExpression();
		  parseStmt();
		  parseStmt();
		  
		  System.out.println("Exit parseConditional");
	  }

	  private void parseLoop(){
		  System.out.println("Enter parseLoop");
		  
		  accept(Token.LOOP);
		  parseExpression();
		  parseStmt();
		  
		  System.out.println("Exit parseLoop");
	  }
	  
	  private void parseBlock(){
		  System.out.println("Enter parseBlock");
		  
		  accept(Token.BLOCK);
		  parseStatements();
		  
		  System.out.println("Exit parseBlock");
	  }

	  private void parseExpression(){
		  System.out.println("Enter parseExpression");
		  
		  if(currentToken.kind == Token.IDENTIFIER || currentToken.kind == Token.LITERAL)
			  acceptIt();
		  else {
			  accept(Token.LPAREN);
			  parseOperation();
			  parseExpression();
			  parseExpression();
			  accept(Token.RPAREN);
		  }
		  
		  System.out.println("Exit parseExpression");
	  }

	  private void parseOperation(){
		  System.out.println("Enter parseOperation");
		  
		  accept(Token.OPERATOR);
		  
		  System.out.println("Exit parseOperation");
	  }

}
