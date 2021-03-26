#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/types.h>
#include <fcntl.h>


int main(int argc, char* argv[]){

char buffer[1024];
int bytes_read;
int fd = open ("fifo", O_WRONLY);

while((bytes_read = read(fd,buffer,1024))>0){
write(1,buffer,bytes_read);
}


close(fd);
return 0;
}
