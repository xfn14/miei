#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>



#define SIZE 1024

char buffer[SIZE];
int main(int argc, char* argv[]){

	int fd = open("fifo" , O_RDONLY);
	if (fd == -1) perror("erro open");
	else{
	printf("fifo aberto p leitura\n");}

int bytes_lidos;
		while((bytes_lidos = read(0, buffer, 1024))>0)
			write(fd,buffer,bytes_lidos);

		if (bytes_lidos  == 0){
		printf("EOF ok\n");

		}
		else perror("read");


	close(fd);
	return 0;
}
