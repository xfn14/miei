#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct pessoa *Pessoa;

struct pessoa {
int idade;
char nome[25];
};


Pessoa initPessoa(){
  Pessoa p=(Pessoa)malloc(sizeof(struct pessoa));
  p->idade=0;

  p->nome[0]='\0';

  return p;
}


Pessoa setPessoa(Pessoa p,int age, char *name){

p->idade=age;
strcpy(p->nome,name);
return p;

}


	


int main(int argc, char* argv[]){

int fd;



	if(argc!=5){
		printf("erro\n");
	       	return -1;
	}

	if (!strcmp(argv[2],"-i")){
	
		fd = open("pessoas.txt", O_CREAT | O_RDWR | O_APPEND, 0600);

		Pessoa p=initPessoa();
	
		p=setPessoa(p,atoi(argv[4]),argv[3]);

		printf("%s\n",p->nome);
		write(fd,p,sizeof(struct pessoa));
	
		close(fd);
	}
	else{
		perror("erro");
	}



return 0;
}
