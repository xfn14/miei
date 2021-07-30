#include <stdio.h>
#include <stdlib.h>

int sumhtpo(int n){
    int r = 0, i = 0;
    int res[100], len = 0;
    while(n != 1){
        len = addElement(n, res, len);
        r += n;
        if(n % 2 == 0) n /= 2;
        else n = 1 + (3*n);
    }

    if(len < 100) return -1;

    int x = res[0];
    for(i = 1; i < len; ++i)
        if(res[i] > x) x = res[i];
    return x;
}

int addElement(int elem, int res[], int N){
    int i;
    if(N < 100){
        res[N++] = elem;
    }else{
        int x = res[0], n = 0;
        for(i = 1; i < N; ++i){
            if(x < res[i]){
                x = res[i];
                n = i;
            }
        }
        if(x > elem) res[n] = elem;
    }
    return N;
}

int moda(int v[], int N, int *m){
    if(N == 0) return 0;

    int i, j;
    int x = v[0], n = modaAux(v, N, v[0]);
    int mod = 0, temp;
    for(i = 1; i < N; ++i){
        if(x == v[i]) continue;
        temp = modaAux(v, N, v[i]);
        if(temp == n) mod = 1;
        else if(temp > n){
            mod = 0;
            n = temp;
            x = v[i];
        }
    }
    *m = x;
    return mod;
}

int modaAux(int v[], int N, int x){
    int i, n = 0;
    for(i = 0; i < N; ++i)
        if(v[i] == x) n++;
    return n;
}

typedef struct lligada {
    int valor;
    struct lligada *prox;
} * LInt;

LInt newLInt (int v, LInt t){
    LInt new = (LInt) malloc (sizeof (struct lligada));
    
    if (new!=NULL) {
        new->valor = v;
        new->prox  = t;
    }
    return new;
}

int procura(LInt *l, int x){
    if(!(*l)) return 0;
    LInt last = NULL;
    LInt temp = *l;
    // if(temp->valor == x) return 1;
    while(temp){
        if(temp->valor == x){
            if(!last){
                last->prox = temp->prox;
                temp->prox = *l;
                *l = temp;
            } 
            return 1;
        }
        last = temp;
        temp = temp->prox;
    }
    return 0;
}

void printLI(LInt l){
    while(l){
        printf("%d ", l->valor);
        l = l->prox;
    }
    printf("\n");
}

typedef struct nodo {
    int valor;
    struct nodo *pai, *esq, *dir;
} *ABin;

int freeAB(ABin a){
    if(!a) return 0;
    int esq = 0, dir = 0;
    if(a->esq) esq = freeAB(a->esq);
    if(a->dir) dir = freeAB(a->dir);
    free(a);
    return 1 + esq + dir;
}

// (*x).y == x->y
void caminho(ABin a){
    if(!a->pai) return;
    caminho(a->pai);
    if(a->pai->esq == a) printf("esq\n");
    else printf("dir\n");
}

int main(){
    int t100;
    t100 = sumhtpo(100);
    printf("t100: %d\n", t100);
    return 0;

    LInt ll = newLInt(10, NULL);
    ll = newLInt(7, ll);
    ll = newLInt(8, ll);
    ll = newLInt(7, ll);
    printLI(ll);
    printf("%d\n", procura(&ll, 7));
    printLI(ll);
    return 0;
}
