cmake_minimum_required(VERSION 3.15)
project(Tarefa1 C)

set(CMAKE_C_STANDARD 99)

add_executable(${PROJECT_NAME} main.c indicadores.c indicadores.h)