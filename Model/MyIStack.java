package Model;


import java.util.ListIterator;
import java.util.Stack;

public interface MyIStack<T> {
    T pop() throws MyStackException;
    void push(T v);
    void clear();
    Stack getStack();
    boolean isEmpty() throws MyStackException;
    ListIterator ReverseIterator();
    String toString();
}
