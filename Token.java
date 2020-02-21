//Created by Devansh Amin
public class Token {
	public byte kind;
	public String spelling;
	public int line;
	
	private final static String[] spellings = {
			"<identifier>", "<literal>", "assign", "conditional", "loop", "block", "skip", "and", "or"
	};
	
	public final static byte
    IDENTIFIER =  0,
    LITERAL    =  1,
    ASSIGN     =  2,
    CONDITIONAL=  3,
    LOOP       =  4,
    BLOCK      =  5,
    SKIP       =  6,
    AND        =  7,
    OR         =  8,
    LPAREN     =  9,
    RPAREN     = 10,
    OPERATOR   = 11,
    NOTHING    = 12,       //Never happen but we need to return some thing in
                           //the switch in class Scanner when there is an error
    EOT        = 13; 
	
	public Token(byte kind, String spelling, int line) {
		this.kind = kind;
		this.spelling = spelling;
		this.line = line;
		if(kind == IDENTIFIER) {
			for(int k = ASSIGN; k <= OR; k++) {
		        if(spelling.equals(spellings[k])){
		          this.kind = (byte)k;
		          break;
		        }
			}   
		}
		print();       // If you want to test scanner.java comment this line and then run it.
	}
	
	public void print() {
		if(kind == 12)
			System.out.print("Line: "+line+" Wrong token "+spelling+"\n");
		else if(kind == 13)
			System.out.print("End"+"\n");
		else
			System.out.print("Line: "+line+", "+"Spelling: "+spelling+", "+"Kind: "+kind+"\n");			
	}
}
