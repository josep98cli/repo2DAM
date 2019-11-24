#include <stdio.h>
#include <iostream>

using namespace std;


bool esPositivo (int i){

    return i>=0;
}

void hazPositivo(int *p){
    
    int i  = *p;
    if (!esPositivo(i))
    {
        i = -i;
        *p = i;
        cout << "El valor de i es " << i << "\n -----------"<<endl;
    }
    
}

int main (int argc, char *argv[] ) {
  
   int i = 8;
   int * p;
   p= &i;
   *p=-10;
    cout << "El valor inicial de i es " << i << "\n-----------" <<endl;
    if (esPositivo(i))
    {
        cout << "i es positivo"<< "\n----------" <<endl;
    }else{
        hazPositivo(p);
    }
    
    if (!esPositivo(i))
    {
        cout << "Rayos, truenos y centellas\n -------------"<<endl;
    }
    
    cout << "i vale " << i << "\n ------------" <<endl;

    cout << "i esta en la posición " << p << " de ram" << "\n----------" << endl;
}
