#include <stdio.h>
#include <stdlib.h>

int retiraNeg(int v[], int N){
    int i, j;
    for(i = 0; i < N; ++i){
        if(v[i] < 0){
            for(j = i; j < N - 1; ++j)
                v[j] = v[j+1];
            N--; i--;
        }
    }
    return N;
}

int difConsecutivos(char s[]){
    int maximo = 0, contador;
    int i, j;
    char cmp;
    for(i = 0; s[i]; i++){
        contador = 1;
        cmp = s[i];
        for(j = i+1; s[j]; j++){
            if(cmp != s[j]){
                cmp = s[j];
                contador++;
            } else break;
        }
        if(contador > maximo)
            maximo = contador;
    }
    return maximo;
}

typedef struct slist {
    int valor;
    struct slist * prox;
} * LInt;

int maximo(LInt l){
    LInt aux = l;
    int max = aux->valor;
    while(aux){
        if(aux->valor > max)
            max = aux->valor;
        aux = aux->prox;
    }
    return max;
}

int removeAll (LInt * l, int x){
    int remove = 0;
    LInt * l1 = l;
    while(*l1){
        if((*l1)->valor == x){
            remove++;
            (*l1) = (*l1)->prox;
        }else l1 = &((*l1)->prox);
    }
    return remove;
}

LInt arrayToList(int v[], int N){
    if(N == 0) return NULL;
    LInt new = NULL;
    int i;
    for(i = N-1; i >= 0; --i)
        new = newLInt(v[i], new);
    return new;
}

int main(){
    return 0;
}