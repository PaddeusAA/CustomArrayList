
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


    // Добавление нового элемента
    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    // Удаление конкретного элемента
    public void remove(int elementIndex) {
        for (int i = 2; i < elements.length; i++) {
            //выполняется перемещение элементов к началу, в результате чего пустая ячейка окажется в конце
            elements[i - 1] = elements[i];
            elements[i] = null;
        }
        size--;
    }

    // Удаление элемента по имени
    public void remove(String deleteWord) {
        for (int i = 0; i < elements.length; i++){
            if(elements[i] != null){
                if (elements[i].equals(deleteWord)){
                    remove(i);
                }
            }
        }
    }

    // Очистка массива
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Вывод всего массива
    public void print() {
        for (String str : elements) {
            if (str != null) {
                System.out.println(str);
            }
        }
    }

    // Возвращает элемент под нужным индексом
    public String get(int elementIndex) {
        return elements[elementIndex];
    }

    // Проверка на то, пустой ли массив
    public Boolean isEmpty() {
        boolean isEmpty = true;
        for (String str : elements) {
            if (str != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    // Возвращает размер массива (занятых ячеек)
    public int size() {
        return size;
    }

    // Возващает размер массива (capacity)
    public int arraySize() {
        return capacity;
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
