#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>



int main (){
int n;
char buffer[1024];

mkfifo("fifo",O_RDONLY);

int fd = open("fifo",O_RDONLY);

while(n=read(fd,buffer,1024)>0){
	write(1,buffer,n);
}
close(fd);
return 0;
}
