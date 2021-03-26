/**
@file estado.h
Definição das funções que alteram o estado
*/
#ifndef SRC_ESTADO_H
#define SRC_ESTADO_H

#include <stdlib.h>
#include "jogada.h"
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
int obter_jogador_atual(ESTADO *estado); //USED
/**
\brief Função para obter o número de jogadas efetuadas
@param estado Estado atual
@returns Retorna o numero de jogadas efetuadas
*/
int obter_numero_de_jogadas(ESTADO *estado); // USED
/**
\brief Função que através do estado e da coordenada indica o estado da casa referente a essas coordenadas
@param e Apontador para o estado
@param c A coordenada
@returns Retorna o estado da casa
*/
CASA obter_estado_casa(ESTADO *e, COORDENADA c); //USED
/**
\brief Função para desenhar o tabuleiro
@param e Estado atual
@param tab O tabuleiro
@returns Retorna o tabuleiro
*/
void setTabuleiro(ESTADO *e, CASA tab[8][8]); // USED
/**
\brief Função para obter a posição da PECA
percorrendo a matriz da tabuleiro.
@param tab O tabuleiro
@returns Retorna a coordenada da PECA
 */
COORDENADA obter_coordenada_peca(CASA tab[8][8]); // USED
/**
\brief Função para resetar as jogadas
@param estado O estado atual
 */
void resetJogadas(ESTADO *estado); // USED
/**
\brief Função para obter a última jogada efetuada
@param estado O estado atual
@returns Retorna a última jogada efetuada
 */
COORDENADA obter_ultima_jogada(ESTADO *estado); // USED
/**
\brief Funçao para obter a linha de uma coordenada
@param coord coordenada pretendida
@returns Retorna a linha correspondente à coordenada
*/
int obter_linha_coord(COORDENADA coord);
/**
\brief Funçao para obter a coluna de uma coordenada
@param coord coordenada pretendida
@returns Retorna a coluna correspondente à coordenada
*/
int obter_coluna_coord(COORDENADA coord);
#endif //SRC_ESTADO_H
