#include <stdio.h>
#include <stdlib.h>

void sumhtpoAux(int n[], int * size, int x){
    if(*size < 100) n[(*size)++] = x;
    else{
        int b = n[0], i = 0, j;
        for(j = 1; j < *size; ++j){
            if(b < n[j]){
                b = n[j];
                i = j;
            }
        }
        if(n[i] > x) n[i] = x;
    }
}

int sumhtpo(int n){
    int r = 0, i = 0, arr[100];
    while(n != 1){
        sumhtpoAux(arr, &i, n);
        r += n;
        if(n % 2 == 0) n /= 2;
        else n = 1 + (3 * n);
    }
    if(i < 100) return -1;
    else {
        int max = arr[0], j;
        for(j = 1; j < i; ++j)
            if(max < arr[j])
                max = arr[j];
        return max;
    }
}

int moda(int v[], int N, int * m){
    int init = *m;
    if(N < 1) return 0;
    int i, j, freq = 0, crt, flag = 0;

    for(i = 0; i < N; ++i){
        crt = 0;
        for(j = 0; j < N; ++j)
            if(v[j] == v[i]) crt++;
        if(freq < crt){
            freq = crt;
            *m = v[i];
            flag = 0;
        }else if(crt == freq && *m != v[i]){
            flag = 1;
        }
    }

    if(flag){
        *m = init;
        return 0;
    }else return freq;
}

typedef struct llist {
    int valor;
    struct llist *prox;
} * LInt;

int procura(LInt * l, int x){
    LInt a = *l, before;
    if(!a) return 0;
    if(a->valor == x) return 1;

    while(a){
        if(a->valor == x){
            before->prox = a->prox;
            a->prox = *l;
            *l = a;
            return 1;
        }else before = a;
        a = a->prox;
    } return 0;
}

// assim mete todos os elementos no inicio
int procura2(LInt * l, int x){
    LInt a = *l, before;
    if(!a) return 0;
    if(a->valor == x) return 1;

    int flag = 0;

    while(a){
        if(a->valor == x){
            before->prox = a->prox;
            a->prox = *l;
            *l = a;
            flag = 1;
        }else before = a;
        a = a->prox;
    } return flag;
}

void printLista(LInt l){
    while(l){
        if(l->prox) printf("%d, ", l->valor);
        else printf("%d ", l->valor);
        l = l->prox;
    } printf("\n");
}

typedef struct nodo{
    int valor;
    struct nodo * pai, *esq, *dir;
} * ABin;

int freeAB(ABin a){
    if(!a) return 0;
    int esq = freeAB(a->esq);
    int dir = freeAB(a->dir);
    free(a);
    return 1 + esq + dir;
}

void caminho(ABin a){
    if(!a->pai) return;
    caminho(a->pai);
    if(a->pai->esq == a) printf(" esq\n");
    else printf(" dir\n");
}

int main(){
    int t100;
    t100 = sumhtpo(54189568);
    printf("Ex_1\n t100: %d\n", t100);

    printf("\nEx_2 \n");
    int m;
    int v1[5] = {1,2,3,4,5};
    int v2[5] = {1,1,2,2,3};
    int v3[7] = {1,1,2,2,3,3,3};

    int m1 = moda(v1,5,&m);
    printf(" > 1. %d \n", m1);
    int m2 = moda(v2,5,&m);
    printf(" > 2. %d \n", m2);
    int m3 = moda(v3,7,&m);
    printf(" > 3. %d \n\n", m3);

    int r1, r2, r3, r4;
    //construcao de lista exemplo 2->3->1
    LInt l;
    l = malloc(sizeof(struct llist)*1);
    l->valor = 2;
    l->prox = malloc(sizeof(struct llist));
    (l->prox)->valor = 3;
    (l->prox)->prox = malloc(sizeof(struct llist));
    ((l->prox)->prox)->valor = 1;
    ((l->prox)->prox)->prox = NULL;

    printf("Ex_3\n A lista inicial: ");
    printLista(l);

    r1 = procura(&l, 5);
    printf(" > procura_1 (5) =  %d | ", r1);
    printLista(l);

    r2 = procura(&l, 2);
    printf(" > procura_2 (2) =  %d | ", r2);
    printLista(l);

    r3 = procura(&l, 3);
    printf(" > procura_3 (3) =  %d | ", r3);
    printLista(l);

    r4 = procura(&l, 1);
    printf(" > procura_4 (1) =  %d | ", r4);
    printLista(l);
    
    /*    
                  5
            3          7
                4  

        5 será a nossa raiz
        4 será o nosso a para o qual queremos o caminho 
    */
    ABin raiz, a;
    raiz = malloc(sizeof(struct nodo));
    raiz->valor = 5;
    raiz->pai = NULL;
    raiz->esq = malloc(sizeof(struct nodo));
    raiz->dir = malloc(sizeof(struct nodo));
    (raiz->esq)->valor = 3;
    (raiz->dir)->valor = 7;
    (raiz->esq)->pai = raiz;
    (raiz->dir)->pai = raiz;
    (raiz->esq)->dir = malloc(sizeof(struct nodo));
    ((raiz->esq)->dir)->valor = 4;
    ((raiz->esq)->dir)->pai = raiz->esq;

    printf("\nEx_5\n");
    a = (raiz->esq)->dir;
    caminho(a);

    int n = freeAB(raiz);
    printf("\nEx_4\n n_nodos = %d\n", n);
    
    return 0;
}
