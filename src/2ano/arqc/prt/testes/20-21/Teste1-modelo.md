# Teste 1 - Modelo - 2020/2021

## 1

> Considere  o  seguinte  excerto  de  um  programa  escrito  em assemblye  a executar numa máquina com cache

```s
movl 0(%ebx)    , %edx
movl $10        , 0(%ebx)
addl $4         , %ebx
cmpl $0         , %edx
jnz  ciclo
```

> Considere que o registo %ebx aponta para o início de um array de inteiros (4 bytes) com os seguintes  valores: -10,  30,  1024, -33,  0.  Note  que  o  ciclo  termina  quando  o  valor  lido  do array for 0. A frequência do relógio é de 2GHz, o CPI_CPU é 2, a miss rate de instruções é de 3%  e  a  de  dados  de 5%.Sabendo  queo  tempo  de execução  deste  programa é  de  150  ns, qual é a miss penalty(expressa em tempo)?

###### Resposta

```tex
arr[] = [-10, 30, 1024, -33, 0]

f = 2 GHz
CPI_{CPU} = 2
mr_{instruções} = 3%
mr_{dados} = 5%
T_{exec} = 150 ns

mp = ?


```

## 6

> O excerto de código abaixo calcula a soma de todos os elementos de uma matriz de inteiros. A matriz tem ALTURA * LARGURA elementos.

```c
for (col=0; col<LARGURA ; col++) {
    for (lin=0; lin<ALTURA ; lin++) {
        soma += matriz[lin*LARGURA+col];
    }
}
```

> Reescreva  o  programa  para  que  seja  possível  explorar  de forma  mais  eficaz  a  hierarquia  da memória, justificando a sua resposta.

###### Resposta

```c
for (col=0; col<LARGURA ; ++col) {
    int linLARG = lin*LARGURA;
    for (lin=0; lin<ALTURA ; ++lin) {
        soma += matriz[linLARG+col];
    }
}
```

```
Guardar numa variável o calculo lin*LARGURA, pois o mesmo é repetido em todos os ciclos do for interior.
Desta forma a memoria é mais eficiente, diminuindo a miss rate de dados e as operações aritméticas que tem de ser executadas.
```