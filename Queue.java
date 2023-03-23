// 2 стека
public class Queue {
    private AsdStack first;
    private AsdStack last;
    public boolean add(int i){ // O(1) сложность константная 
        first.add(i);
        return true;
    }
    public int getElem() {
        if (last.isEmpty()) {
            while (!first.isEmpty()) {  // O(n) сложность линейна
                last.add(first.getFirst());
            }
        }
        return last.getFirst();
    }
}

