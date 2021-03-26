#ifndef SRC_POS_H
#define SRC_POS_H

#include "stdio.h"
#include "data.h"
#include "estado.h"
#include "tabuleiro.h"

/**
\brief Esta função lê o estado e o valor dado pelo jogador e volta ao tabuleiro com as jogadas até essa posição
@param estado O estado atual
@param jogada Posição à qual se pretende voltar
*/
void pos(ESTADO *estado, int jogada);

#endif //SRC_POS_H
