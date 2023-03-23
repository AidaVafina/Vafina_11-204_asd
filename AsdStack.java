public class AsdStack {
    private int[] array;
    private int current; // ссылка на вершину стека

    public AsdStack(int size){ // конструктор
        array = new int[size];
        current =- 1; // в стеке ничего нет, пустой
    }
    public void add(int elem){
        array[current] = elem;
        current ++;
    }

    public int getFirst(){ // проверка на пустоту массива
        int a = array[current];
        current --;
        return a;
    }

    public int seeFirst(){
        return array[current];
    }

    public boolean isEmpty(){
        return current == -1;
    }

}
