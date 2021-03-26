#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>



int main(){
pid_t pid;
int status;

system("clear");
		
for(int i=0;i<10;i++){
	pid=fork();
	if(pid==0){
	printf ("Filho nr%d\n",i);
	printf("Process id: %d ; Parent id : %d \n",getpid(),getppid());
	printf("................................\n");
	sleep(3);
	
	}	
 
	if(pid>0){
	wait(&status);
	printf("pai %d fez exit\n",getpid());
	_exit(0);
	
	}	
}		
//system("ps");
return 0;
}	



