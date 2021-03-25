#include "data.h"
#include "estado.h"
#include "interpretador.h"
#include "tabuleiro.h"

int main() {
    ESTADO *estado = inicializar_estado();
    mostrar_tabuleiro(estado);
    while(quit == 0){
        interpretador(estado);
    }
    return 0;
}