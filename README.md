# Recursive Descent Parser

Top down parser which checks if the input is part of the language or not. 

### Token
```
   Program --> Sequence State<br />
   Sequence --> (Statements )<br />
   Statements --> Statements Stmt | Stmt<br />
   Stmt --> NullStatement | Assignment | Conditional | Loop | Block<br />
   State -->  (Pairs)<br />
   Pairs --> Pairs Pair | Pair<br />
   Pair --> (Identifier Literal)<br />
   NullStatement --> (skip)<br />
   Assignment --> (assign Identifier Expression)<br />
   Conditional --> (conditional Expression Stmt Stmt)<br />
   Loop --> (loop Expression Stmt)<br />
   Block --> (block Statements)<br />
   Expression --> Identifier | Literal | (Operation Expression Expression)<br />
   Operation --> + | - | * | / | < | <= | > | >= | = | != | or | and<br />
``` 
### Scanner
BNF grammar of Mini Language
```
   Program" --> "("Sequence State")"<br />
   Sequence --> "("Statements")"<br />
   Statements --> Statements  Stmt | e<br />
   Stmt --> "(" {NullStatement | Assignment | Conditional | Loop | Block}")"<br />
   State -->  "("Pairs")"<br />
   Pairs -->  Pairs Pair | e<br />
   Pair --> "("Identifier Literal")"<br />
   NullStatement --> "skip"<br />
   Assignment --> "assign" Identifier Expression<br />
   Conditional --> "conditional" Expression Stmt Stmt<br />
   Loop --> "loop" Expression Stmt<br />
   Block --> "block" Statements<br />
   Expression --> Identifier | Literal | "("Operation Expression Expression")"<br />
   Operation --> "+" |"-" | "*" | "/" | "<" | "<=" | ">" | ">=" | "=" | "!=" | "or" | "and"<br />
``` 
Note: Symbol e means Symbol e means epsilon. Treat Identifier and Literal as terminal symbols.
Every symbol inside " and " is a terminal symbol. The rest are non terminals.

### Parser
EBNF of Mini Language
```
   Program" --> "("Sequence State")"<br />
   Sequence --> "("Statements")"<br />
   Statements --> Stmt*<br />
   Stmt --> "(" {NullStatement | Assignment | Conditional | Loop | Block}")"<br />
   State -->  "("Pairs")"<br />
   Pairs -->  Pair*<br />
   Pair --> "("Identifier Literal")"<br />
   NullStatement --> "skip"<br />
   Assignment --> "assign" Identifier Expression<br />
   Conditional --> "conditional" Expression Stmt Stmt<br />
   Loop --> "loop" Expression Stmt<br />
   Block --> "block" Statements<br />
   Expression --> Identifier | Literal | "("Operation Expression Expression")"<br />
   Operation --> "+" |"-" | "*" | "/" | "<" | "<=" | ">" | ">=" | "=" | "!=" | "or" | "and"<br />
```
Note: Treat Identifier and Literal as terminal symbols. Every symbol inside " and " is a terminal symbol. 
The rest are non terminals.

