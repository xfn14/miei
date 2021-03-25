#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>


int main(int argc, char*argv[]){

int p[2];

pipe(p);
if(!fork()){

	dup2(p[0],0);
	close(p[1]);
	close(p[0]);
	pipe(p);
		if(!fork()){
			close(p[0]);




	


}
