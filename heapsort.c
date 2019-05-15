#include <stdio.h>

void swap(int *left, int *right) {
    int temp = *left;
    *left = *right;
    *right = temp;
}

void heaping(int data[], int n, int largest) {
    int originallargest = largest;
    int left = 2*largest + 1;
    int right = 2*largest + 2;

    if(left < n && data[left] > data[originallargest]) {
        originallargest = left;
    }

    if(right < n && data[right] > data[originallargest]) {
        originallargest = right;
    }

    if(originallargest != largest) {
        swap(&data[largest], &data[originallargest]); 

        heaping(data, n, originallargest);
    }
}

void heapsort(int data[], int n) {
    for(int i = n/2 - 1; i >= 0; i--) {
        heaping(data, n, i);
    }

    for(int i=n-1; i>=0; i--) {
        swap(&data[0], &data[i]);

        heaping(data, i, 0);
    }
}

int main() {
    int data[] = {1,9,2,8,3,7,4,6,5};

    heapsort(data, sizeof(data)/sizeof(data[0]));

    for(int i=0; i<9; i++) {
        printf("%d ", data[i]);
    }
    return 0;
}
