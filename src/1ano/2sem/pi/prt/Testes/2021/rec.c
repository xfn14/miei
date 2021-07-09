#include <stdio.h>
#include <stdlib.h>

int paresImpares(int v[], int N){
    int i, j, temp;
    int last = N - 1;
    int par_counter = 0;

    for(i = 0; i < last-1; ++i){
        if(v[i] % 2 != 0){
            while(v[last] % 2 != 0)
                last--;
            temp = v[i];
            v[i] = v[last];
            v[last] = temp;
        }
    }

    for(i = 0; i < N; ++i)
        if(v[i] % 2 == 0)
            par_counter++;
    return par_counter;
}

typedef struct llist{
    int val;
    struct llist * prox;
} * LInt;

void merge (LInt *r, LInt a, LInt b){
    while(a || b){
        if (a->val < b->val){
            (*r) = a;
            a = a->prox;
            r = &((*r)->prox);
        }else{
            (*r) = b;
            b = b->prox;
            r = &((*r)->prox);
        }
    }
    for(;a;a = a->prox){(*r)= a;r=&((*r)->prox);}
    for(;b;b = b->prox){(*r)= b;r=&((*r)->prox);}
}

void latino(int N, int m[N][N]){
    int crt = 1, s = 1;
    int i, j;
    for(i = 0; i < N; ++i){
        for(j = 0; j < N; ++j){
            if(s){
                if(crt + i <= N) m[i][j] = crt + i;
                else{
                    s = 0;
                    crt = 1;
                    m[i][j] = crt;
                }
            }else m[i][j] = crt;
            crt++;
        }
        crt = 1;
        s = 1;
    }
}

int main(){
    int p[28], k;
    for(k = 0; k < 28; ++k)
        p[k] = k;

    for(k = 0; k < 28; ++k)
        printf("%d ", p[k]);
    printf("\n");
    int pares = paresImpares(p, 28);
    for(k = 0; k < 28; ++k)
        printf("%d ", p[k]);
    printf("\nn_pares = %d", pares);

    printf("\n");
    printf("\n");

    int N = 3;
    int m[N][N];
    int i, j;
    latino(3, m);
    for(i = 0; i < N; ++i){
        for(j = 0; j < N; ++j){
            printf("%d", m[i][j]);
        }
        printf("\n");
    }
    return 0;
}