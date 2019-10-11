#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

class Complejo{
    public:
    float p_real;
    float p_imag;
    Complejo(){
    }

    string toString(){
        stringstream ss;
        ss << "(" << p_real<<","<< p_imag<<")";
        return ss.str();
    }

    Complejo (float r, float i){
        p_real = r;
        p_imag = i;
    }
};

Complejo operator+ (Complejo primero, Complejo segundo){
    
    Complejo resultado ;

    resultado.p_imag=primero.p_imag+segundo.p_imag;
    resultado.p_real=primero.p_real+segundo.p_real;

    return resultado;
}   

int main(int argc, char *argv[]){
    
    Complejo a(-2,8);
    Complejo b(2,4);
    Complejo c;

    c = a + b;
       
    cout << c.toString()<<endl;
}