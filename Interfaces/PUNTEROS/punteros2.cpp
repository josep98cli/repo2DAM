#include <stdio.h> 
#include <iostream>

using namespace std;

int * maximo(int * a, int * b) {

    if ( * a > * b) {
        return a;
    }

    return b;

}
int main(int argc, char * argv[]) {

    int a = 10;
    int b = 5;

    cout <<  "a vale " << a << endl;
    cout <<  "b vale " << b << endl;

    *maximo(& a, & b) = 0;

    cout <<  "a vale " << a << endl;
    cout <<  "b vale " << b << endl;
}

