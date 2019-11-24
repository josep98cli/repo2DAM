#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <sstream>
#include <math.h>

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

    Complejo operator+ ( Complejo segundo){
    
    Complejo resultado ;

    resultado.p_imag=p_imag+segundo.p_imag;
    resultado.p_real=p_real+segundo.p_real;

    return resultado;
    }   

    Complejo operator - (Complejo segundo){
    return Complejo(p_real-segundo.p_real, p_imag-segundo.p_imag);  
    }   

    Complejo operator-(){
        p_real= -p_real;
        p_imag = -p_imag;
    }

    void operator+=(Complejo segundo){
        p_imag = p_imag + segundo.p_imag;
        p_real = p_real + segundo.p_real;
    }

    float modulo(){
        
        float suma = (p_real*p_real)+ (p_imag*p_imag);
        float resultado = sqrt(suma);
        return resultado;
    }

    bool operator>(Complejo c){
        return modulo() > c.modulo();
    }
    bool operator<(Complejo c){
        return !((*this)>c);
    }

};

    

//operator<<(Cuenta & receptora, Cuenta & dadora){}

int main(int argc, char *argv[]){
    
    Complejo a(-2,8);
    Complejo b(3,5);
    Complejo c(4,-3);

        cout << a.modulo()<<endl;
   
}