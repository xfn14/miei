# TPC 9

## Exercício 1)

```c
int soma_grandes(int n, int * a){
    int r = 0, i;
    for(i = 0; i < n; ++i)
        if(a[i] > 1000)
            r += a[i];
    return r;
}
```

## Exercício 2)

### Exerício 2.a)

VAariável Registo Comentario
a | %ebx | registo callee saved
n | %esi | registo callee saved
r | %eax |
i | %ecx |
a[i] | %edx | 

### Exerício 2.b)

```
                -->     conteudo do registo %esi
                -->     conteudo do registo %ebx
fp: (%ebp)      -->        
%ebp+4          -->      return address
%ebp+8          -->          arg n
%ebp+12         -->          arg a   
```

### Exercício 2.c)

```s
soma_grandes:
    pushl   %ebp
    movl    %esp, %ebp

    push    %ebx                    # salvaguarda de registo
    push    %esi                    # salvaguarda de registo

    movl    8(%ebp),  %esi          # %esi = n
    movl    12(%ebp), %ebx          # %ebx = a

    xorl    %ecx, %ecx              # i = 0
    xorl    %eax, %eax              # r = 0

TESTE_FOR:
    cmpl    %ecx, %esi              # n - i      (Teste para o fim de ciclo)
    jle     FIM_CICLO               # se (n-i) <= 0

    movl    (%ebx, %ecx, 4), %edx   # edx = a[i]
    cmpl    $1000, %edx             # %edx - 1000   (a[i] > 1000)
    jle     FIM_IF
    addl    %edx, %eax              # r += a[i]

FIM_IF:
    incl    %eax                    # i++
    jmp     TESTE_FOR

FIM_CICLO:
    pop     %esi
    pop     %ebx
    leave
    ret
```
