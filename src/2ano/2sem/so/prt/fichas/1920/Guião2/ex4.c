#include <stdio.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <unistd.h>




int main(){
int status;
pid_t pid;
	system("clear");

	for(int i=0; i<10;i++){
	if ((pid=fork())==0){
	printf("Filho %d saiu, pid %d\n",i,getpid());
	sleep(3);
	_exit(i);
	
	}
	}
	
	for(int i=0 && pid>0;i<10;i++){
	pid_t child=wait(&status); //outra forma de apanhar o Process IDentifier filho que  para além disso invoca o wait 
	printf ("Pai do %do filho saiu (filho tem id==%d), pid deste processo:%d\n",i,child,getpid());
        printf ("STATUS %d\n",status);	
	
	}	

return 0;
}
