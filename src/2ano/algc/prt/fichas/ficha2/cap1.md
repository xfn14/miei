# 1. Análise de programas com ciclos

## 1.

> Considere os seguintes dois algoritmos alternativos para a procura de um elemento numvector.  Note que o segundo algoritmo s ́o pode ser usado sobre vectoresordenados(deforma crescente)

```c
int xlsearch(int a[], int N, int x){
    int i = 0;
    while(i<N && a[i]!=x)
        i++;
    if(i<N) return i;
    else return (-1);
}
```

```c
int lsearch(int a[], int N, int x){
    int i = 0;
    while(i<N && a[i]<x)
        i++;
    if(i<N && a[i]==x) return i;
    else return (-1);
}
```

### 1.a

> Para cada um dos algoritmos, calcule o n ́umero de opera ̧c ̃oes primitivas de acessoao vector de entrada executadas, em fun ̧c ̃ao do tamanho desse vector.