public class ArbolFactory {
    private Map<String, Arbol> arbolMap= new HashMap<>();


    public Arbol getArbol(Double alto, Double horizontal, String color){
        //Establesco la clave
        String clave= "key: "+alto + ":" + horizontal ":" + color;

        //Busco la computadora en el Map, según la clave
        Arbol arbol= arbolMap.get(clave);
        if (arbol == null){
            //Si entra significa que aún no hay un objeto con esa clave
            //Crear una nueva instancia
            arbol = new arbol (alto, horizontal, color);
            System.out.println("Se crea un nueva computadora: "+ arbol);
            //Agregar al Map
            arbolMap.put(clave,arbol);
        }
        return arbol;
}
