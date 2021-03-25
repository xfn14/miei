#include "ex3.h"




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



int main(int argc, char* argv[]){
int i=1;
ssize_t a;
char buffer[100];

	while((a=readln(0,buffer,100))>0){
	printf("\t%d\t",i);
	i++;
	printf("%s\n",buffer);
}
return 0;
}
  
