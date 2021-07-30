#include <stdio.h>
#include <stdlib.h>

// Heello Woorrld\0

int isVogal(char c){
    return c== 'A' || c== 'E' || c== 'I' || c== 'O' || c== 'U' || c== 'a' || c== 'e' || c== 'i' || c== 'o' || c== 'u';
}

int vogal(char * t){
    char * crt;
    int size = 0;

    while(*t){
        if(isVogal(*t) && *(t+1) == *t){
            crt = t;
            for(; *t; ++t) *t = *(t+1);
            t = crt;
        } ++t; ++size;
    } return size;
}

int valida(char s[]){
    int counter = 0;
    while(*s){
        if(48 <= *s && *s <= 57){
            if(48 <= *(s+1) && *(s+1) <= 57){ ++s; continue;}
            else if(*(s+1) != '(') return 0;
        }else if(*s == '(' && (48 > *(s-1) && *(s-1) > 57)) return 0;
         else if(*s == '(') counter++;
         else if(*s == ')'){
            if(counter > 0) counter--;
            else return 0;
        } ++s;
    } return counter == 0;
}

// ab2(c2(d))
// abc2(d)c2(d)c2(d)
// abcddcddcdd
// tentei :(
void descomprime(char i[], char o[]){
    if(!valida(i)) return;

    char * input = i;
    char * temp;
    int reps = 0;

    while(*input){
        if(48 <= *input && *i <= 57){
            reps += *i - 48;
            if(48 <= *(i+1) && *(i+1) <= 57) reps *= 10;
            else{
                temp = input+2;
                char * last = NULL;
                char * aux = input;
                while(*aux){
                    if(*aux == ')') last = aux;
                    aux++;
                }
                last--;

                int counter = 0;
                while(reps > 0){
                    while(temp != last){
                        *o = *(temp);
                        ++temp; ++o; ++counter;
                    }
                    reps--;
                }
                input = o-counter;
            }
        }else {
            *o = *(input);
            ++input; ++o;
        }
    }
}

int main(){
    char texto[20] = "Heeeeeello Woorrld";
    int size = vogal(texto);
    printf("%s\nsize = %d\n", texto, size);

    char texto1[20] = "ab3(c2(d))";
    char texto2[20] = "ab3(c2(d)";
    char texto3[20] = ")3(ab3(c2(d))";
    printf("Resultado: %d\n", valida(texto1));
    printf("Resultado: %d\n", valida(texto2));
    printf("Resultado: %d\n\n", valida(texto3));

    char out[1000] = "";
    descomprime(texto1, out);
    printf("%s\n%s\n", texto1, out);

    return 0;
}
