#include <unistd.h>
#include <string.h>
#include <stdlib.h>


int main(int argc, char* argv[]){

int pd[2];
char* b = "escrito";
pipe(pd);
char buffer[10];

if (!fork()){
	close(pd[1]);
read(pd[0],buffer,10);
	close(pd[0]);
}
else{

close(pd[0]);
write(pd[1],b,sizeof(b));
close(pd[1]);
}

return 0;
}
