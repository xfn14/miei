#include <stdio.h>

void soma_elemento(int *arr, int dim, int idx);
void roda_esq(int *arr, int dim, int shifter);
int remove_menores(int *arr, int dim, int valor);
void print_array(int *arr, int dim);


int main() {
    int tarefa = 0;
    printf("1. Soma Elementos\n");
    printf("2. Roda Esquerda\n");
    printf("3. Remove Menores\n");
    printf("Escolha uma tarefa\n");
    scanf("%d", &tarefa);

    int dim;
    printf("Introduza uma dimensao\n");
    scanf("%d", &dim);

    int arr[dim];
    printf("Digite os elementos da array\n");
    int i = 0;
    while(i != dim){
        scanf("%d", &arr[i]);
        i++;
    }

    int x;
    printf("Introduza o valor para usar na funcao\n");
    scanf("%d", &x);

    switch(tarefa){
        case 1: soma_elemento(arr,dim,x);
            break;
        case 2: roda_esq(arr,dim,x);
            break;
        case 3: remove_menores(arr,dim,x);
            break;
        default: printf("Tarafa invalida");
    }

    return 0;
}

void soma_elemento(int *arr, int dim, int idx){
    int i = 0;
    int sum = arr[idx];
    while (i != dim){
        arr[i] += sum;
        i++;
    }
    print_array(arr, dim);
}

void roda_esq(int *arr, int dim, int shifter){
    int new_arr[dim];
    int i = 0;
    while(i != dim){
        if(i < shifter){
            new_arr[i-shifter+dim] = arr[i];
        }else{
            new_arr[i-shifter] = arr[i];
        }
        i++;
    }
    print_array(new_arr, dim);
}

int remove_menores(int *arr, int dim, int valor){
    int lower[dim];
    int higher[dim];
    int idx1 = 0, idx2 = 0;
    int i = 0;

    while(i != dim){
        if(arr[i] < valor){
            lower[idx1] = arr[i];
            idx1++;
        }else{
            higher[idx2] = arr[i];
            idx2++;
        }
        i++;
    }

    int final_arr[dim];

    int h = 0;
    while(h != (idx2+1)){
        final_arr[h] = higher[h];
        h++;
    }

    int l = 0;
    while(l != (idx1+1)){
        final_arr[h+l-1] = lower[l];
        l++;
    }

    print_array(final_arr, dim);
}

void print_array(int *arr, int dim){
    putchar('{');

    int i = 0;
    while(i != (dim-1)){
        printf("%d", arr[i]);
        putchar(',');
        i++;
    }
    printf("%d",arr[dim-1]);
    putchar('}');
}