#include <stdio.h>
#include <stdlib.h>
#include "api.h"

int arr[4000];

int main(){
    fill(arr, 4000, 5);
    // fill(&arr[1000], 300, 8); // 1000 - 1300
    find(arr, 4000, 8);

    for(int i = 950; i < 1350; ++i)
        printf("arr[%d] = %d\n", i, arr[i]);

    return 0;
}