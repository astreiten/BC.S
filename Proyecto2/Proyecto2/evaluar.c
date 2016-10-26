#include <stdio.h>
#include <stdlib.h>
#include "pila.h"
#include "lista.h"
#include "exits.h"
#include <limits.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
//Ulti
void mostrarAyuda() {
    FILE* ayuda;
    ayuda = fopen("./mensaje_de_ayuda.txt","r");
    char c;
    if (ayuda == NULL) {
        printf("Error al abrir ayuda\n");
    }
    else {
        while (fscanf(ayuda, "%c",&c) != EOF) {
            printf("%c",c);
        }
    }
}

int adicionSegura(int x, int y) {
    if (x >= 0) {
        if (INT_MAX - x < y) { //overflow
            return 0;
        }
    }
    else {
        if (y < INT_MIN - x) { //underflow
            return 0;
        }
    }
    return 1;
}
int multiplicacionSegura(int x,int y) {
    x = fabs(x);
    y = fabs(y);
    if (x > 0 && y > 0) {
        if (INT_MAX / x < y) { //overfloww
            return 0;
        }
    }
    else {
        if (y < INT_MIN / x) { //underflow
            return 0;
        }
    }
    return 1;
}




int restaSegura(int x, int y) {
    //x-y
    if (y > 0) {
        if ( ( x < 0) && (INT_MIN + y > x) ) { //underflow
            printf("ENTRE1\n");
            return 0;
        }
    }
    else if (y < 0) {
        if ( (x > 0) && (x > INT_MAX + y) ){ //overflow
            printf("ENTRE2\n");
            return 0;
        }
    }
    return 1;
}

int divisionSegura(int x, int y) {
    //x/y
    if (y == 0) {
        return 0;
    }
    return 1;
}

char* formarNumero(pila_t p,int cont) {
    pila_t* px=malloc(sizeof(pila_t));
    *px=p;
   char* toReturn=(char*)malloc(sizeof(char)*cont);
   char* aux=desapilar(px);
   strcpy(toReturn,aux);
   while(!pila_vacia(p))
   {
    aux=desapilar(px); //borrar
     strcat(toReturn,aux);
   }
   return toReturn;
}

int suma(lista_t operandos) {

    int  res = 0;
    unsigned int cant = operandos->cant;
    unsigned int i;
    int adSegura = 1;
    for(i = 0; i < cant && adSegura; i++){
        int y = lista_obtener(operandos, i);
        adSegura = adicionSegura(y,res);
        if (adSegura) {
            res = res + y;
        }
        else { //OVERFLOW
            printf("Se detecto un overflow.1");
            //Gestionar adecuamante?
            abort();//borrar
        }
    }
    return res;
}

int producto(lista_t operandos) {

    int  res = 1;
    unsigned int cant = operandos->cant;
    unsigned int i;
    int multSegura = 1;
    for(i = 0; i < cant && multiplicacionSegura; i++){
        int y = lista_obtener(operandos, i);
        multSegura = multiplicacionSegura(res,y);
        if (multSegura) {
            res = res * lista_obtener(operandos, i);
        }
        else { // OVERFLOW
            printf("Se detecto un overflow.2");
            //Gestionar adecuamante?
            abort();//borrar
        }
    }
    return res;
}

int resta(lista_t operandos) {
    int a= lista_obtener(operandos, 0);
    int b= lista_obtener(operandos, 1);
    int res = 0;
    if (restaSegura(b,a)) {

            res = b-a;
    }
    else { //OVERFLOW
        printf("Se detecto un overflow.3");
        //Gestionar adecuamante?
        abort();//borrar
    }
    return res;
}

int division(lista_t operandos) {
    int a= lista_obtener(operandos, 0);
    int b= lista_obtener(operandos, 1);
    int res = 0;
    if (divisionSegura(b,a)) {

            res = b / a;

    }
    else { //OVERFLOW
        printf("Se detecto un overflow.4");
        //Gestionar adecuamante?
        abort();//borrar
    }
    return res;
}

int negacion(lista_t l){
int res=0;
res=lista_obtener(l,0);
printf("De la lista saque el %i\n",res);
res=res*-1;
return res;
}

int isoperator(char* a) {
 return ( strcmp(a,"*")== 0) || ( strcmp(a,"-")== 0) || (strcmp(a,"/")==0) || ( strcmp(a,"+")==0);
}

int longitud(int i) {


   int valor = 0;

    while(i != 0){
        valor = valor +1;
        i = i/10;
    }
       return valor;
}

char* calc(pila_t pila) {
    int resultado=0;
    lista_t lista=crear();
    pila_t* px=malloc(sizeof(pila_t));
    *px=pila;
    int cont=0;
    while(!pila_vacia(pila) && esDigito(tope(pila)))
    {
        cont=cont+1;
        int num=(int)strtol(desapilar(px),(char**)NULL,10);
        lista_insertar(lista,cont-1,num);
    }
    if (pila_vacia(pila)){exit(EXP_MALF);}//exp malformada
    char* op=desapilar(px);
    if(strcmp(op,"+")==0)
    {
        if(cont<2)
        {
            exit(OPND_INSUF);
        }
        resultado=suma(lista);
    }
    else
    {
       if(strcmp(op,"*")==0)
       {
          if(cont<2)
          {
           exit(OPND_INSUF);
          }
          resultado=producto(lista);
       }
       else
       {
          if(strcmp(op,"/")==0)
          {
             if(cont<2)
             {
               exit(OPND_INSUF);
             }
             if(cont>2)
             {
               exit(OPND_DEMAS);
             }
             resultado=division(lista);
          }
          else
          {
             if(strcmp(op,"-")==0)
             {
                 if(cont==0)
                 {
                    exit(OPND_INSUF);
                 }
                 if(cont>2)
                 {
                    exit(OPND_DEMAS);
                 }
                 if (cont==1){resultado=negacion(lista);}
                 else
                 {
                    resultado=resta(lista);
                 }
             }
             else
             {
                 if(strcmp(op,"(")==0 || strcmp(op,")")==0)
                 {
                    exit(EXP_MALF);
                 }
                 else{ exit(OPND_INV);}
             }
          }

      }
  }




    char* toReturn=(char*)malloc(sizeof(char)*longitud(resultado));
    sprintf(toReturn,"%d",resultado);
    return toReturn;
}

int esDigito(char* p){
 return isdigit(*p)!=0 || strlen(p)>1;
}
//LAST V
int evaluar(char* expresion) {
    pila_t temp=pila_crear();
    pila_t base=pila_crear();
    pila_t nros=pila_crear();
    pila_t* pt=(pila_t*)malloc(sizeof(pila_t));
    *pt=temp;
    pila_t* pb=(pila_t*)malloc(sizeof(pila_t));
    *pb=base;
    pila_t* pn=(pila_t*)malloc(sizeof(pila_t));
    *pn=nros;
    char c=' ';int index = 0;
    char* pc=(char*)malloc(sizeof(char));
    while(c!=10)
    {
        c = *(expresion+index);
        if(c!=10){
            *pc=c;
            apilar(pt,pc);
            index++;
        }
    }
    int cont=0;
    char* ax;
    while(!pila_vacia(temp)){
        ax=desapilar(pt);
        if((strcmp(ax," ")==0)){
            if(!pila_vacia(nros))
            {
                apilar(pb,formarNumero(nros,cont));
                cont=0;
            }
        }
        else{
            if(*ax>=48 && *ax<=57){
                cont=cont+1;
                apilar(pn,ax);
            }
            else{
                if(pila_vacia(nros)){
                    apilar(pb,ax);
                }
                else{
                    if(strcmp(ax,"-")==0){ apilar(pn,ax);}
                    apilar(pb,formarNumero(nros,cont));
                    cont=0;
                    if(strcmp(ax,"-")!=0){ apilar(pb,ax);}

                   // apilar(pb,ax);
                }
            }
        }
    }



    if(!pila_vacia(nros)){
        apilar(pb,formarNumero(nros,cont));
    }

    while(!pila_vacia(base)){
     apilar(pt,desapilar(pb));
    }


    //-----------------------------
    char* aux1=desapilar(pt);
    if (pila_vacia(temp))
    {
       if(esDigito(aux1))
       {
        printf("El resultado es %s\n",aux1);
        return atoi(aux1);
       }
       else
       {
        exit(EXP_MALF);
       }
    }
    else
    {
       if(strcmp(aux1,")")!=0)
       {
         exit(EXP_MALF);
       }
    }
    int seguir=1;
    int contador=1;
    char* desapi;
    char* api;
    while (seguir)
    {
      desapi=desapilar(pt);
      if (strcmp(desapi,")")==0){ contador++; }
      else
      {
        apilar(pt,desapi);
        if (strcmp(desapi,"(")!=0)
        {
          api=calc(temp);
          if (pila_vacia(temp)){ exit(EXP_MALF); }
          else
          {
            desapi=desapilar(pt);
            if (strcmp(desapi,"(")==0)
            {
              if (contador==0){ exit(EXP_MALF); }
              if (pila_vacia(temp)){ seguir=0; }
              contador--;
              apilar(pt,api);
            }
            else{ exit(EXP_MALF); }
          }
        }
        else{ exit(EXP_MALF); }

     }
  }//END WHILE
  if (contador!=0) exit(EXP_MALF);
  api=desapilar(pt);
  printf("El resultado es %s\n",api);
  }

int main(int argc, char *argv[]) {

    char* exp = NULL;
    int read;
    size_t len;
    int res;

    if (argc > 1) { //Fue llamado desde consola con argumentos
        int solicitudAyuda = !strcmp(argv[1],"-h"); //1 si se solicita, 0 caso contrario
        if (solicitudAyuda) {
            printf("entre a ayuda\n");
            mostrarAyuda();
        }
        else if (argc > 3 && argc < 6) { //Se introdujeron archivos de entrada y salida
            int parametrosCorrectos = !strcmp(argv[1],"-i") && !strcmp(argv[3],"-o") && argv[2] != NULL && argv[4] != NULL;
            if (parametrosCorrectos) {
                printf("entre a archivo de entrada y salida\n");
                FILE *output,*input;

                input = fopen(argv[2], "r");
                output = fopen(argv[4], "w");

                if (output == NULL) {
                    printf("El archivo de salida no existe\n");
                    mostrarAyuda();
                }
                else if (input == NULL) {
                    printf("El archivo de entrada no existe\n");
                    mostrarAyuda();
                }
                else { //Los archivos existen
                    read = getline(&exp,&len,input);
                    strcat(exp,"\n"); // Por si el archivo no posee salto de linea
                    res = evaluar(exp);
                    fprintf(output,"%d",res);
                    fclose(input);
                    fclose(output);
                }
            }
            else { //parametros erroneos
                //mostrar mensaje de error y texto de ayuda
                printf("1param erroneo\n");
                mostrarAyuda();
            }
        }
        else if (argc < 4) { //Se introdujo archivo de entrada o de salida
            if (!strcmp(argv[1],"-o") && argv[2] != NULL) { //Se introdujo archivo de salida
                printf("entre a archivo de salida\n");
                FILE* output;
                output = fopen(argv[2], "w");
                if (output == NULL) { //Archivo inexistente
                    printf("El archivo de salida no existe\n");
                    mostrarAyuda();
                }
                else {
                    read = getline(&exp,&len,stdin);
                    res = evaluar(exp);
                    fprintf(output,"%d",res);
                    fclose(output);
                }
            }
            else if (!strcmp(argv[1],"-i") && argv[2] != NULL){ //Se introdujo archivo de entrada
                printf("entre a archivo de entrada\n");
                FILE* input;
                input = fopen(argv[2], "r");
                if (input == NULL) { //Archivo inexistente
                    printf("El archivo de entrada no existe\n");
                    mostrarAyuda();
                }
                else {
                    read = getline(&exp,&len,input);
                    strcat(exp,"\n"); // Por si el archivo no posee salto de linea
                    res = evaluar(exp);
                    fclose(input);
                }
            }
            else { //parametro erroneo
                //mostrar mensaje de error y texto de ayuda
                printf("2param erroneo\n");
                mostrarAyuda();
            }
        }
        else { //parametros mayores a 6, error
            //mostrar mensaje de error y texto de ayuda
            printf("3param erroneo\n");
            mostrarAyuda();
        }
    }
    else {
        printf("no entre por consola\n");

        read = getline(&exp,&len,stdin);
        res = evaluar(exp);
    }

    free(exp);

    return 0;
}

