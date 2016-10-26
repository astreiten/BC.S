#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED
typedef struct celda {
    int elementos[4];
    struct celda* proxima_celda;
} celda_t;

typedef struct lista_eficiente {
    unsigned int cant;
    celda_t* primera_celda;
} *lista_t;

lista_t crear();
int lista_cantidad(lista_t lista);
int lista_insertar(lista_t lista, unsigned int pos, int elem);
int lista_adjuntar(lista_t lista, int elem);
int lista_destruir(lista_t* lista);
int lista_obtener(lista_t lista, unsigned int pos);



#endif // LISTA_H_INCLUDED
