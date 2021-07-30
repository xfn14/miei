#include <stdio.h>
#include <stdlib.h>

int bitsUm (unsigned int n){
    int res = 0;
    while (n>0){
        if(n % 2 != 0) res++;
        n /= 2;
    }
    return res;
}

int limpaEspacos(char t[]){
    if(!(*t)) return 0;
    while(*t != '\0')
        if(*t == ' ' && *(t+1) == ' '){
            char * ret = &t;
            while(*t){
                *t = *(t+1);
                t++;
            }
            *t = ret;
        }else t++;
}

typedef struct slist {
    int valor;
    struct slist * prox;
} * LInt;

int dumpL(LInt l, int v[], int N){
    int ins = 0;
    while(ins < N && l){
        *v = l->valor;
        l = l->prox;
        v++; ins++;
    }
    return ins;
}

LInt parte(LInt l){
    int s = 1;
    LInt new;
    LInt * aux = &l;
    while(*aux){
        if(s){
            new = l->prox;
            new = new->prox;
        }else{
            l = new->prox;
            l = l->prox;
        }
    }
    l = *aux;
    return new;
}

int main(){
    return 0;
}