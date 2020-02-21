# Recursive-Descent-Parser

Mini language

Token
   Program --> Sequence State.
   Sequence --> (Statements ).
   Statements --> Statements Stmt | Stmt
   Stmt --> NullStatement | Assignment | Conditional | Loop | Block.
   State -->  (Pairs).
   Pairs --> Pairs Pair | Pair.
   Pair --> (Identifier Literal).
   NullStatement --> (skip).
   Assignment --> (assign Identifier Expression).
   Conditional --> (conditional Expression Stmt Stmt).
   Loop --> (loop Expression Stmt).
   Block --> (block Statements).
   Expression --> Identifier | Literal | (Operation Expression Expression).
   Operation --> + | - | * | / | < | <= | > | >= | = | != | or | and.
 
Scanner
BNF grammar of Mini Language

   Program" --> "("Sequence State")".
   Sequence --> "("Statements")".
   Statements --> Statements  Stmt | e
   Stmt --> "(" {NullStatement | Assignment | Conditional | Loop | Block}")".
   State -->  "("Pairs")".
   Pairs -->  Pairs Pair | e.
   Pair --> "("Identifier Literal")".
   NullStatement --> "skip".
   Assignment --> "assign" Identifier Expression.
   Conditional --> "conditional" Expression Stmt Stmt.
   Loop --> "loop" Expression Stmt.
   Block --> "block" Statements.
   Expression --> Identifier | Literal | "("Operation Expression Expression")".
   Operation --> "+" |"-" | "*" | "/" | "<" | "<=" | ">" | ">=" | "=" | "!=" | "or" | "and".
 
Note: Symbol e means Symbol e means epsilon. Treat Identifier and Literal as terminal symbols. Every symbol inside " and " is a terminal symbol. The rest are non terminals.
 
Parser
EBNF of Mini Language
   Program" --> "("Sequence State")".
   Sequence --> "("Statements")".
   Statements --> Stmt*
   Stmt --> "(" {NullStatement | Assignment | Conditional | Loop | Block}")".
   State -->  "("Pairs")".
   Pairs -->  Pair*.
   Pair --> "("Identifier Literal")".
   NullStatement --> "skip".
   Assignment --> "assign" Identifier Expression.
   Conditional --> "conditional" Expression Stmt Stmt.
   Loop --> "loop" Expression Stmt.
   Block --> "block" Statements.
   Expression --> Identifier | Literal | "("Operation Expression Expression")".
   Operation --> "+" |"-" | "*" | "/" | "<" | "<=" | ">" | ">=" | "=" | "!=" | "or" | "and".

Note: Treat Identifier and Literal as terminal symbols. Every symbol inside " and " is a terminal symbol. The rest are non terminals.
