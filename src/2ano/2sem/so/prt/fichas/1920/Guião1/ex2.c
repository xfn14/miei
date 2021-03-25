#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>

//stdin fd == 0
//stdout fd == 1
int main(){

char a;
ssize_t b;
	while((b=read(0,&a,1))>0)
	write(1,&a,1);
return 0;
}
