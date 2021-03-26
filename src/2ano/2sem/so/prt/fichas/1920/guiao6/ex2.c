#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <stdio.h>

int main(){

    char buffer[1024];

    int fd1 = open("log.txt", O_CREAT | O_APPEND | O_WRONLY, 0666); 
    int fd2; 

    while(1){
        fd2 = open("fifo", O_RDONLY);
	
        ssize_t bytes_read;

        while( (bytes_read = read(fd2,buffer,1024)) > 0 )
            write(fd1,buffer,bytes_read);
    }
    close(fd1);
    close(fd2);

	return 0;
}
