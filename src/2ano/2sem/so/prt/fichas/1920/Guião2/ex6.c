#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>


#define C 100
#define L 100 
int existe=0;
int k=0;
int matriz [L][C];
int tot=0;


//preenche matriz
void geraMatriz()
{

	for(int i=0;i<L;i++){
		
		for(int j=0;j<C;j++){
			matriz[i][j]=(rand()%10);
	
		}	
	}
}

//imprime no ecrã matriz



void printMatriz(){
	
	for(int i=0;i<L;i++){
	printf("\n");
	

		for(int j=0;j<C;j++){
		printf (" %d ", matriz[ i ][ j ]);
		}

		printf("\n");

}
}


//verifica a existencia do numero nas colunas
int  auxMatriz(int x){
int exists=0;
	for(int i=0;i<C;i++){
	if((matriz[k][i])==x) exists=1;
	
	}
return exists;
}




//main
int main(int argc, char* argv []){
pid_t pid;
int status;


if (argc<2){
	printf("Tem que inserir um valor a ser procurado na matriz\n");
	return -1;
	}


int a = atoi(argv[1]);	
int b;

geraMatriz();
printMatriz();
for(k=0;k<L;k++){
	pid=fork();
	
	if(pid==0){
	
	b=auxMatriz(a);
	
	if (b==1) {
		printf("Existe na linha %d\n",k); 
		
	}
	else printf("Linha %d nao tem ocorrências\n",k);
	sleep(3);
	_exit(k);
	
	}
}


	wait(&status);
	printf("fim, pid=%d\n",getpid());










return 0;
}
