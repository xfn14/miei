#ifndef SRC_LISTA_H
#define SRC_LISTA_H

#include "stdio.h"
#include "stdlib.h"
#include "math.h"
#include "data.h"
#include "interpretador.h"

/**
\brief Tipo de dados para os nodos
*/
typedef struct nodo {
    void *valor;
    struct nodo *proximo;
} NODO, *LISTA;

/**
\brief Cria uma listas ligadas vazia
@returns listas ligadas vazia
*/
LISTA criar_lista();
/**
\brief Insere um valor à cabeça da listas ligadas
@param L listas ligadas
@param valor valor pretendido
@returns L retorna a listas ligadas apenas com o valor, t insere o valor à cabeça de uma listas ligadas
*/
LISTA insere_cabeca(LISTA L, void *valor);
/**
\brief Devolve a cabeça de uma listas ligadas
@param L Lista
*/
void *devolve_cabeca(LISTA L);
/**
\brief Devolve a cauda de uma listas ligadas
@param L Lista
@returns Retorna a cauda da listas ligadas
*/
LISTA proximo(LISTA L);
/**
\brief Remove a cabeça de uma listas ligadas, libertando o espaço ocupado
@param L Lista
@returns Retorna a cauda da listas ligadas
*/
LISTA remove_cabeca(LISTA L);
/**
\brief Verifica se uma listas ligadas está vazia
@param L Lista
@returns Retorna verdadeiro se a listas ligadas estiver vazia
*/
int lista_esta_vazia(LISTA L);
/**
\brief Funçao que efetua uma jogada para o jogador atual
@param estado estado atual
*/
void jog(ESTADO *estado);
/**
\brief Funçao que verifica quais sao as jogadas proximas da coordenada atual
@param e estado atual
@param L Lista
@returns Retorna uma listas ligadas com as jogadas proximas
*/
LISTA jogadasProximas(ESTADO *e, LISTA L);
/**
\brief Funçao que calcula a distancia para um dos jogadores ganhar
@param coord1 primeira coordenada
@param coord2 segunda coordenada
*/
float distancia_eucladiana(COORDENADA coord1, COORDENADA coord2);
/**
\brief Funçao que efetua uma jogada para o jogador atual mas melhorada
@param estado estado atual
*/
void jog2(ESTADO *estado);
/**
\brief Funçao que através da heuristica minimax calcula a proxima jogada
@param estado estado atual
@param lista lista de jogadas possiveis
*/
LISTA minimax(ESTADO *estado, LISTA lista);

#endif //SRC_LISTA_H
