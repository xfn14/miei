#include "jogada.h"

int jogar(ESTADO *estado, COORDENADA coord){

    int validar = jogada_valida(estado, coord);
    if(validar == 1 || validar == 2 || validar == 3) {
        COORDENADA ultima_jogada = obter_ultima_jogada(estado);
        estado->tab[obter_linha_coord(coord)][obter_coluna_coord(coord)] = PECA;
        estado->tab[obter_linha_coord(ultima_jogada)][obter_coluna_coord(ultima_jogada)] = RASTRO;
        estado->ultima_jogada = coord;

        // Adicionar jogada ao array de jogadas
        adicionar_jogada(estado, coord);

        if(obter_jogador_atual(estado) == 1){
            estado->jogador_atual = 2;
        }else{
            estado->jogador_atual = 1;
        }

        putchar('\n');

        if(validar == 1 || validar == 2){
            printf("\nJogador %d vence.", validar);
        }
        return 1;
    }else{
        printf("Jogada invalida.\n");
    }
    return 0;
}

int jogada_valida(ESTADO *estado, COORDENADA coord){
    COORDENADA ultima_jogada = obter_ultima_jogada(estado);
    int x1 = obter_coluna_coord(ultima_jogada), y1 = obter_linha_coord(ultima_jogada);
    int x2 = obter_coluna_coord(coord), y2 = obter_linha_coord(coord);

    // Validar casas em volta da PECA
    if(((x1 == x2) && (((abs(y1-y2))==1))) // Cima e baixo
       || (((abs(x2-x1))==1) && ((abs(y2-y1))==1 || y2 == y1 ))) // Esquerda e Direita
    {
        CASA casa_coord = obter_estado_casa(estado, coord);
        if(casa_coord == RASTRO) return 0;

        // Tabuleiro com a jogada efetuada
        CASA new_tab[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                COORDENADA new;
                new.linha = i;
                new.coluna = j;
                new_tab[i][j] = obter_estado_casa(estado, new);
            }
        }

        new_tab[coord.linha][coord.coluna] = PECA;
        new_tab[obter_linha_coord(ultima_jogada)][obter_coluna_coord(ultima_jogada)] = RASTRO;

        if((new_tab[abs(coord.linha-1)][abs(coord.coluna-1)] == RASTRO)
        && (new_tab[abs(coord.linha-1)][abs(coord.coluna)] == RASTRO)
        && (new_tab[abs(coord.linha-1)][abs(coord.coluna+1)] == RASTRO)
        && (new_tab[abs(coord.linha+1)][abs(coord.coluna-1)] == RASTRO)
        && (new_tab[abs(coord.linha+1)][abs(coord.coluna)] == RASTRO)
        && (new_tab[abs(coord.linha+1)][abs(coord.coluna+1)] == RASTRO)
        && (new_tab[abs(coord.linha)][abs(coord.coluna+1)] == RASTRO)
        && (new_tab[abs(coord.linha)][abs(coord.coluna-1)] == RASTRO)){
            return obter_jogador_atual(estado);
        }

         if(casa_coord == POS1) {
             return 1;
         }else if(casa_coord == POS2){
             return 2;
         }
         return 3;
    }
    return 0;
}

void adicionar_jogada(ESTADO *estado, COORDENADA coord){
    if(obter_jogador_atual(estado) == 1){
        JOGADA jog;
        jog.jogador1 = coord;

        COORDENADA nula;
        nula.linha = -1;
        nula.coluna = -1;
        jog.jogador2 = nula;

        estado->jogadas[obter_numero_de_jogadas(estado)] = jog;
    }else{
        JOGADA jog = estado->jogadas[obter_numero_de_jogadas(estado)];
        jog.jogador2 = coord;
        estado->jogadas[obter_numero_de_jogadas(estado)] = jog;
        estado->num_jogadas = obter_numero_de_jogadas(estado) + 1;
    }
}