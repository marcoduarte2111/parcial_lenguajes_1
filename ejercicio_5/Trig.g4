grammar Trig;

expr: trig_func '(' NUMBER ')' EOF;  // Recognize function calls like Sin(90), Cos(0), Tan(45)

trig_func: 'Sin' | 'Cos' | 'Tan';   // Recognizes the trigonometric functions
NUMBER: [0-9]+ ('.' [0-9]+)?;       // Matches integer or decimal numbers

WS: [ \t\n\r]+ -> skip;             // Skips whitespace
