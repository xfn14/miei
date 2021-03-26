#include "interpretador.h"

int quit = 0;
int comandos = 0;

int interpretador(ESTADO *e) {
    char linha[BUF_SIZE];
    char col[2], lin[2];
    char file[16];
    int p;

    printf("%d PL%d (%d)>", comandos, obter_jogador_atual(e), obter_numero_de_jogadas(e) + 1);

    if(fgets(linha, BUF_SIZE, stdin) == NULL)
        return 0;

    comandos++;

    if(strlen(linha) == 2 && strcmp(linha,"Q\n") == 0){
        quit = 1;
        return -1;
    }

    if(sscanf(linha, "gr %s", file)){
        gr(file, e);
        return 2;
    }

    if(sscanf(linha, "ler %s", file)) {
        ler(file, e);
        return 3;
    }

    if(strlen(linha) == 5 && strcmp(linha,"movs\n") == 0){
        movs(e);
        return 4;
    }

    if((strlen(linha) == 6 || strlen(linha) == 7)
    && strstr(linha, "pos")){
        p = atoi(&linha[4]);
        pos(e, p);
        return 5;
    }

    if(strlen(linha) == 4 && strcmp(linha,"jog\n") == 0){
        jog(e);
        return 6;
    }

    if(strlen(linha) == 5 && strcmp(linha,"jog2\n") == 0){
        jog2(e);
        return 7;
    }

    if(strlen(linha) == 3 && sscanf(linha, "%[a-h]%[1-8]", col, lin) == 2){
        COORDENADA coord = {*col - 'a', *lin - '1'};
        coord.linha = 7-coord.linha;
        jogar(e, coord);
        return 1;
    }

    printf("Comando invalido.\n");
    return 0;
}
