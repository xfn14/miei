#include <stdio.h>
#include <stdlib.h>

typedef struct dlist {
    int valor;
    struct dlist *ant, *prox;
} NodoD;

typedef struct{
    NodoD *front, *last;
} DLint;

int capicua(DLint l){
    int res = 0;
    if(!&l) return 0;
    while(l.front && l.last){
        if(l.front == l.last) res = 1;
        else res = 0;
        l.front = l.front->prox;
        l.last = l.last->ant;
    }
    return res;
}
