package lab06;

public interface List extends Iterable<Object> {
    void add(Object o);
    boolean find(Object o);
    int size();
    void print();
    Object getLast();
}