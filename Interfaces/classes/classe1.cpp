#include <iostream>
using namespace std;

class Cuenta {
public:
    string titular;
    string numCuenta;
    float saldo;
};

void mostrar(Cuenta c){

    cout <<"Cuenta: " << c.numCuenta << ", titular: " << c.titular << ", saldo: "<< c.saldo <<endl;

} //mostrar cuenta por pantalla


void ingresar(Cuenta &c, float ingreso){
    if (ingreso<0) return;
    
      c.saldo+=ingreso;
} // ingreso de dinero.


bool reintegro(Cuenta &c, float reintegro){

    if (reintegro<c.saldo) return false;
    c.saldo-=
    c.saldo-=reintegro;
    return true;

}//realizar un reintegro



int main(int argc, char *argv[]) {

cout << "bienvenido al banco" <<endl;

    Cuenta *c = new Cuenta();
    c->titular = "pepe";
    c->numCuenta ="001";
    c->saldo = 10.04 ;

    float ingreso =39.02;

    mostrar(*c);
    ingresar(*c, ingreso);
    mostrar(*c);
    if (reintegro(*c, 2000))
    {
        /* code */
    }
    
}

