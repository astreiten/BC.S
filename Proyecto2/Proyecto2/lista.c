#include <stdio.h>
#include <stdlib.h>
#include "lista.h"
#include "exits.h"

//ULTIMA VERSION
lista_t crear(){

  lista_t a;
  a=(lista_t)malloc(sizeof(lista_t));
  a->cant=0;
  a->primera_celda=(celda_t*)malloc(sizeof(celda_t));
  return a;
}
int lista_obtener( lista_t lista, unsigned int pos){


	if(pos>=lista->cant || pos < 0){ //Si la posicion es invalida (0'
	 exit(LST_POS_INV);
	}
	int celda = (pos + 3) / 4;
	if(pos%4==0){celda=celda+1;};
	celda_t * actual = lista -> primera_celda;
	int i;
	for(i = 1; i < celda; i++){
		actual = actual -> proxima_celda;
	}
	int toReturn = actual -> elementos[pos % 4];//x
	return toReturn;
}




int lista_cantidad(lista_t lista)
{
    if(lista == NULL){
    exit(LST_NO_INI);
    }
  return lista->cant;
}



int lista_eliminar(lista_t lista,int pos){
if (pos<lista->cant)
{
    int aux=(pos+3)/4;
    if(pos%4==0){aux=aux+1;};
    celda_t* actual=lista->primera_celda;
    int i;
    for (i=1;i<aux;i++)
    {
      actual=actual->proxima_celda;
    }
    celda_t* celda_act=actual;
    celda_t* celda_ori=actual;
    int i_actual=pos%4;
    int i_origen=pos%4+1;
    for (i=pos;i<lista->cant-1;i++)
    {
       if(i_actual==4)
       {
         i_actual=0;
         celda_act=celda_act->proxima_celda;
       }
       if(i_origen==4){
       i_origen=0;
       celda_ori=celda_ori->proxima_celda;
       }
       celda_act->elementos[i_actual]=celda_ori->elementos[i_origen];
       i_origen++;
       i_actual++;
    }
   celda_ori->elementos[lista->cant-1]=NULL;
    if(lista->cant!=1){
    if (lista->cant%4==1){
     if(celda_act==celda_ori){
      celda_act=lista->primera_celda;
      int i;
      for(i=1;i<(lista->cant/4);i++)
      {
       celda_act=celda_act->proxima_celda;
      }

    }

     free(celda_act->proxima_celda);
     celda_act->proxima_celda=NULL;
    }}

    lista->cant=lista->cant-1;

  }
    else{
        exit(LST_POS_INV);
    }
}


int lista_insertar(lista_t lista, unsigned int pos, int elem){
    if (pos<=lista->cant) //estamos en un caso de insercion viable
    {
      if(pos<lista->cant){//vamos a reemplazar un elemento ya existente
      int aux=(pos+3)/4;
      if(pos%4==0 && pos!=0){aux=aux+1;}
      celda_t* actual=lista->primera_celda;
      int i;
      for (i=1;i<aux;i++)
      {
        actual=actual->proxima_celda;
      }
      actual->elementos[pos%4]=elem;
      }else{//vamos a agregar un elemento al final de la lista
      if(pos%4==0 && pos!=0)//hay que crear nueva celda
      {
      int aux=(lista->cant+3)/4;//calculo la cantidad de celdas creadas
      celda_t *actual=lista->primera_celda;
      int i;
      for (i=1;i<aux;i++)
      {
        actual=actual->proxima_celda;
      }
      celda_t *nueva=(celda_t*)malloc(sizeof(celda_t));
      nueva->proxima_celda=NULL;
      actual->proxima_celda=nueva;
      nueva->elementos[pos%4]=elem;
      lista->cant=lista->cant+1;

      }
      else{//insertaremos en una celda ya creada
      if(pos==0){
      lista->primera_celda->elementos[0]=elem;
      lista->cant=lista->cant+1;
      }
      else{
       celda_t *actual=lista->primera_celda;
       int aux=(lista->cant+3)/4;
       int i;
       for(i=1;i<aux;i++)
       {
        actual=actual->proxima_celda;
       }
       actual->elementos[pos%4]=elem;
       lista->cant=lista->cant+1;
      }
      }





  }
  return 1;
  }
  else return 0;
  }

  int lista_adjuntar(lista_t lista, int elem){

    if(lista == NULL){
    exit(LST_NO_INI);
    }
    else{
    lista_insertar(lista, lista->cant,elem);
    }

    return 0;

  }
  int destruiraux(celda_t* act)
  {
    if(act->proxima_celda==NULL){//llegamos al final de la lista

    }
    else{
      celda_t* p=act->proxima_celda;
      destruiraux(p);
      free(act->proxima_celda);
    }
  }

  int lista_destruir(lista_t* lista){
  if (*lista==NULL) exit(LST_NO_INI);
  lista_t aux=*lista;
  celda_t* a=aux->primera_celda;
  free(aux->primera_celda);


  }

