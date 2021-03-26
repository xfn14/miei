/*
* AUTHOR : Tiago "Shiiva" Daniel
*/

#include <stdio.h>
#include <stdlib.h>

int bitsUm (unsigned int n){
    int res = 0;
    

    while (n>0){
        if (n%2 != 0) res++;
        n/=2;
    }

    return res;

}

int trailingZ (unsigned int n){
    int num = 0;

    while (n > 0) {
        if (n%2 == 0) num++;
        else if (n%2 == 1) break;
        n /= 2;
    }

    return num;
    

}

int qDig (unsigned int n){
   if (n == 0) return 0;
   else return 1 + qDig(n/10);
}

int mystrlength (char *str){
    int i;
    for (i= 0; str[i]!='\0'; ++i);
    
    return i;
}

char *mystrcat (char s1[], char s2[]){
    int len1, i, j;

    len1 =mystrlength(s1);
    for (i = len1, j = 0; s2[j]!='\0';++i)
        s1[i]= s2[j++];
    
    return s1;

}

char *mystrcpy (char *dest, char source[]){

   char * result = dest;
   while ((*dest = *source)!='\0'){++source; ++dest;}
   return result;

}



int mystrcmp (char s1[], char s2[]){

    while (*s1 == *s2 && *s1) {s1++;s2++;}
    return *s1 -*s2;
}

char *mystrstr(char s1[], char s2[]){

    char *principal = s1;
    char *pointer = s2;
    int flag = 1; 

    while (*s1 && *s2){

        if(*s1 != *s2){
            flag = 0;
            s2 = pointer;
        }
        if (*s1 == *s2){
            if(!flag){
                flag = 1;
                principal = s1;
            }
            s2++;
        }
        s1++;
    }
    if(flag && !(*s2))return principal;
    else return NULL;
}

void mystrrev (char *s){

    int i, j, len;
    len = mystrlength(s);
    char normal[len];
    
    for (i = 0; s[i]; ++i)normal[i] =s[i];
    for(j = 0; j < i; ++j)s[j] = normal[len-j-1];
    s[j] = '\0';
    
}

void step (char *s){

    for ( ;*s; ++s)*s = *(s+1);
}

void strnoV (char *s){
    while (*s){
        if (*s == 'A' || *s == 'E' || *s == 'I' || *s == 'O' || *s == 'U' || *s == 'a'
        || *s == 'e' || *s == 'i' || *s == 'o' || *s == 'u')step(s);
        else s++;        
    }
}

void truncW (char t[], int n){
    int len = 0;

    while (*t){
        if (*t == ' ' || *t == '\n'){t++; len = 0;}
        else{
            if (len++ >= n)step(t);
            else t++;
        }        
    }
}

char charMaisfreq(char s[]){

    int freq = 0, max = 0, i, j;
    char charmax ='\0';

    for (i = 0; s[i]; ++i)
        for(j = 0; s[j]; ++j){
            if (s[i] == s[j])freq++;
            if (freq > max) {max = freq; charmax = s[i];}
        }
    
    return charmax;
}

int iguaisConsecutivos(char s[]){

    int max = 0, consecu = 1, i;

    for (i=0; s[i]; ++i){
        if(s[i] == s[i+1])consecu++;
        else{
            if (consecu>max)max = consecu;
            consecu = 1;
        }
    }
    return max;

}

int difConsecutivos (char s[]){

    int max = 0, i, difs =1;

    for (i=0 ; s[i]; ++i){
        if (s[i]!=s[i+1])difs++;
        else{
            if (difs>max)max = difs;
            difs=1;
        }
    }
    return max;

}

int maiorPrefixo (char *s1, char s2[]){
    int i = 0;
    while (*s1){
        if (*s1 == *s2)i++;
        s1++;s2++;
    }

    return i;
}


int maiorSufixo(char s1[], char s2[]){
    int len = mystrlength(s1) -1 ;
    int len2 = mystrlength(s2) - 1;
    int i,res=0;
    for (i = len ;s1[i] == s2[len2];i--,len2-- )res++;

    return res;
}

int sufPref (char s1[], char s2[]){

    int ans = 0;

    while(*s1){
        if(*s1 == *s2){ ans++;++s1;++s2;}
        else ++s1;
    }

    return ans;
}

int contaPal (char s[]){

    int isWord = 0, ans = 1;

    while(*s){
        if (!isWord && *s == ' ')s++;
        else if (isWord && *s == ' '){ans++;s++;isWord = 0;}
        else {isWord = 1;s++;}
    }
    return ans;
}

int contida (char a[], char b[]){

    int ans = 0,i,j;

    for (i = 0; a[i]; ++i){
        ans = 0;
        for(j=0; b[j]; ++j)
            if (a[i] == b[j])ans = 1;
        if (ans == 0)return 0;
    }

    return ans;

}
int palindrome (char s[]){

    int len = mystrlength(s), i;
    for (i = 0; s[i]; ++i)if(s[i] != s[len-i-1])return -1;

    return 0 ;
}

int remRep (char x[]){

    int len = mystrlength(x);
    int i = 0;

    while (i< len -1 && x[i]){
        if (x[i] == x[i+1]){
            step(x);
            len -= 1;
        }else
        x++;
    }

    return len;
}

int limpaEspacos (char t[]){

    while (*(t+1)!= '\0'){
        if (*t == ' ' && *(t+1) == ' ')step(t);
        else t++;
    }
    
}

void insere (int v[], int N, int x) {
    for(int i = 0; i < N; i++) {
        if(v[i] > x) {
            for(int j = N; j > i; j--) {
                v[j] = v[j - 1];
            }
            v[i] = x;
            break;
        }
        if(i == N - 1) {
            v[N] = x;
        }
    }
}

void merge (int r[], int a[], int b[], int na, int nb){

    int i,j,k;
    i=j=k=0;

    while(i < na && j <nb){
        if(a[i] < b[j])r[k++] = a[i++];
        else r[k++] = b[j++];
    }
    for (;i<na;++i) r[k++] = a[i];
    for(;j<nb;++j)r[k++] = b[j];


}

int crescente (int a[], int i, int j){


    for (int k = i; k <j -1; k++){
        if (a[k] > a[k+1])return 0;

    }
    return 1;
}

int retiraNeg (int v[], int N){

    int i;

    for (i=0; i <N; ++i){
        if(v[i]<0){
            for (int j=i; j<N-1; ++j)
                v[j] = v[j+1];
            N--;i--;
        }

    }

    return N;
}
int menosFreq (int v[], int N){

    int freq = 1, minFreq = N, i, ans = v[0];

    for (i = 0; i < N - 1; ++i){
        if (v[i] == v[i + 1])freq++;
        else {
            if (freq < minFreq){
                minFreq = freq;
                ans = v[i];
            }
            freq = 1;
        }
    }
    if (freq < minFreq){
        minFreq = freq;
        ans = v[i];
    }
    
    return ans;
}

int maisFreq (int v[], int N){
    
    int freq = 1, maxFreq = 1, i ,ans = v[0];

    for ( i = 0; i < N - 1; ++i){
        if (v[i] == v[i+1])freq++;
        else {
            if ( freq > maxFreq){
                maxFreq = freq;
                ans = v[i];
            }
            freq = 1;
        }
    }
    if (freq > maxFreq){
        maxFreq = freq;
        ans = v[i];
    }

    return ans;
}

int maxCresc (int v[], int N){
    int max = 1, cres =1, i;

    for (i = 0; i < N - 1; ++i){
        if (v[i] < v[i+1])cres++;
        else {
            if (cres > max)max = cres;
            cres = 1;                
        }
    }
    if (cres > max)max = cres;

    return max;
}

int elimRep (int v[], int n){

    int i = 1, dup;

    while (i < n ){
        int dup = 0;
        for (int j = 0; j < i; ++j)
            if (v[i] == v[j])dup = 1;
        if (dup){
            for (int j = i ; j < n - 1; ++j)
                v[j] = v[j+1];
            n--;
        }else i++;

        
    }
    return n;
    

}

int comunsOrd (int a[], int na, int b[], int nb){

    int i = 0, j = 0, ans = 0;

    while (i < na && j <nb){
        if(a[i]==b[j]){
            ans++;i++;j++;
        }else if (a[i] < b[j])i++;
        else j++;
        
    }

    return ans;
}

int comuns (int a[], int na, int b[], int nb){
    int i, j , comuns =0;

    for (i = 0 ; i < na; ++i){
        for (j = 0 ; j <nb; ++j)
            if (a[i]==b[j])comuns++;
    }

    return comuns;
}

int minInd (int v[], int n){
    int min = v[0], ind = 0;

    for (int i = 1; i < n; ++i){
        if (v[i] < min){ min = v[i]; ind = i;}
    }

    return ind;
}

void somasAc (int v[], int Ac[], int N){
    int sum = 0;
    
    for (int i = 0; i < N; ++i){
        sum += v[i];
        Ac[i] = sum;
    }
}

int triSup (int N, float m [N][N]){
    int x = 1;
    for ( int i = 0; i < N; ++i)
        for (int j = 0; j < i; ++j)
            if(m[i][j]) x = 0;
    return x;
}

void transposta (int N, float m[N][N]) {
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < i; j++) {
            float temp = m[i][j];
            m[i][j] = m[j][i];
            m[j][i] = temp;
        }
    }
}

void addTo (int N, int M, int a [N][M], int b[N][M]){
    for (int i = 0 ; i <N; ++i){
        for (int j = 0 ; j < M; ++j)
            a[i][j]+=b[i][j];
    }
}

int unionSet (int N, int v1[N], int v2[N], int r[N]){

    int len = 0;

    for (int i = 0; i < N ; ++i){
        r[i] = v1[i] || v2[i];
        len+=r[i];
    }
}
int intersectMSet (int N, int v1[N], int v2[N],int r[N]) {
    int len = 0;
    for(int i = 0; i < N; i++) {
        r[i] = v1[i] < v2[i] ? v1[i] : v2[i];
        len += r[i]; 
    }
    return len;
}
int unionMSet (int N, int v1[N], int v2[N], int r[N]) {
    int len = 0;
    for(int i = 0; i < N; i++) {
        r[i] = v1[i] + v2[i];
        len += r[i]; 
    }
    return len;
}




int main (){

    int num = 48484;

    char str1 [40] ="braga" ;
    char str2 [15] ="bracarense";
    char x[15] = "  RR T     EEE    ";

    //int res = contida(str1,str2);

    int arr1[4] = {4,5,1,6};
    int arr2[2] = {5,6};
    int r[7];

   /* merge(r,arr1,arr2,4,3);
    for (int i = 0; i <7 ; i++){
        printf("%d\n",r[i]);
    }
    //printf("%d\n%s",limpaEspacos(x),x);
*/

   somasAc(arr1,r,4);
     for (int i = 0; i <4 ; i++)
        printf("%d\n",r[i]);

    
    
    return 0;
   
}
