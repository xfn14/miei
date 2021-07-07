#include <stdio.h>
#include <stdlib.h>

/**
 * @brief Calcular tamanho de uma string
 * 
 * @param s1 string para calcular tamanho
 * @return tamanho da string
 */
int strlen(char s1[]){
    int i;
    for(i = 0; s1[i]; i++)
    return i;
}

/**
 * @brief Pergunta 19
 * 
 * @param s1 string do sufixo
 * @param s2 string do prefixo
 * @return tamanho do maior sufixo/prefixo
 */
int sufPref (char s1[], char s2[]){
    int i, j, s1_len = strlen(s1), res = 0;
    for(i = 0; s1[i]; i++){
        int temp = i, counter = 0;
        for(j = 0; s2[j]; j++){
            if(s1[temp] == s2[j]) counter++;
            else break;
        }
        if(counter == (s1_len - i))
            res = counter;
    }
    return res;
}

int contaPal (char s[]){
    int isWord = 0, ans = 1;

    while(*s){
        if (!isWord && *s == ' ')s++;
        else if (isWord && *s == ' '){ans++;s++;isWord = 0;}
        else {isWord = 1;s++;}
    }
    return ans;
}

int contaPal(char s[]){
    char res[1000];
    int i, j = 0, flag = 0;
    for(i = 0; s[i]; i++){
        if(s[i] != ' '){
            res[j++] = s[i];
            flag = 0;
        } 
        else{
            if(flag == 1) continue;
            else flag = 1;
        }
    }
    int counter = 0;
    for(int w = 0; strlen(res); w++)
        if(res[w] == ' ') counter++;
    return counter;
}

typedef struct posicao {
    int x, y;
} Posicao;

// 50
int vizinhos(Posicao p, Posicao pos[], int N){
    int i, res = 0;
    for(i = 0; i < N; ++i){
        Posicao crt = pos[i];
        int difX = abs(crt.x - p.x);
        int difY = abs(crt.y - p.y);
        if(difX + difY == 1) res++;
    }
    return res;
}

typedef struct lligada {
    int valor;
    struct lligada *prox;
} *LInt;

// 51
int length(LInt list){
    int len = 0;
    while(list){
        len++;
        list = list->prox;
    }
    return len;
}

// 52
void freeL(LInt list){
    LInt temp;
    while(list){
        temp = list->prox;
        free(list);
        list = temp;
    }
}
