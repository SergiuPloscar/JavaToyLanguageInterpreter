package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class MyList<T> implements  MyIList<T> {
    ArrayList<T> list;
    public MyList(){
        list = new ArrayList<T>();
    }

    public MyList(ArrayList<T> list){
        this.list=list;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void add(T elem) {
        list.add(elem);
    }

    @Override
    public void remove(T elem) throws MyDataException {
        if(list.contains(elem)==false)
            throw new MyDataException("The element doesn't exist: "+elem.toString());
        list.remove(elem);
    }
    @Override
    public String toString(){
        String str="";
        for(T el : list)
            str+=el.toString()+'\n';
        return str;
    }

    public T get(int pos) throws MyDataException{
        try{
            return list.get(pos);
        }
        catch (Exception e){
            throw new MyDataException("This is not a valid position");
        }
    }
}
