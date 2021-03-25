#include "movs.h"

void movs(ESTADO *estado){
    for(int i = 0; i < 32; i++){
        COORDENADA jogador1 = obter_jogada_jogador(estado, i, 1);
        COORDENADA jogador2 = obter_jogada_jogador(estado, i, 2);

        //printf("2: %d %d", jogador2.coluna, jogador2.linha);

        int jogador1_linha, jogador2_linha;
        char jogador1_coluna, jogador2_coluna;

        jogador1_linha = 8 - obter_linha_coord(jogador1);
        jogador2_linha = 8 - obter_linha_coord(jogador2);

        jogador1_coluna = 'a' + obter_coluna_coord(jogador1);
        jogador2_coluna = 'a' + obter_coluna_coord(jogador2);

        if(obter_linha_coord(jogador2) == -1 && obter_linha_coord(jogador1) != -1){
            printf("(%d) %c%d\n", i+1, jogador1_coluna, jogador1_linha);
        }else if(obter_linha_coord(jogador1) != -1 && obter_linha_coord(jogador2) != -1){
            printf("(%d) %c%d %c%d\n", i+1, jogador1_coluna, jogador1_linha, jogador2_coluna, jogador2_linha);
        }
    }
}