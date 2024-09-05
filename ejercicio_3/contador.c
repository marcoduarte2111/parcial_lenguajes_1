
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFFER_SIZE 1000


int countOccurrences(FILE *fptr, const char *word);


int main(int argc, char *argv[])
{
    FILE *fptr;
    char *path;
    char *word;
    int wCount;


    if (argc != 3) {
        printf("Uso: %s <file_path> <word_to_search>\n", argv[0]);
        return 1;
    }

    path = argv[1]; 
    word = argv[2]; 


    fptr = fopen(path, "r");


    if (fptr == NULL)
    {
        printf("No se pudo abrir el archivo: %s\n", path);
        return 1;
    }



    wCount = countOccurrences(fptr, word);

    printf("'%s' se repite %d veces en el texto", word, wCount);

    fclose(fptr);

    return 0;
}


int countOccurrences(FILE *fptr, const char *word)
{
    char str[BUFFER_SIZE];
    char *pos;
    int index, count;

    count = 0;

   
    while ((fgets(str, BUFFER_SIZE, fptr)) != NULL)
    {
        index = 0;

       
        while ((pos = strstr(str + index, word)) != NULL)
        {
            
            
            
            index = (pos - str) + 1;
		
		count++;
	}
    }

    return count;
}
