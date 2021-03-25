#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <stdlib.h>


typedef void(*sighandler_t) (int);


int segundos = 0;
int nctrlc = 0;


void sigalrm_handler(int signum){
	
	segundos ++;

}

void sigint_handler(int signum){
	nctrlc++;
	printf("passara %d segundos\n",segundos);
}

void sigquit_handler(int signum){
	printf("carregou %dx no ctrl-c\n", nctrlc);
	exit(0);
}


int main(int argc, char* argv[]){


	signal(SIGALRM, sigalrm_handler);
	signal(SIGINT, sigint_handler);
	signal(SIGQUIT,sigquit_handler);


	while(1){

		alarm(1);
		pause();
	}

return 0;

}
