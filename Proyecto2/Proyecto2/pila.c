#include <stdlib.h>
#include "pila.h"
#include "exits.h"


pila_t pila_crear()
{

    pila_t nueva;
    nueva=(pila_t)malloc(sizeof(pila_t));
    nueva->elemento=NULL;
    nueva->proximo_elemento=NULL;
    return nueva;

}
int pila_vacia(pila_t pila)
{
    if (pila==NULL){exit(PIL_NO_INI);}
    if (pila->elemento==NULL)return 1;
    else return 0;

}
char* tope(pila_t pila)
{

    if ( pila->elemento!= NULL )  // la pila no está vacía
    {
        pila_t actual=(pila_t)malloc(sizeof(pila_t));
        actual=pila;
        while(actual->proximo_elemento!=NULL)
        {
            actual=actual->proximo_elemento;
        }
        char* p;
        char* c=(actual)->elemento;
        int aux=strlen(c);
        p=malloc(sizeof(char)*aux);
        strcpy(p,c);
        return p;
    }
    else
    {
        exit(PIL_VACIA);
    }
}
char* desapilar(pila_t* pila)
{

    char* p;


    if((*pila)->elemento == NULL)  //si esta vacia se tira exit pila_vacia
    {

        exit(PIL_VACIA);
    }
    else                    //si no esta vacia
    {
        if((*pila)-> proximo_elemento == NULL)
        {
            char* c=(*pila)->elemento;
            int aux=strlen(c);
            p=malloc(sizeof(char)*aux);
            strcpy(p,c);
            free((*pila)->elemento);
            (*pila)->elemento=NULL;

        }
        else
        {

            pila_t actual=(*pila);
            while(actual->proximo_elemento->proximo_elemento!=NULL)
            {
                actual=actual->proximo_elemento;

            }
            char* c=actual->proximo_elemento->elemento;
            int aux=strlen(c);
            p = malloc(sizeof(char)*aux);
            strcpy(p,c);

            free(c);

            actual->proximo_elemento=NULL;
        }
    }


    return p;

}
int apilar(pila_t* pila, char* str)
{
    if (*pila==NULL) exit(PIL_NO_INI);
    if((*pila)->elemento == NULL)  //vamos a insertar en la primera ubicacion.
    {
        int aux=strlen(str);
        char* p=(char*)malloc(sizeof(char)*aux);
        strcpy(p,str);
        (*pila)->elemento=p;
    }
    else //vamos a insertar en otra ubicacion.
    {
        int aux=strlen(str);
        pila_t actual=(*pila);
        while(actual->proximo_elemento!=NULL)
        {
            actual=actual->proximo_elemento;
        }
        pila_t nuevo=(pila_t)malloc(sizeof(pila));
        char* p=(char*)malloc(sizeof(char)*aux);
        strcpy(p,str);
        actual->proximo_elemento=nuevo;
        nuevo->elemento=p;
        nuevo->proximo_elemento=NULL;
    }

    return 1;

}
