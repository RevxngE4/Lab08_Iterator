public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        dynamicArray.add(40);
        dynamicArray.add(60);
        dynamicArray.add(80);

        System.out.println("Tamaño del arreglo: " + dynamicArray.size());

        System.out.println("Elementos del arreglo:");
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }

        int index = 1;
        System.out.println("Elemento en la posición " + index + ": " + dynamicArray.get(index));

        dynamicArray.set(index, 50);
        System.out.println("Elemento modificado en la posición " + index + ": " + dynamicArray.get(index));

        int removeIndex = 0;
        dynamicArray.remove(removeIndex);
        System.out.println("Elemento eliminado en la posición " + removeIndex);

        System.out.println("Elementos del arreglo después de eliminar:");
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }
}
