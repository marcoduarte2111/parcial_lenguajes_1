%{
#include <stdio.h>
int accepted = 0; // Flag to track if the current line is valid
%}

%%


^[a-zA-Z_][a-zA-Z0-9_]*[ \t]*=[ \t]*lambda[ \t]*[a-zA-Z_][a-zA-Z0-9_, \t]*[ \t]*:[ \t]*[a-zA-Z0-9_+\-*/%() \t]*$ {
    accepted = 1;  // Set accepted flag when the line matches the lambda pattern
    printf("ACEPTA\n");
}


^[^\n]*$ {
    if (!accepted) {
        printf("NO ACEPTA\n");
    }
    accepted = 0;  // Reset accepted flag after each line
}

\n {
    accepted = 0;  // Reset the accepted flag for each new line
}

. { /* Ignore any single character and reset accepted flag */
    accepted = 0;
}

%%

int yywrap() {
    return 1;  // To indicate end of input
}

int main(int argc, char **argv) {
    if (argc > 1) {
        yyin = fopen(argv[1], "r");  // Open input file
    }
    yylex();  // Begin processing input
    return 0;
}

