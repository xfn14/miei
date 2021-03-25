include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main()
{

    int fd[2];
    pipe(fd);

    if (!fork())
    {
        dup2(fd[1], 1);
        close(fd[1]);
        close(fd[0]);
        execlp("grep", "grep", "-v", "ˆ#", "/etc/passwd", (char *)0);
        _exit(-1);
    }
    dup2(fd[0], 0);
    close(fd[0]);
    close(fd[1]);

    pipe(fd);
    if (!fork())
    {
        dup2(fd[1], 1);
        close(fd[1]);
        close(fd[0]);
        execlp("cut", "cut", "-f7", "-d:", (char *)0);
        _exit(-1);
    }
    dup2(fd[0], 0);
    close(fd[0]);
    close(fd[1]);

    pipe(fd);
    if (!fork())
    {
        dup2(fd[1], 1);
        close(fd[1]);
        close(fd[0]);
        execlp("uniq", "uniq", (char *)0);
        _exit(-1);
    }
    dup2(fd[0], 0);
    close(fd[0]);
    close(fd[1]);

    execlp("wc", "wc", "-l", (char *)0);
    return 0;
}
