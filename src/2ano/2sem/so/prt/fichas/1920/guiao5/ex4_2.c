#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>





int main(int rgc, char*argv[]){
int status;
int p[2];



pipe(p);

if(!fork()){
dup2(p[0],0);
close(p[1]);
close(p[0]);
execlp("wc","wc", "-l",NULL);
_exit(-1);

}



else{
dup2(p[1],1);
close(p[0]);
close(p[1]);

execlp("ls","ls","/etc",NULL);
}



return 0;
}
