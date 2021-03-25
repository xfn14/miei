#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>



int main(){
int status;
pid_t pid;
	for(int i=0;i<10;i++){

		if((pid=fork())==0){
		int a=getpid();
		int b=getppid();
		printf("FILHO\nNr:%d)\n",i);
		printf("id deste processo %d\nid pai deste processo %d\n",a,b);
		_exit(i);
		}
		else{
		wait(&status);
		int a = pid;
		printf("PAI\n");
		printf("filho deste processo %d \n",a);
		printf("************************\n");
		
		}
	}




return 0;
}

