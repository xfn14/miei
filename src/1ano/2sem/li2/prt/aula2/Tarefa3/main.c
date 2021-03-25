#include <stdio.h>
#include <stdlib.h>

void geraQuestao();

// Sair da aplicaçao
__int8 quit = 0;

// Mensagens para caso a resposta seja correta
char rspCorreta[3][20] =
        {
            "Otimo!\n",
            "Belo trabalho!\n",
            "Continue assim!\n"
        };

// Mensagens para caso a resposta seja errada
char rspErrada[3][30] =
        {
            "Errado, tente novamente.\n",
            "Nao desista!\n",
            "Nao, tente mais uma vez\n"
        };

int main() {
    printf("Para sair do programa introduza -1\n");
    while(quit != -1){
        geraQuestao();
    }

    return 0;
}

void geraQuestao(){
    // Gerar dois números aleatórios entre 0 e 9
    int x = rand() % 10;
    int y = rand() % 10;

    // Impedir que haja 0 como numero.
    if(x == 0) x++;
    if(y == 0) y++;

    // Valor de resposta introduzido pelo usuário
    int rsp;

    // Inicializar a pergunta.
    printf("Quanto e %d vezes %d?\n", x ,y);
    scanf("%d", &rsp);

    // Usuário pode continuar a tentar até acertar a pergunta.
    while(rsp != (x*y)){
        // Sair do programa
        if(rsp == -1){
            quit = -1;
            break;
        }

        // Mensagem de resposta errada
        printf(rspErrada[rand() % 3]);
        scanf("%d", &rsp);
    }

    // Mensagem de resposta correta
    if(rsp != -1){
        printf(rspCorreta[rand() % 3]);
    }
}