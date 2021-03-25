#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>

int main (int argc, char* argv[]){


	pid_t pid,filho;
	int status;

	if ((pid=fork()==0)){
	
	strcpy(argv[0],"kanye");	
	printf("%s",argv[0]);
	execvp("./ex3",argv);
	_exit(1);
	}
	else{

		filho=wait(&status);
		//desnecessario para o contexto do exercicio
		printf("PAI %d recebeu a call do filho %d, código:%d.\n", getpid(),filho, WIFEXITED(status));
	}

		return 0;
	}
