#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>



int main(int argc, char* argv[]){

	pid_t pid;
	int status;

	if((pid=fork())==0){
	execlp("ls","ls","-l",NULL);

	_exit(0);
	}
	else{
	wait(&status);	
	sleep(3);
	printf("pai recebeu o filho\n");
	}
	

return 0;

}
