#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>


/* Upon successful completion, fork() returns a value of 0 to the child process and
 returns the process ID of the child process to the parent process.  Otherwise, a
 value of -1 is returned to the parent process, no child process is created, and
 the global variable errno is set to indicate the error.
*/



int main(){
system("clear");
pid_t pid;
int status;

	if((pid=fork())==0){
		printf("FILHO \n\n");
	int a=getpid();
	int b=getppid();
		printf("Proc atual %d \n processo pai %d \n\n",a,b);
	
	_exit(0);
	}	
	else{
	int x=pid;/*evitavel fazer isto; 
		  podia simplesmente invocar "pid_t umPid" e igualar ao wait(&status)*/		
	wait(&status);
	printf("PAI \n\n");

	
	int c=getpid();
	int d=getppid();
	printf("Processo atual %d \n Processo pai %d \n Processo filho %d \n\n", c,d,x);
		

	}


return 0;
}
