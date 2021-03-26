#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <fcntl.h>



int main (int argc, char*argv[]){

int fd1 = open("etc/passwd", O_RDWR, 0600);
int fd2 = open("saida.txt", O_CREAT | O_RDWR, 0600);
int fd3 = open("erros.txt", O_CREAT | O_RDWR, 0600);


printf("Stdin está no etc/passwd\nStdout está na saida.txt\nStderror está no erros.txt\n");

dup2(fd1,0);
close(fd1);

dup2(fd2,1);
close(fd2);

dup2(fd3,2);
close(fd3);



int status;

if(!fork()){
	printf("wc vai ser executado\n");
	execlp("wc","wc",NULL);
	_exit(-1);
}
else{

	wait(&status);
	

}


return 0;
}
