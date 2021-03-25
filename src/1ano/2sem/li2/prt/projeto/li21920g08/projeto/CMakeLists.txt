cmake_minimum_required(VERSION 3.15)
project(src C)

set(CMAKE_C_STANDARD 99)
add_executable(src main.c jogada.c jogada.h tabuleiro.c tabuleiro.h data.h estado.c estado.h interpretador.c interpretador.h file.c file.h lista.c lista.h movs.c movs.h pos.c pos.h data.c)