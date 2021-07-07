#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    int valor;
    struct node *esq, *dir;
} *ABin;

int mystrlen(char s[]){
    int i = 0;
    while(s[i] != '\0')
        i++;
    return i;
}

void strrev (char s[]){
    int i = mystrlen(s), j, y = i - 1;
    char rev[i];

    for(j = 0; j < i; j++)
        rev[j] = s[y--];

    for(y = 0; y < i; y++)
        s[y] = rev[y];
}

int remRep(char x[]){
    int len = mystrlen(x), i, j;
    if(len == 0) return 0;
    char last = x[0];

    for(i = 1; i < len ; i++){
        if(x[i] == last){
            for(j = i; j < len; j++)
                x[j] = x[j+1];
            len--; i--;
        }else{
            last = x[i];
        }
    }
    return len;
}

void merge (int r[], int a[], int b[], int na, int nb){
    int i = 0, j = 0, k = 0;
    for(i = 0, j = 0; i < na && j < nb;){
        if(a[i] < b[j]) r[k++] = a[i++];
        else r[k++] = b[j++];
    }

    for(; i < na; i++) r[k++] = a[i];
    for(; j < nb; j++) r[k++] = b[j];
}

int deProcuraAux(ABin a, int x, int maior) {
    if(!a) return 1;
    if((maior && a->valor < x) || (!maior && a->valor > x)) return 0;
    return deProcuraAux(a->esq, x, maior) && deProcuraAux(a->dir, x, maior);
}

int deProcura (ABin a) {
    if(!a) return 1;
    int b = deProcuraAux(a->esq, a->valor, 0) && deProcura(a->esq);
    int c = deProcuraAux(a->dir, a->valor, 1) && deProcura(a->dir);
    return b && c;
}

typedef struct digito{
    unsigned char val;
    struct digito *prox;
} *Num;

unsigned char digitToChar(unsigned int i){
    if(i == 0) return '0';
    if(i == 1) return '1';
    if(i == 2) return '2';
    if(i == 3) return '3';
    if(i == 4) return '4';
    if(i == 5) return '5';
    if(i == 6) return '6';
    if(i == 7) return '7';
    if(i == 8) return '8';
    if(i == 9) return '9';
    else return '0';
}

Num fromInt(unsigned int i){
    unsigned int j;
    Num final = NULL, temp = NULL;
    
    while(i){
        j = i % 10;
        i /= 10;

        Num new = malloc(sizeof(Num));
        new->val = digitToChar(j);
        new->prox = NULL;

        if(!final) final = new;
        else{
            temp = final;
            for(; temp->prox; temp = temp->prox);
            temp->prox = new;
        }
    }
    return final;
}

int main(){
    int i = 1234;
    printf("%d\n", i%10);
}