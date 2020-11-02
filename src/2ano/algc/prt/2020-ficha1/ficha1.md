# 2. Invariantes de ciclo

### 1.

###### Enunciado

```
P: x == x_0 >= 0 && y == y_0 > 0

    r = x;
    q = 0;
    while(y<=r){
        r = r-y;
        q = q+1;
    }

Q: 0 <= r < y_0 && q*y_0+r == x_0
```

###### Resposta

```
Inicializacao: 
    {x>=0 && y>0} r = x; q = 0 {I}
Preservacao: 
    {I && y<=r} r = r-y; q = q+1 {I}
Utilidade: 
    {I && y>r} => {0<=r<y_0 && q*y_0+r == x_0}
```

### 2.

###### Enunciado

```
P: n == n_0 > 0

    i = 1; r = 1; s = 0;
    while(i<n){
        r = r+s;
        s = r-s;
        i = i+1;
    }

Q: r == F(n_0)
```

###### Resposta

```
Inicializacao: 
    {n>0} i = 1; r = 1; s = 0 {I}
Preservacao: 
    {I && i<n} r = r+s; s = r-s; i = i+1; {I}
Utilidade: 
    {I && i>=n} => {r == F(n_0)}
```

### 3.

###### Enunciado

```
mdc(x,x) = x
mdc(x,y) = mdc(x+y,y) = mdc(x,x+y)

P: a == a_0 > 0 && b == b_0 > 0

    while(a!=b)
        if(a>b) a = a-b;
        else    b = b-a;

Q: a == mdc(a_0,b_0)

I: mdc(a,b) == mdc(a_0,b_0)
```

###### Reposta
<!-- TODO Add correcao total -->
```
Inicializacao: 
    {a>0 && b>0} => {mdc(a,b) == mdc(a_0,b_0)}
Preservacao: 
    {mdc(a,b) == mdc(a_0,b_0) && a!=b}
Utilidade:
    1. {mdc(a,b) == mdc(a_0,b_0) && a==b && a>b} => {mdc(a-b,b) == mdc(a_0,b_0)}
    2. {mdc(a,b) == mdc(a_0,b_0) && a==b && a<=b} => {mdc(a,b-a) == mdc(a_0,b_0)}
```

# 3. Determinacao de invariantes de ciclo

### 1

```
P: N >= 0 && (forall 0 <=i < N, A[i] == a_i)
Q: s == (sum (i=0) (N-1) (a_i))
```

### 1.(a)

###### Enunciado

```
s = 0; p = 0;
while(p<N){
    s = s+A[p];
    p = p+1;
}
```

###### Resposta

```
Inicializacao: 
    {N >= 0 && (forall 0 <=i < N, A[i] == a_i)} s = 0; p = 0 {I}
Preservacao: 
    {I && p<N} s = s+A[p]; p = p+1 {I}
Utilidade: 
    {I && p>=N} => {s == (sum (i=0) (N-1) (a_i))}
```

```
A[p] = {1,2,3,4}
```

| s | p | N |
|:-:|:-:|:-:|
| 0 | 0 | 4 |
| 1 | 1 | 4 |
| 3 | 2 | 4 |
| 6 | 3 | 4 |
|10 | 4 | 4 |   

```
I: s = sum (i=0) (p-1) (a_i) && p <= N
```

### 1.(b)

###### Enunciado

```
s = 0; p = N;
while(p>0){
    p = p-1;
    s = s+A[p];
}
```

###### Resposta

```
Inicializacao: 
    {N >= 0 && (forall 0 <=i < N, A[i] == a_i)} s = 0; p = N {I}
Preservacao: 
    {I && p>0} p = p-1; s = s+A[p]; {I}
Utilidade: 
    {I && p<=0} => {s == (sum (i=0) (N-1) (a_i))}
```

```
A[p] = {1,2,3,4}
```

| s | p | N |
|:-:|:-:|:-:|
| 0 | 0 | 4 |
| 1 | 1 | 4 |
| 3 | 2 | 4 |
| 6 | 3 | 4 |
|10 | 4 | 4 |   

```
I: s = sum (i=0) (p-1) (a_i) && 0 <= p <= N
```