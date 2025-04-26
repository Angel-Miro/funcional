# **Programación Funcional**
### El paradigma funcional se centra más en el "qué" y no en el "como"

### **Predicate**
    La interfaz funcional que mediante una expresión lambda que recibe un tipo genérico retornar un boolean.
    método abstracto:
    test(T t)

### **Consumer**
    La interfaz funcional que mediante una expresión lambda que recibe un tipo genérico el valor de retorno es un void.
    método abstracto:
    accept(T t)

### **Supplier** 
    La interfaz funcional que mediante una expresión lambda no recibe parámetro pero se retorna un valor.
    método abstracto:
     T get();

### **Function**
    La interfaz funcional que mediante una expresión lambda recibe parámetro T pero se retorna otro tipo de dato R.
    método abstracto:
     R apply(T t);

### **BiFunction**
    La interfaz funcional que mediante una expresion lambda recibe el parametro T y U y regresa R
    R apply(T, U)

### **Optional**
    Es un objeto contenedor que puede o no tener un valor, esto nos ayuda mucho con el NullPointerException, sirve para cuando manejamos los streams


# **API Stream**
    API Stream se utiliza para procesar colecciones de objetos. Un flujo en Java es una secuencia de objetos que admite varios métodos que pueden canalizarse para producir el resultado deseado.


# **Collectors**
    Son operaciones de recolección, utiles para acumular elementos en colecciones, método collect()

    stream.collect(Collectors.toList())
    stream.collect(Collectors.toSet())
    stream.distinct().collect(Collectors.toMap(Videogame::getName, Videogame::getPrice))

    Para listas no modificales: 
    stream.collect(Collectors.toUnmodifiableList())
    stream.collect(Collectors.toUnmodifiableSet())
    stream.distinct().collect(Collectors.toUnmodifiableMap(Videogame::getName, Videogame::getPrice))


# **Nuevas Funciones JDK 17** 
-    **Java Records**: Genera automáticamente getters, métodos toString, equals y hashCode y un constructor. Los atributos serán finales

    - Inmutables
        - Solo requiere tipo y nombre de los datos.
        - No permiten atributos de instancia, pero si estaticos.
        - No permiten herencia pero si implementaciones.
        - Se puede tener varios contructores asociados.
        - Se puede tener metodos adicionales.
        - Recomedanle para DTO´s, no para persistencia de base de datos.
  
          public record ClientRecord (
               int id;
               String name;
               LocalDate birthDate;
               Boolean status;
          ){
          }
      
          ClientRecord cr = new ClientRecord(1,"Name", LocalDate.now(), true);

-   **Selead Class**: Ordernar la jerarquia de las herencias o implementaciones.
      - Se puden aplicar sobre clases, clases abstractas e interfaces.
      - Una sealed class debe definir sus permits.
      - NUna clase que extiende o implementa una sealed class debe de ser final, sealed o non-sealed.
      - final: nadie puede extender
      - non-sealed: cualquier puede extenderlo
      
    
          public sealed abstract class/interface SQL permits SQLServer, MySQL{
              public abstract void connect();
              public abstract void disconnect();
          }

          public non-sealed abstract SQLServer extends SQL{
              public abstract void connect();
              public abstract void disconnect();
          }

          public final abstract MySQL extends SQL{
              public abstract void connect();
              public abstract void disconnect();
          }        
    
-   **Switch Expressions**
-   **Text Blocks**

# **Nuevas Funciones JDK 21** 

-   **Sequenced Collection/Map** : Se agregan clases intermedias que permiten utilizar métodos nuevos.
        
        List<Integer> list = new ArrayList<>;
        list.getFirst();
        list.getLast();
        list.addFirst(element)
        etc...
        
        SequencedMap<Integer, Product> map = new LinkedHashMap<>();
        map.put(1, new Product(1, "name", 10.0, true));
        map.put(2, new Product(1, "name", 11.0, true));
        map.put(3, new Product(1, "name", 12.0, true)); 
        
        map.pollFirstEntry();
        map.pollLastEntry();


-   **Record Patterns** : Destructuring Records

        private void ex1(Object param){
            if(param instanceof ClassRecord pr){
                System.out.println(pr);
                System.out.println(pr.name());
                System.out.println(pr.price());
            }
        }
        
        private void ex1(Object param){
        //Se realiza un destructurinf indicando los tipos de datos
            if(param instanceof ClassRecord(int x, String y, double price, boolean status)){
                System.out.println(x);
                System.out.println(y);
                System.out.println(price);
                System.out.println(status);
            }
        }