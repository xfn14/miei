#include <stdio.h>

float ex1(int n, float m);
float ex2(int n, float m);
int ex3(int a, int b);

int main(){
    printf("ex1: %f\n", ex1(81, 423));
    printf("ex2: %f\n", ex2(81, 423));
    printf("ex3: %d\n", ex3(81, 423));
}

float ex1(int n, float m){
    int i;
    float r = 0;
    for(i = 0; i < n; ++i)
        r += m;
    return r;
}

float ex2(int n, float m){
    int i, n_i = n;
    float m_i = m, res = 0;
    for(i = 0; n_i >= 1; ++i){
        // printf("%d %f\n", n_i, m_i);
        if(n_i % 2 != 0) res += m_i;
        n_i /= 2;
        m_i *= 2;
    }
    return res;
}

int ex3(int a, int b){
    int menor = a < b ? a : b, maior = a > b ? a : b;
}
