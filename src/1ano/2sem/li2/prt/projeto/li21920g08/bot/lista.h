#ifndef SRC_LISTA_H
#define SRC_LISTA_H

#include "stdio.h"
#include "stdlib.h"

/**
\brief Tipo de dados para os nodos
*/
typedef struct nodo {
    void *valor;
    struct nodo *proximo;
} NODO, *LISTA;

LISTA criar_lista();
int lista_esta_vazia(LISTA L);
void *devolve_cabeca(LISTA L);
LISTA proximo(LISTA L);
LISTA insere_cabeca(LISTA L, void *valor);

#endif //SRC_LISTA_H
