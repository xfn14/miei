#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>


int main (){

pid_t pid;
int status;
	
	system("clear");

	if((pid=fork())==0){ //processo filho;
	int a=getpid();
	int b= getppid();
	printf("----------FILHO---------\n");
	printf("Valor deste processo %d\n",a);
	printf("Valor do pai deste processo: %d \n",b);
	
	}


	else { //processo pai
	wait(&status);
	int c= getpid();
	int d= getppid();
	printf("--------------PAI---------\n");
	printf ("Valor deste processo:%d \n\n",c);
	printf("Valor do pai deste processo: %d \n\n",d);
	

	
	}


	printf ("EXECUCAO COMANDO PS \n\n");
	system("ps");



return 0;
}
