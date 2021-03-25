#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

char buffer[10];

int main (int argc, char* argv[]){
	int a;
	scanf("%d",&a);
	
	if (a==1){
	
	char linha [] = "linha";

	int status,bytes;
	int p[2];

	if(pipe(p)==-1){

	perror("pipe\n");
	return -1;
	}

	// p[0] descritor associado ao extremo de leitura do pipe
	// p[1] descritor associado ao extremo de escrita do pipek
	


	switch(fork()){

	case -1:
		perror("fork\n");
		return -1;
	case 0: 
		close(p[1]);
	bytes = read(p[0],buffer,sizeof(buffer));
	printf("Filho: %s, bytes%d", buffer,bytes);

	default:
		
                 close(p[0]);
	//	 sleep(5);
		 write(p[1],linha,sizeof(linha));
		 wait(&status);

		}
	}

	if (a==2){

	char linha[] = "linha2\n";

	int status, bytes;
	int p[2];

	if(pipe(p)==-1) return -1;

	
	switch(fork()){

	case -1:
		return -1;
	
	case 0:
		close(p[0]);
		write(p[1],linha,sizeof(linha));
		close(p[1]);
		_exit(0);
	
	
	default:
		close(p[1]);

		bytes = read (p[0],buffer,sizeof(buffer));
		close(p[0]);
		printf("pai:%s, bytes:%d\n",buffer,bytes);
		wait(&status);
	}	
	
	




	}

return 0;
}
