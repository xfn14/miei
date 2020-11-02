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
| 0 | 4 | 4 |
| 4 | 3 | 4 |
| 7 | 2 | 4 |
| 9 | 1 | 4 |
|10 | 0 | 4 |

```
I: s = sum (i=p) (N-1) (a_i) && 0 <= p
```

### 2

```
P: x = x_0 && y = y_0 >= 0
Q: r = x_0*y_0
```

### 2.(a)

###### Enunciado

```
r = 0; i = 0;
while(i<y){
    r = r+x;
    i = i+1;
}
```

###### Resposta

```
Inicializacao: 
    {x = x_0 && y = y_0 >= 0} r = 0; i = 0 {I}
Preservacao: 
    {I && i<y} r = r+x; i = i+1 {I}
Utilidade: 
    {I && i>=} => {r = x_0*y_0}
```

```
x_0 = 2
y_0 = 5
```

| x | y | r | i |
|:-:|:-:|:-:|:-:|
| 2 | 5 | 0 | 0 |
| 2 | 5 | 2 | 1 |
| 2 | 5 | 4 | 2 |
| 2 | 5 | 6 | 3 |
| 2 | 5 | 8 | 4 |
| 2 | 5 |10 | 5 |

```
I: y == y_0 && i <= y && r = x_0 * i
```