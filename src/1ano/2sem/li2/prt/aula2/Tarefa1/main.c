#include <stdio.h>
#include "indicadores.h"

int main() {
    // Definir variáveis
    float peso, altura, indice;

    // Definir valor do peso
    printf("Indique o seu peso (em Kg): ");
    scanf("%f", &peso);

    // Definir valor da altura
    printf("Indique a sua altura (em m): ");
    scanf("%f", &altura);

    indice = imc(peso, altura);
    printf("O valor do seu IMC é: %f\n", indice);
    return 0;
}