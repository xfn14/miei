#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double areaTriangulo(int a, int b, int c);

int main() {

    // Variaveis que guardam os valores dos lados
    int a, b, c;

    // Receber valores dos lados do triangulo
    printf("Introduza os valores dos lados de um triangulo.\n");
    scanf("%d %d %d",&a,&b,&c);

    // Detetar se o triangulo é possível
    if (abs(b-c) < a && a < b+c){
        //Detetar tipo do triangulo
        char *tipo;
        if(a == b || a == c || b == c){
            if(a == b && b == c && c == a){
                tipo = "Equilatro";
            }else{
                tipo = "Isósceles";
            }
        }else{
            tipo = "Escaleno";
        }

        // Calcular area
        double area = areaTriangulo(a,b,c);
        printf("Triangulo %s\nArea do triangulo: %lf", tipo, area);
    }else {
        printf("Valores inválidos.");
    }
    return 0;
}

double areaTriangulo(int a, int b, int c){
    double s = (double) (a + b + c) / 2;
    double area = sqrt(s * (s-a) * (s-b) * (s-c));
    return area;
}