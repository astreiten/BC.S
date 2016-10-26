#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[])//
{
    if (argc > 1) { //Fue llamado desde consola con argumentos
        int solicitudAyuda = !strcmp(argv[1],"-h"); //1 si se solicita, 0 caso contrario
        if (solicitudAyuda) {
            //mostrar texto de ayuda
            printf("entre a ayuda\n");
        }
        else if (argc > 3 && argc < 6) { //Se introdujeron archivos de entrada y salida
            int parametrosCorrectos = !strcmp(argv[1],"-i") && !strcmp(argv[3],"-o") && argv[2] != NULL && argv[4] != NULL;
            if (parametrosCorrectos) {
                printf("entre a archivo de entrada y salida\n");
            }
            else { //parametros erroneos
                //mostrar mensaje de error y texto de ayuda
                printf("1parametro erroneo\n");
            }
        }
        else if (argc < 4) { //Se introdujo archivo de entrada o de salida
            if (!strcmp(argv[1],"-o") && argv[2] != NULL) { //Se introdujo archivo de salida
                printf("entre a archivo de salida\n");
            }
            else if (!strcmp(argv[1],"-i") && argv[2] != NULL){ //Se introdujo archivo de entrada
                printf("entre a archivo de entrada\n");
            }
            else { //parametro erroneo
                //mostrar mensaje de error y texto de ayuda
                printf("2parametro erroneo\n");
            }
        }
        else { //parametros mayores a 6, error
            //mostrar mensaje de error y texto de ayuda
            printf("3parametro erroneo\n");
        }
    }
    else {
        printf("no entre por consola\n");
        evaluar();
    }

    return 0;
}
