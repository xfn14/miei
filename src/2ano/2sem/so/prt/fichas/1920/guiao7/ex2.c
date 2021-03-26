#include <signal.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
int time=0;

void sigtime (int signum){
	alarm(1);
	time++;
}


void siggrep (int signum){

	printf("encontrado fim\n");


}

void sigchild(int signum){

}



int main (int argc, char* argv[] ){
	
	if(argc<3) printf("Erro\n");

	else{
	char palavra[20];


	strcpy(palavra,argv[1]);
		
	int i=2;
	int pid[argc-2];
	int encontrado =0;
		for(i;i<argc;i++){

			if((pid[i]=fork())==0){
				
			

			execlp("grep","grep",palavra,argv[i],NULL);
					}
		
			}
	
		}

		for(i=2;i<argc;i++){
			wait(NULL);
			printf("pai recebeu filho\n");
		}


	}
	
return 0;
	
}
