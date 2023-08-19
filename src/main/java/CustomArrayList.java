
//Пока работает только со String
public class CustomArrayList {
    private int size; // Отвечает за динамическое расширение массива
    private int capacity; // Размер массива
    private String[] elements;

    public CustomArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    public void remove(int elementIndex){
        for (int i = 2; i < elements.length; i++) {
            //выполняем перемещение элементов к началу, в результате чего пустая ячейка окажется в конце
            elements[i-1] = elements[i];
            elements[i] = null;
        }
        size--;
    }

    public void print(){
        for(String str : elements){
            if(str != null){
                System.out.println(str);
            }
        }
    }

    public void clear(){
        for (int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
        size = 0;
    }

    // Метод автоматически вызывается когда заканчиваются свободные ячейки
    private void grow() {
        capacity = (int) (capacity * 1.5);
        String[] tempElements = new String[capacity];
        for (int i = 0; i < elements.length; i++) {
            tempElements[i] = elements[i];
        }
        elements = tempElements;
    }

}
