#include "file.h"

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
        //fgets(line, 150, file_p);

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

                    //printf("1: %c %c\n", line[4], line[5]);
                    //printf("1: %d %d\n", jog1_coord.coluna, jog1_coord.linha);

                    COORDENADA jog2_coord;
                    jog2_coord.coluna = line[7] - 'a';
                    jog2_coord.linha = 7 - (line[8] - '1');

                    //printf("2: %c %c\n", line[7], line[8]);
                    //printf("2: %d %d\n", jog2_coord.coluna, jog2_coord.linha);

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

        if(feof(file_p)){
            break;
        }
        linha++;
    }

    setTabuleiro(estado, tabuleiro);
    estado->ultima_jogada = obter_coordenada_peca(tabuleiro);

    // FIX Bug de linha no ficheiro
    /*if(obter_jogador_atual(estado) == 1){
        COORDENADA nula;
        nula.linha = -1;
        nula.coluna = -1;

        estado->num_jogadas = estado->num_jogadas-1;

        estado->jogadas[obter_numero_de_jogadas(estado)].jogador1 = nula;
        estado->jogadas[obter_numero_de_jogadas(estado)].jogador2 = nula;
    }*/
    ////////////////////////////////////////////////

    /*if (obter_jogador_atual(estado) != 1) {
        estado->jogador_atual = 1;
    } else {
        estado->jogador_atual = 2;
        estado->num_jogadas = obter_numero_de_jogadas(estado) - 1;
    }

    COORDENADA nula;
    nula.linha = -1;
    nula.coluna = -1;

    if(obter_jogador_atual(estado) == 1){
        estado->jogadas[obter_numero_de_jogadas(estado)].jogador1 = nula;
    }else{
        estado->jogadas[obter_numero_de_jogadas(estado)].jogador2 = nula;
    }*/

    mostrar_tabuleiro(estado);
    //printf("\n%d %d", estado->ultima_jogada.coluna, estado->ultima_jogada.linha);

    fclose(file_p);
}