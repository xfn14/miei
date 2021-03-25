#include <stdio.h>
#include <stdlib.h>

// 1. Estado e atribuições

void ex1a(){
    int x, y;
    x = 3; y = x + 1;
    x = x * y ; y = x + y ;
    printf ("%d %d\n ", x, y);

    /* OUTPUT:
     * 12 16
     */
}

void ex1b(){
    int x, y;
    x = 0;
    printf ("%d %d\n ", x, y);

    /* OUTPUT:
     * 0 39 *Este output varia*
     */
}

void ex1c(){
    char a, b, c;
    a = 'A'; b = ' '; c = '0';
    printf("%c %d\n", a, a);
    a = a + 1; c = c + 2;
    printf("%c %d %c %d\n", a, a, c, c);
    c = a + b;
    printf("%c %d\n" , c , c );

    /* OUTPUT:
     * A 65
     * B 66 2 50
     * b 98
     */
}

void ex1d(){
    int x, y;
    x = 200; y = 100;
    x = x + y; y = x - y; x = x - y;
    printf ("%d %d\n ", x, y);
    /* OUTPUT:
     * 100 200
     */
}

// 2. Estruturas de controlo

void ex2a(){
    int x, y;
    x = y = 0;
    while(x != 11){
        x = x + 1; y += x;
    }
    printf("%d %d\n", x, y);

    /* OUTPUT:
     * 11 66
     */
}

void ex2b(){
    int x, y;
    x = y = 0;
    while (x != 11){
        x = x + 2; y += x;
    }
    printf("%d %d\n", x, y);

    /* OUTPUT:
     * x nunca chega a ser igual 2;
     */
}

void ex2c(){
    int i;
    for(i=0; i<20; i++){
        if(i%2 == 0){
            putchar('_');
        }else{
            putchar('#');
        }
    }

    /* OUTPUT:
     * _#_#_#_#_#_#_#_#_#_#
     */
}

void ex2d(){
    char i, j;
    for(i='a'; i!='h'; i++){
        for(j=i; j!='h'; j++){
            putchar(j);
        }
        putchar('\n');
    }

    /* OUTPUT:
     * abcdefg
     * bcdefg
     * cdefg
     * defg
     * efg
     * fg
     * g
     */
}

void ex2e(int n){
    while(n>0){
        if(n%2 == 0){
            putchar('0');
        }else{
            putchar('1');
        }
        n = n/2;
    }
    putchar('\n');

    /* OUTPUT:
     * Converte um numero para binario
     */
}

void ex2f(){
    int i;
    for(i=0; i<16; i++){
        ex2e(i);
        /* OUTPUT:
         * 1
         * 01
         * 11
         * 001
         * 101
         * 011
         * 111
         * 0001
         * 1001
         * 0101
         * 1101
         * 0011
         * 1011
         * 0111
         * 1111
         */
    }
}

// Exercicio 2
void ex2(int n){
    int i;
    for(i = 0; i < n; ++i){
        int j = n;
        while(j--){
            putchar('#');
        }
        putchar('\n');
    }
}

// Exercicio 3
void ex3(int n){
    int i;
    for(i = 0; i<n; ++i){
        int j;
        for(j = 0; j<n; ++j){
            putchar((i + j) % 2 == 0 ? '#' : '_');
        }
        putchar('\n');
    }
}

int main() {
    ex3(6);
    return 0;
}