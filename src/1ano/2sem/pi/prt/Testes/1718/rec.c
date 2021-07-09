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

typedef struct celula {
    char * palavra;
    int comp;
    struct celula * prox;
} * Palavras;

int daPalavra(char * s, int * e){
    int size = 0;
    int t = 1;
    while(*s){
        if(t){
            if(isspace(*s)){
                (*e)++;
            }else{
                size++;
                t = 0;
            }
        }else{
            if(isspace(*s)){
                break;
            }else{
                size++;
            }
        }
        *s++;
    }
    return size;
}

Palavras words (char *texto){
    if(!(*texto)) return NULL;
    int e=0;
    Palavras temp = malloc(sizeof(struct celula));
    Palavras *ret = &temp;
    while(*texto){
        int len = daPalavra(texto,&e);
        Palavras new = malloc(sizeof(struct celula));
        temp->palavra = texto;
        temp->comp = len;
        temp->prox = new;
        temp = temp->prox;
        texto += len + e;
    }
    return *ret;
}

Palavras words(char * texto){
    if(!(*texto)) return NULL;
    Palavras p = malloc(sizeof(struct celula));
    Palavras * ret = &p;
    int crt_size = 0;
    int word = 0;
    while(*texto){
        if(isspace(*texto)){
            if(word){
                p->comp++;
            }else{
                p->palavra = texto;
                p->comp = 1;
            }
            word = 1;
        }else{
            if(word){
                Palavras new = malloc(sizeof(struct celula));
                p->prox = new;
                p = p->prox;
            }
            word = 0;
        }
    }
    return *ret;
}

Palavras daLinha (Palavras t, int n){
    if(!t) return NULL;
    int contador = 0;
    Palavras * ret = &t;
    Palavras temp;
    while(t){
        if(contador + t->comp + 1 <= n){
            contador += t->comp + 1;
            temp = t;
            t = t->prox;
        }else break;
    }
    t = *ret;
    return temp->prox;
}

int main(){
    char * s = "     test tester ";
    int i = 0;
    int x = daPalavra(s, &i);
    printf("%d %d\n", x, i);
    return 0;
}