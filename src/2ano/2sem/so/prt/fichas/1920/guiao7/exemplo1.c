#include <signal.h>
#include <sys/types.h>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

/*Usando SIGINT,SIGQUIT, eSIGALRM, escreva um programa que va contando o tempo em segundos desde que comec ̧ou e: se o utilizador carregar em Ctrl-C imprima o tempo passado; se carregar em Ctrl-\indique quantas vezes o utilizador carregou em Ctr-C e termine.*/

int controller;

void sig_handler(int signum){
printf("recebido %d signal\n",signum);
controller++;	
}

int main(int argc, char*argv[]){

signal(SIGQUIT,sig_handler);
perror("SIGQUIT");
signal(SIGINT,sig_handler);
perror("SIGINT");


signal(SIGKILL,sig_handler);
perror("SIGKILL");

while(controller<3){
	pause();

	printf("pausa terminada\n");
}

return 0;

}
