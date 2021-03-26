/*O_RDONLY, O_WRONLY, O_CREAT, O_* */

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#define SIZE 1024

/* open(const char*path, int oflag [, mode]);
 * ssize_t read(int fildes, void*buf, size_t nbyte);
 * ssize_t write(int fildes, const void*buf, size_t nbyte);
 * off_t   lseek(int fd, off_t offset, int whence);
 * int     close(int fildes);*
 */

int main (int argc , char * argv[]){
	
char buffer[SIZE];

	if (argc<0 || argc>3){
		
		perror("Erro de falta de argumentos");
		
	}
	
		else{
		
		int fd1 = open(argv[1],O_RDONLY);
		
		int fd2 = open(argv[2],O_CREAT | O_RDWR);
		
		if (fd1==(-1)||fd2 ==(-1)){
		

			perror("Erro de acesso ao(s) ficheiros");
		
		}	
		
		else{

		int l;

		while((l=read(fd1,buffer,SIZE))>0){


	
			write(fd2,buffer,l);
		}	

		
		


		close(fd1);
		close(fd2);
		}

	}	
}
