#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <stdio.h>
#include <fcntl.h>

int main(){

	int fd = open("servidor",O_WRONLY);

	int n;

	char buffer[1024];
	while((n=read(0,buffer,1024))>0){
		write(fd,buffer,n);
	}

	close(fd);

	return 0;
}

