#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

int main () {

int fd_log = open ("logs.txt",O_CREAT | O_RDWR| O_APPEND,0666);
int fd_sv;

	if(mkfifo("servidor",0666)<0)
	{
	       	perror("erro");
		return -1;
	}

int n;
char buffer[1024];

	while(1){
			printf("espera\n");	
	 fd_sv = open ("servidor", O_RDONLY);
			printf("Abriu\n");
		while((n=read(fd_sv,buffer,1024))>0){
			write(fd_log,buffer,n);
			printf("abc");
		}
	}
		close(fd_log);
		close(fd_sv);

		return 0;
	}
		

