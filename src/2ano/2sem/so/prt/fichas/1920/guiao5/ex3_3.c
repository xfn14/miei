#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>



int main(int argc, char* argv[]){

char buffer[10];
int p[2];
int status;


pipe(p);

if(!fork()){
	dup2(p[0],0);
	close(p[1]);
	close(p[0]);
	execlp("wc","wc",NULL);
	_exit(-1);
}

else{
	wait(&status);
	close(p[0]);
	int n;
		while((n=read(0,buffer,sizeof(buffer))>0)){
			write(p[1],buffer,n);
		}
close(p[1]);

}

return 0;
}
