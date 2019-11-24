#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

void exemplefork()
{
	int x = 1;
	printf("Inici del programa-----------");
	std::cout<<"PID actual: "<<getpid()<<std::endl;
	int comptador = 0;
	pit_t pid = fork();
	if(pid==0){
		std::cout<<"PID actual fill: "<<getpid()<<std::endl;
		
		for (int i = 0; i < 5; i++)
		{
			printf("Sóc el procés fill x= %d\n",++comptador);
		}
		
	} else if(pid > 0){
		std::cout<<"PID actual pare: "<<getpid()<<std::endl;
		
		for (int i = 0; i < 5; i++)
		{
			printf("Sóc el procés pare x= %d\n",++comptador);
		}
		
	}else{
		printf("El fork ha fallat");
	}
}

int main()
{
	exemplefork();
	return 0;
}
