#include <stdio.h>

void imprime_triangulo(int num_linhas);
void print_space(int n);
void print_char_fst(int n);
void print_char_snd(int n);

void imprime_losango(int dim);

void hexagono_base(int num);
void hexagono_line(int line, int max);
void print_space_hex(int n);
void imprime_hexagono(int num);

int main() {
    imprime_triangulo(5);
    imprime_losango(5);
    imprime_hexagono(3);
    return 0;
}

void print_space(int n){
    while(n != 0){
        putchar(' ');
        putchar(' ');
        n--;
    }
}

void print_char_fst(int n){
    char chr = 'A';
    while(n != 0){
        putchar(chr);
        putchar(' ');
        n--; chr++;
    }
}

void print_char_snd(int n){
    char chr = 'A' + n;
    while((n - 1) != 0){
        putchar(chr);
        putchar(' ');
        n--; chr--;
    }
}

void imprime_triangulo(int num_linhas){
    int line = 1;
    while((line - 1) != num_linhas){
        print_space(num_linhas-line);
        print_char_fst(line);
        print_char_snd(line);
        putchar('\n');
        line++;
    }
}

void imprime_losango(int dim){
    imprime_triangulo(dim);
    int line = dim-1;
    while (line != 0){
        print_space(dim-line);
        print_char_fst(line);
        print_char_snd(line);
        putchar('\n');
        line--;
    }
}

void print_space_hex(int n){
    while(n != 0){
        putchar(' ');
        n--;
    }
}

void hexagono_base(int num){
    print_space_hex(num-1);
    while(num != 0){
        putchar('#');
        num--;
    }
}

void hexagono_line(int line, int max){
    print_space_hex(max-line);
    putchar('#');
    print_space_hex(max+(line-1)*2);
    putchar('#');
    putchar('\n');
}

void imprime_hexagono(int num){
    hexagono_base(num);
    int line = 1;
    while((line-1) != num){
        hexagono_line(line, num);
        line++;
    }
    line--;
    while(line != 0){
        hexagono_line(line, num);
        line--;
    }
    hexagono_base(num);
}