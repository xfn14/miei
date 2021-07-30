#include <stdio.h>
#include <stdlib.h>

int test(char t[]){
    int i;
    for(i = 0; *(t+i); ++i){
        if(*(t+i) == 'a'){

        }
    }
}

// ola ola ola

int limpaEspacos(char t[]){
    char * init = t;
    char * crt;
    int size = 0;

    while(*(t+1)){
        if(*t == ' ' && *(t+1) == ' '){
            crt = t;
            for(; *t; ++t) *t = *(t+1);
            t = crt;
        } else t++;
    }

    t = init;
    while(*t){
        size++; t++;
    } return size;
}

void transposta(int N, float m[N][N]){
    int i, j, temp;
    for(i = 0; i < N; ++i){
        for(j = i; j < N; ++j){
            temp = m[i][j];
            m[i][j] = m[j][i];
            m[j][i] = temp;
        }
    }
}

typedef struct slist {
    int valor;
    struct slist *prox;
} *LInt;


LInt appendLInt(int v, LInt t){
    LInt new = malloc (sizeof (struct slist));
    if (new != NULL) {
        new->valor = v;
        new->prox  = t;
    }
    return new;
}

LInt cloneL(LInt l){
    if(!l) return NULL;
    LInt new = NULL;
    while(l){
        LInt crt = malloc(sizeof(struct slist));
        crt->valor = l->valor;
        crt->prox = new;
        new = crt;
        l = l->prox;
    }

    LInt nova = NULL;
    while(new){
        LInt crt = malloc(sizeof(struct slist));
        crt->valor = new->valor;
        crt->prox = nova;
        nova = crt;
        new = new->prox;
    }
    return nova;
}

#define MAXc 10
typedef struct chunk {
    int vs[MAXc];
    struct chunk * prox;
} * CList;

typedef struct stackC {
    CList valores;
    int sp;
} StackC;

int push(StackC * s, int x){
    if(!s){
        // instead of this could be return 1;
        s = malloc(sizeof(StackC));
        s->valores = malloc(sizeof(struct chunk));
        s->sp = -1;
    }

    if(s->sp + 1 == MAXc){
        s->sp = -1;
        CList new = malloc(sizeof(struct chunk));
        new->prox = s->valores;
        s->valores = new;
    }  
    s->valores->vs[s->sp++] = x;
    return 0;
}

int pop(StackC * s, int * x){
    if(!s && !s->valores) return 1;
    if(s->sp == 0){
        return s->valores->vs[MAXc];
    }
}

int main(){
    return 0;
}