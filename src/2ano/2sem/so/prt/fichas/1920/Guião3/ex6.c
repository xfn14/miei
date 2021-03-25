#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>


int sys(char*commando){
int status;
char* comandos[20];
char* individual;
individual = strtok(commando," ");

int i=0;

	while(individual!=NULL){

		comandos[i]=strdup(individual);
		
		//printf para efeitos de compreensão
		printf("argv[%d]=%s\n",i,comandos[i]);
		
		individual = strtok(NULL," ");
		i++;	

		}

		comandos[i]=NULL;

		if(!fork()){
	
			execvp(comandos[0],comandos);
			
			_exit(-1);
		}
		
		else{

		wait(&status);
		printf("Pai chegou\n");
		
		}



return 0;

}



int main(int argc, char*argv[]){
char* string= strdup(argv[1]);
sys(string);
return 0;


}
