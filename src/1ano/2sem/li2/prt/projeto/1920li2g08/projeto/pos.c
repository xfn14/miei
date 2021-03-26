#include "pos.h"

void pos(ESTADO *estado, int pos){
    COORDENADA nula;
    nula.linha = -1;
    nula.coluna = -1;

    int jogadas = obter_numero_de_jogadas(estado);
    if(0 < pos && pos <= jogadas + 1){
        for(int i = pos; i <= jogadas; i++){
            COORDENADA jogador1_coord = obter_jogada_jogador(estado, i, 1);
            COORDENADA jogador2_coord = obter_jogada_jogador(estado, i, 2);

            estado->tab[obter_linha_coord(jogador1_coord)][obter_coluna_coord(jogador1_coord)] = VAZIO;
            estado->tab[obter_linha_coord(jogador2_coord)][obter_coluna_coord(jogador2_coord)] = VAZIO;

            estado->jogadas[i].jogador1 = nula;
            estado->jogadas[i].jogador2 = nula;
        }

        if(pos == 0){
            COORDENADA init;
            init.linha = 3;
            init.coluna = 4;
            estado->tab[obter_linha_coord(init)][obter_coluna_coord(init)] = PECA;
            estado->ultima_jogada = init;
        }else{
            COORDENADA jogador2_coord = obter_jogada_jogador(estado, pos-1, 2);
            estado->tab[obter_linha_coord(jogador2_coord)][obter_coluna_coord(jogador2_coord)] = PECA;
            estado->ultima_jogada = jogador2_coord;
        }

        estado->jogador_atual = 1;
        estado->num_jogadas = pos;
        mostrar_tabuleiro(estado);
    }else{
        printf("Argumento invalido.\n");
    }
}