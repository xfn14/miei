/**
@file tabuleiro.h
Definição do tabuleiro e das suas funções
*/
#ifndef SRC_TABULEIRO_H
#define SRC_TABULEIRO_H

#include "data.h"
/**
\brief tabuleiro inicial
 */
const CASA tabuleiro_inicial[8][8];

/**
\brief Função que recebe um estado e imprime o tabuleiro para esse estado.
@param e Estado atual
*/
void mostrar_tabuleiro(ESTADO *e);

#endif //SRC_TABULEIRO_H

