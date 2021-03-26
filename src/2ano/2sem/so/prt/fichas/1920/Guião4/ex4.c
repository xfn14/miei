#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>


/*apercebi me de um erro de interpretação deste exercicio, mal possa retifique
 * a execucao do comando esta correta mas o redirecionamento de files está mal executado
 * esta versao obriga a que haja sempre uma abertura dos dois ficheiros
 */ 

int main ( int argc, char* argv[]){

	char *ficheiro1 = strtok(argv[2],"]");

	char *ficheiro2 = strtok(argv[4],"]");

	int fd1=open(ficheiro1,O_CREAT | O_RDWR, 0600);
	int fd2=open(ficheiro2,O_CREAT | O_RDWR, 0600);

	char *args[argc-5];
	int status,j=0;

		for(int i=5;i<argc;i++){
		
		args[j]=strdup(argv[i]);
			
	        j++;

		}
		args[j]=NULL;	
			


		if(!fork()){
			
		dup2(fd1,0);
		close(fd1);

		dup2(fd2,1);
		close(fd2);

/*		printf("nr tot args %d\n",argc);
		for(int i=0;i<j;i++){
		printf("args[%d]:%s\n",i,args[i]);
		}	
*/	
		execvp(argv[5],args);
		_exit(-1);

	}
	
	else{
		wait(&status);

	}

return 0;
	}
