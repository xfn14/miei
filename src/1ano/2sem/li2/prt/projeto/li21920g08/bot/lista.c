#include "lista.h"

// Cria uma listas ligadas vazia
LISTA criar_lista(){
    LISTA lista1 = malloc(sizeof(NODO));
    lista1->valor = NULL;
    return lista1;
}

// Devolve verdareiro se a listas ligadas é vazia
int lista_esta_vazia(LISTA L){
    return L == NULL || (L->valor == NULL && L->proximo == NULL);
}

// Devolve a cabeça da listas ligadas
void *devolve_cabeca(LISTA L){
    return L->valor;
}

// Devolve a cauda da listas ligadas
LISTA proximo(LISTA L){
    return L->proximo;
}

// Insere um valor na cabeça da listas ligadas
LISTA insere_cabeca(LISTA L, void *valor){
    if (L->valor == NULL) {
        L->valor = valor;
        return L;
    } else {
        LISTA t = malloc(sizeof(NODO));
        t->valor = valor;
        t->proximo = L;
        return t;
    }
}
