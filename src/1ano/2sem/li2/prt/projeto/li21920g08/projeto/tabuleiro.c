#include <stdio.h>
#include "tabuleiro.h"

void mostrar_tabuleiro(ESTADO *e){
    int linha = 8;

    for(int i = 0; i < 8; i++){
        printf("%d | ", linha);
        for(int j = 0; j < 8; j++){
            CASA cs = e->tab[i][j];
            if(cs == POS1) putchar('1');
            else if(cs == POS2) putchar('2');
            else if(cs == RASTRO) putchar('#');
            else if(cs == PECA) putchar('*');
            else if(cs == VAZIO) putchar('.');
        }
        putchar('\n');
        linha--;
    }

    printf("  | ABCDEFGH\n");
}
