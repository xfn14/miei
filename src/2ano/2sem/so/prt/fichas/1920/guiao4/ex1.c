#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>


int fd1,fd2,fd3;

int main(){
 
        fd1 = open("/etc/passwd", O_TRUNC | O_RDWR ,0600); //sdin

        dup2(fd1,0);	
	
	close(fd1);


	fd2 = open("saida.txt", O_TRUNC | O_CREAT | O_RDWR , 0600); //stdout

	dup2(fd2,1);

	close(fd2);
	

	fd3 = open ("erros.txt", O_TRUNC | O_CREAT | O_RDWR , 0600); //erros

        dup2(fd3,2);

	close(fd3);


size_t n;
char buffer[100];

	   while((n=read(0,buffer,100))>0){
	
	         write(1,buffer,n);
	         write(2,buffer,n);
	   }

return 0;
}
