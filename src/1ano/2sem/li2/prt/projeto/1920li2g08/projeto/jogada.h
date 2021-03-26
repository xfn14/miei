/**
@file jogada.h
Definição da camada logica e das suas funções
*/
#ifndef SRC_JOGADA_H
#define SRC_JOGADA_H

#include "estado.h"
#include "interpretador.h"
#include "tabuleiro.h"
/**
\brief Efetua uma jogada
@param estado Apontador para o estado
@param coord A coordenada
@returns 1 se a jogada for válida, 0 caso contrário
*/
int jogar(ESTADO *estado, COORDENADA coord);
/**
\brief Verifica se a jogada é válida
@param estado Apontador para o estado
@param coord A coordenada
@returns 1 se o jogador ganha, 2 se o jogador 2 ganha, 3 se se move para uma casa vazia e 0 se a jogada não é válida
*/
int jogada_valida(ESTADO *estado, COORDENADA coord);
/**
\brief Adicionar jogadas ao array de jogadas
@param estado Apontador para o estado
@param coord A coordenada
*/
void adicionar_jogada(ESTADO *estado, COORDENADA coord);

#endif //SRC_JOGADA_H
