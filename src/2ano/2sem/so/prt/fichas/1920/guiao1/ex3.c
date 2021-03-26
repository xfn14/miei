#include "ex3.h"

#define SIZE 1024*2

ssize_t readln ( int fd, char *line, size_t size){
char l;
ssize_t a;
int i=0;
	while((a=read(fd,&l,1))>0 && i<size  && (l!='\n')  ){
	line[i++] = l;	
	}
i++;
line[i] = '\n';


return i;
}


int main ( int argc, char* argv[]){

char buffer[SIZE];

if (argc<2){
	printf("Erro falta de argumentos\n");


	}
else{

       int fd = open(argv[1],O_RDONLY);
	
	int rd = readln(fd,buffer,SIZE);
	close(fd);	

	//faço este print para confirmar a leitura das linhas do ficheiro
	printf("numero bytes 1a linha do ficheiro %s: %d\n",argv[1],rd);

return rd;
}


return 0;
}
