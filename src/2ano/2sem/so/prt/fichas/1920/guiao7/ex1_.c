#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int time=0;
int counter=0;


void sigtime(int signum){
	printf("passaram se %d segundos\n",time);
	counter++;
}


void sigdestroy(int signum){
	printf("dead\n, numeroctrl cs %d\n",counter);
	exit(0);
}

void sigtic(int signum){
time++;
alarm(1);
}


int main (int argc, char* argv[]){
signal(SIGINT,sigtime);
signal(SIGQUIT,sigdestroy);
signal(SIGALRM,sigtic);

alarm(1);
while(1){
pause();
}

}



