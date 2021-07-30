#include <stdio.h>
#include <stdlib.h>

typedef struct llist{
    int val;
    struct llist * prox;
} * LInt;

int paresImpares(int v[], int N){
    int i, j = N - 1, temp, pares = 0;
    for(i = 0; i < j - 1 && i < N; ++i){
        if(v[i] % 2 != 0){
            while(v[j] % 2 != 0) j--;
            temp = v[i];
            v[i] = v[j];
            v[j] = temp;
            printf("ola\n");
        }
    }
    for(i = 0; i < N; ++i){
        if(v[i] % 2 == 0) pares++;
    } return pares;
}

void merge (LInt * r, LInt a, LInt b){
    while(a || b){
        if((a && !b) || (a && b && a->val < b->val)){
            *r = a;
            a = a->prox;
        }else if((b && !a) || (a && b && b->val < a->val)){
            *r = b;
            b = b->prox;
        } r = &((*r)->prox);
    }
}

void latino(int N, int m[N][N]){
    int i, j;
    for(i = 0; i < N; ++i){
        int number = i+1;
        for(j = 0; j < N; ++j){
            if(number > N) number = 1;
            m[i][j] = number++;
        }
    }
}

void printLista(LInt l){
    while(l){
        if(!l->prox) printf("%d", l->val);
        else printf("%d, ", l->val);
        l = l->prox;
    } printf("\n");
}

int main(){
    int p[29], k;
    for(k = 0; k < 29; ++k)
        p[k] = k;

    for(k = 0; k < 29; ++k)
        printf("%d ", p[k]);
    printf("\n");
    int pares = paresImpares(p, 29);
    for(k = 0; k < 29; ++k)
        printf("%d ", p[k]);
    printf("\nn_pares = %d", pares);

    printf("\n");
    printf("\n");

    //construcao de lista exemplo l 1->3->7
    LInt l1, l2, r = NULL;
    l1 = malloc(sizeof(struct llist)*1);
    l1->val = 1;
    l1->prox = malloc(sizeof(struct llist));
    (l1->prox)->val = 3;
    (l1->prox)->prox = malloc(sizeof(struct llist));
    ((l1->prox)->prox)->val = 7;
    ((l1->prox)->prox)->prox = NULL;

    //construcao de lista exemplo l2 -3->2->9
    l2 = malloc(sizeof(struct llist)*1);
    l2->val = -3;
    l2->prox = malloc(sizeof(struct llist));
    (l2->prox)->val = 2;
    (l2->prox)->prox = malloc(sizeof(struct llist));
    ((l2->prox)->prox)->val = 9;
    ((l2->prox)->prox)->prox = NULL;

    printf("LISTA l1: ");
    printLista(l1);
    printf("\nLISTA l2: ");
    printLista(l2);

    merge(&r, l1, l2);

    printf("\nLista do merge: ");
    printLista(r);
    printf("\n");

    int N = 10;
    int m[N][N];
    int i, j;
    latino(10, m);
    for(i = 0; i < N; ++i){
        for(j = 0; j < N; ++j)
            printf("%d ", m[i][j]);
        printf("\n");
    }
    return 0;
}
