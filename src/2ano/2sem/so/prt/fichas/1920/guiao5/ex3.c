#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>

int main(int argc, char **argv)
{

    int p[2];

    char *buf = malloc(sizeof(char *));

    pipe(p);
    int n = 0;
    // p[0] descritor de leitura
    // p[1] descritor de escrita

    if (!fork())
    {
        dup2(p[0], 0);
        close(p[0]);
        close(p[1]);
        execlp("wc", "wc", NULL);
    }
    close(p[0]);
    while ((n = read(0, buf, sizeof(char *))) > 0)
    {
        write(p[1], buf, n);
    }
}
