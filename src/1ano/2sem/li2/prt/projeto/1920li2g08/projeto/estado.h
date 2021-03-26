/**
@file estado.h
Definição das funções que alteram o estado
*/
#ifndef SRC_ESTADO_H
#define SRC_ESTADO_H

#include <stdlib.h>
#include "data.h"
/**
\brief Inicializa o estado
@returns Retorna o estado inicializado
*/
ESTADO *inicializar_estado();
/**
\brief Função para obter o jogador atual
@param estado Estado atual
@returns Retorna o jogador atual
*/
int obter_jogador_atual(ESTADO *estado);
/**
\brief Função para obter o número de jogadas efetuadas
@param estado Estado atual
@returns Retorna o numero de jogadas efetuadas
*/
int obter_numero_de_jogadas(ESTADO *estado);
/**
\brief Função que através do estado e da coordenada indica o estado da casa referente a essas coordenadas
@param e Apontador para o estado
@param c A coordenada
@returns Retorna o estado da casa
*/
CASA obter_estado_casa(ESTADO *e, COORDENADA c);
/**
\brief Função para desenhar o tabuleiro
@param e Estado atual
@param tab O tabuleiro
@returns Retorna o tabuleiro
*/
void setTabuleiro(ESTADO *e, CASA tab[8][8]);
/**
\brief Função para obter a posição da PECA
percorrendo a matriz da tabuleiro.
@param tab O tabuleiro
@returns Retorna a coordenada da PECA
 */
COORDENADA obter_coordenada_peca(CASA tab[8][8]);
/**
\brief Função para resetar as jogadas
@param estado O estado atual
 */
void resetJogadas(ESTADO *estado);
/**
\brief Função para obter a última jogada efetuada
@param estado O estado atual
@returns Retorna a última jogada efetuada
 */
COORDENADA obter_ultima_jogada(ESTADO *estado);

#endif //SRC_ESTADO_H
