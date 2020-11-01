# Invariantes de ciclo

### 1.

###### Enunciado

```
P: x == x0 >= 0 && y == y0 > 0

    r = x;
    q = 0;
    while(y<=r){
        r = r-y;
        q = q+1;
    }

Q: 0 <= r < y0 && q*y0+r == x0
```

###### Resposta

```
Inicializacao: {x>=0 && y>0} r = x; q = 0 {I}
Preservacao: {I && y<=r} r = r-y; q = q+1 {I}
Utilidade: {I && y>r} => {0<=r<y0 && q*y0+r == x0}
```

### 2.

###### Enunciado

```
P: n == n0 > 0

    i = 1; r = 1; s = 0;
    while(i<n){
        r = r+s;
        s = r-s;
        i = i+1;
    }

Q: r == F(n0)
```

###### Resposta

```
Inicializacao: {n>0} i = 1; r = 1; s = 0 {I}
Preservacao: {I && i<n} r = r+s; s = r-s; i = i+1; {I}
Utilidade: {I && i>=n} => {r == F(n0)}
```
