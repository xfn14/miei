#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include <stdlib.h>

int fd1,fd2,fd3;



int main(int argc, char* argv[]){

fd1 = open("/etc/passwd", O_TRUNC | O_RDWR ,0600);
fd2 = open("saida.txt", O_CREAT | O_TRUNC | O_RDWR , 0600);
fd3 = open("erros.txt" , O_CREAT | O_TRUNC | O_RDWR , 0600);

printf("Houve a abertura dos ficheiros.\nAgora vai haver copia dos descritores de input output e erro\n");

dup2(fd1,0);
close(fd1);

dup2(fd2,1);
close(fd2);

dup2(fd3,2);
close(fd3);

pid_t pai, filho;
	int  n;
	char buffer [10];
        int status; 
	
	
	if(!fork()){
                

		n=read(0,buffer,10);
		
		write(1,buffer,n);
		write(2,buffer,n);
	
                printf("aaaa");
		execlp("cat",buffer,NULL);
		
		_exit(-1);
		
	
	}
	

	else{
	
	
	filho = wait(&status);
	pai = getpid();
	
	}

printf("descritores fechados\n");

return 0;
}
