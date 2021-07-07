#include <stdio.h>
#include <stdlib.h>

char * strstr(char s1[], char s2[]){
    int i = 0, j = 0, b = 0;
    while(s1[i]){
        if(s1[i] == s2[i]){
            b = j = 0;
            while(s2[j]){
                if(s2[j] != s1[i+j]) b = 1;
                j++;
            }
            if(b == 0) return &s1[i];
        }
        i++;
    }
    return NULL;
}

void truncW(char t[], int n){
    int word = 0, i = 0, p = 0;
    while(t[i]){
        if(t[i] == ' '){
            word = 0;
            p = 0;
        }else{
            if(word >= n){
                p = i;
                while(t[p]){
                    t[p] = t[p+1];
                    p++;
                }
            }else{
                word++;
                p = 0;
            }
        }
        if(p == 0) i++;
    }
}

typedef struct posicao{
    int x, y;
} Posicao;

float calcDist(Posicao pos){
    return sqrt(pos.x*pos.x + pos.y*pos.y);
}

int maisCentral(Posicao pos[], int N){
    int i = 0, min = 0;
    while(pos[i]){
        if(calcDist(pos[i]) < calcDist(pos[max]))
            min = i;
        i++;
    }
    return min;
}

typedef struct slist{
    int valor;
    struct slist *prox;
} *LInt;

LInt somasAcL(LInt l){
    LInt init = l;
    int old = init->valor;
    if(!init->prox) return init;
    init = init->prox;
    while(init){
        init->valor = init->valor + old;
        old = init->valor;
        init = init->prox;
    }
    return l;
}

int main(){
    return 0;
}