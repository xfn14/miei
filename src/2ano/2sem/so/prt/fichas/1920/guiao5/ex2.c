#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>

int main(int argc, char **argv)
{

    int p[2];

    char buf[30];

    pipe(p);
    int n = 0;
    // p[0] descritor de leitura
    // p[1] descritor de escrita

    if (!fork())
    {
        close(p[1]);
        while ((n = read(p[0], buf, 30)) > 0)
        {
            write(1, buf, n);
            write(1, "Sou o filho\n", 12);
        }
        exit(0);
    }
    while ((n = read(0, buf, 30)) > 0)
    {
        write(p[1], buf, n);
        write(1, "Sou o pai\n", 10);
        close(p[1]);
    }
}
