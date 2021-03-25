#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(int argc, char*argv[]){


int status;
int p[2];
char buffer[10];

pipe(p);

	int n;
	if(!fork()){
	
	close(p[1]);
	while((n=read(p[0],buffer,sizeof(buffer))>0)){
	write(1,buffer,n);
	write(1,"filho\n",sizeof("filho\n"));
	}

	close(p[0]);
	exit(0);
	}
	
	else{
	wait(&status);
	close(p[0]);
	while((n=read(p[1],buffer,sizeof(buffer))>0)){
	write(1,buffer,n);
	write(1,"pai\n",sizeof("pai\n"));
	}
	close(p[1]);	
	}

return 0;
}
