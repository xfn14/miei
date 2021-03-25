#include "data.h"

int obter_linha_coord(COORDENADA coord){
    return coord.linha;
}

int obter_coluna_coord(COORDENADA coord){
    return coord.coluna;
}

COORDENADA obter_jogada_jogador(ESTADO *estado,int jogada, int jogador){
    if(jogador == 2){
        return estado->jogadas[jogada].jogador2;
    }else{
        return estado->jogadas[jogada].jogador1;
    }
}