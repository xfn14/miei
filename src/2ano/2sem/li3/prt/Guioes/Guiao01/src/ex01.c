#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void readCSV(char *file_name, char** buffer);

int main(int argc, char const *argv[]){
    char** buffer = malloc(sizeof(char**));
    readCSV("users.csv", buffer);
}

void readCSV(char *file_name, char** buffer){
    FILE *in;
    in = fopen(file_name, "rb");

    if(in == NULL){
        printf("Can't find file.");
        return;
    }

    char* crt_line;
    int i = 0;
    while(!feof(in)){
        fgets(crt_line, sizeof(crt_line), in);
        strcpy(buffer[i], crt_line);
        // buffer[i] = crt_line;
        i++;
    }

    for(int j = 0; j < i; j++){
        printf(buffer[j]);
    }
}