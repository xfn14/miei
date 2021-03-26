#include "data.h"
#include "estado.h"
#include "lista.h"
#include "jogada.h"
#include "stdio.h"
#include "stdlib.h"
#include <string.h>
#include "math.h"
#include "data.h"

void jog(ESTADO *estado);
LISTA jogadasProximas(ESTADO *e, LISTA L);
float distancia_eucladiana(COORDENADA coord1, COORDENADA coord2);
void ler(char *file_name, ESTADO *estado);
void gr(char *file_name, ESTADO *estado);

int main(int nr, char **args){
    ESTADO *estado = inicializar_estado();
    if(nr == 3){
        char *old = args[1];
        char *new = args[2];
        ler(old, estado);
        jog(estado);
        gr(new, estado);
    }else{
        printf("Uso %s <tabuleiro a ler> <tabuleiro a escrever>\n", args[0]);
    }
    return 0;
}

void jog(ESTADO *estado){
    COORDENADA pos1, pos2, *atual, best;
    float bestDist;
    bestDist = 100;
    LISTA lista = criar_lista();

    pos1.coluna = 7;
    pos1.linha = 0;

    pos2.coluna = 0;
    pos2.linha = 7;

    lista = jogadasProximas(estado, lista);

    while(!lista_esta_vazia(lista)){
        atual = (COORDENADA *) devolve_cabeca(lista);
        if(obter_jogador_atual(estado) == 1){
            if(estado->tab[atual->linha][atual->coluna] == POS1){
                best = *atual;
                break;
            }
            if(distancia_eucladiana(*atual,pos1) < bestDist){
                bestDist = distancia_eucladiana(*atual,pos1);
                best = *atual;
            }
        }else{
            if(estado->tab[atual->linha][atual->coluna] == POS2){
                best = *atual;
                break;
            }
            if(distancia_eucladiana(*atual,pos2) < bestDist){
                bestDist = distancia_eucladiana(*atual,pos2);
                best.linha = atual->linha;
                best.coluna = atual->coluna;
            }
        }
        lista = proximo(lista);
    }

    jogar(estado, best);

    free(lista);
}

LISTA jogadasProximas(ESTADO *e, LISTA L){
    COORDENADA *atual;

    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
            atual = malloc(sizeof(COORDENADA));
            atual->linha = i;
            atual->coluna = j;

            int valida = jogada_valida(e, *atual);
            if(valida == 1 || valida == 2 || valida == 3){
                if((e->jogador_atual == 1 && e->tab[i][j] == POS1) || (e->jogador_atual == 2 && e->tab[i][j] == POS2)){
                    LISTA t = malloc(sizeof(NODO));
                    t->valor = atual;
                    t->proximo = NULL;
                    return t;
                }

                if (e->tab[i][j] == VAZIO){
                    L = insere_cabeca(L, atual);
                }
            }
        }
    }
    L->proximo = NULL;
    return L;
}

float distancia_eucladiana(COORDENADA coord1, COORDENADA coord2){
    return sqrtf(pow(coord1.linha - coord2.linha, 2) + pow(coord1.coluna - coord2.coluna, 2));
}

void gr(char *file_name, ESTADO *estado){
    FILE *file_p;
    file_p = fopen(file_name, "w");
    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
            CASA cs = estado->tab[i][j];
            if(cs == POS1) fprintf(file_p, "1");
            else if(cs == POS2) fprintf(file_p, "2");
            else if(cs == RASTRO) fprintf(file_p, "#");
            else if(cs == PECA) fprintf(file_p, "*");
            else if(cs == VAZIO) fprintf(file_p, ".");
        }
        fprintf(file_p, "\n");
    }

    fprintf(file_p, "\n");

    for(int i = 0; i < (obter_numero_de_jogadas(estado) + 1); i++){
        COORDENADA jogador1 = estado->jogadas[i].jogador1;
        COORDENADA jogador2 = estado->jogadas[i].jogador2;

        if(jogador1.linha != -1){
            if(i < 9){
                fprintf(file_p, "0%d: ", i+1);
            }else{
                fprintf(file_p, "%d: ", i+1);
            }

            char coluna = 'a' + jogador1.coluna;
            int linha = 8 - jogador1.linha;
            fprintf(file_p, "%c%d ", coluna, linha);
        }
        if(jogador2.linha != -1){
            char coluna = 'a' + jogador2.coluna;
            int linha = 8 - jogador2.linha;
            fprintf(file_p, "%c%d\n", coluna, linha);
        }
    }

    fclose(file_p);
}


void ler(char *file_name, ESTADO *estado){
    FILE *file_p;
    file_p = fopen(file_name, "r");
    char line[150];
    CASA tabuleiro[8][8];

    if(file_p == NULL){
        printf("Nome de ficheiro invalido\n");
        return;
    }

    resetJogadas(estado);
    estado->num_jogadas = 0;

    int linha = 0;
    while(1){
        for(int i = 0; i < 150; i++){
            line[i] = '\0';
        }
        if(fgets(line, 150, file_p) != NULL){
            if(linha < 8){
                for(int i = 0; i < 8; i++){
                    if(line[i] == '1') tabuleiro[linha][i] = POS1;
                    else if(line[i] == '2') tabuleiro[linha][i] = POS2;
                    else if(line[i] == '#') tabuleiro[linha][i] = RASTRO;
                    else if(line[i] == '*') tabuleiro[linha][i] = PECA;
                    else if(line[i] == '.') tabuleiro[linha][i] = VAZIO;
                }
            }else{
                if(strcmp(line, "\n") != 0){
                    COORDENADA jog1_coord;
                    jog1_coord.coluna = line[4] - 'a';
                    jog1_coord.linha = 7 - (line[5] - '1');

                    COORDENADA jog2_coord;
                    jog2_coord.coluna = line[7] - 'a';
                    jog2_coord.linha = 7 - (line[8] - '1');

                    if(0 <= jog1_coord.coluna && jog1_coord.coluna <= 7){
                        estado->jogador_atual = 1;
                        adicionar_jogada(estado, jog1_coord);
                        estado->jogador_atual = 2;
                    }

                    if(0 <= jog2_coord.coluna && jog2_coord.coluna <= 7){
                        estado->jogador_atual = 2;
                        adicionar_jogada(estado, jog2_coord);
                        estado->jogador_atual = 1;
                    }
                }
            }
        }
        //fgets(line, 150, file_p);

        if(feof(file_p)){
            break;
        }
        linha++;
    }

    setTabuleiro(estado, tabuleiro);
    estado->ultima_jogada = obter_coordenada_peca(tabuleiro);

    fclose(file_p);
}