# Programación Funcional
### El paradigma funcional se centra más en el "qué" y no en el "como"

### Predicate
    La interfaz funcional que mediante una expresión lambda que recibe un tipo genérico retornar un boolean.
    método abstracto:
    test(T t)

### Consumer
    La interfaz funcional que mediante una expresión lambda que recibe un tipo genérico el valor de retorno es un void.
    método abstracto:
    test(T t)

### Supplier 
    La interfaz funcional que mediante una expresión lambda no recibe parámetro pero se retorna un valor.
    método abstracto:
     T get();

### Function
    La interfaz funcional que mediante una expresión lambda recibe parámetro T pero se retorna otro tipo de dato R.
    método abstracto:
     R apply(T t);

### Optional
    Es un objeto contenedor que puede o no tener un valor, esto nos ayuda mucho con el NullPointerException, sirve para cuando manejamos los streams


# API Stream

###