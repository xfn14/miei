#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(){

char buffer[1024];


int fd = open ("fifo",O_WRONLY);
int n;

while((n=read(1,buffer,1024))>0)
	write(fd,buffer,n);


close(fd);

return 0;
}

