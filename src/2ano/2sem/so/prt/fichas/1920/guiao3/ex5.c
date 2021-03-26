#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>



int main(int argc, char*argv[]){


int status;

	for(int i=1;i<argc;i++){

		if(!fork()){
	
		execlp(argv[i],argv[i],NULL);

		
		_exit(i);
	}
	
	}
	for(int i=1;i<argc;i++){

		wait(&status);
		printf("Pai aqui\n");


	}


return 0;
}
