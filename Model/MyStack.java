package Model;


import java.util.ListIterator;
import  java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    Stack<T> stack ;


    public MyStack(){
        stack=new Stack<T>();

    }

    public MyStack(Stack<T> stack){
        this.stack=stack;
    }

    public Stack<T> getStack() {
        return stack;
    }


    public ListIterator<T> ReverseIterator() {
        return stack.listIterator(stack.size());
    }


    @Override
    public T pop() throws MyStackException {
        isEmpty();
        return stack.pop();
    }

    @Override
    public void push(T v) {
        stack.push(v);
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() throws MyStackException {
        if(stack.isEmpty())
            throw new MyStackException("The stack is empty");
        return false;
    }

    @Override
    public String toString(){
        String str="";
        for(T el : stack)
            str=el.toString()+'\n'+str;
        return str;
    }
}
