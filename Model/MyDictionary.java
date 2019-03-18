package Model;
import java.util.HashMap;

public class MyDictionary<TKey,TValue> implements MyIDictionary<TKey,TValue>{
    HashMap<TKey,TValue> dict;

    public MyDictionary() {
        dict = new HashMap<TKey, TValue>();
    }

    @Override
    public String toString(){
        String str="";
        for(TKey key : dict.keySet())
            str+=key.toString()+" = "+dict.get(key).toString()+'\n';
        return str;

    }

    @Override
    public void put(TKey key, TValue value) {
        dict.put(key, value);
    }

    @Override
    public void remove(TKey key) throws MyDataException {
        containsKey(key);
        dict.remove(key);
    }

    @Override
    public TValue get(TKey key) throws MyDataException {
        containsKey(key);
        return dict.get(key);
    }

    @Override
    public boolean containsKey(TKey key) throws MyDataException {
        if(dict.containsKey(key)==false)
            throw new MyDataException(" This key doesn't exist: "+key.toString());
        return true;
    }

    @Override
    public boolean containsValue(TValue value) throws MyDataException {
        if(dict.containsValue(value)==false)
            throw new MyDataException(" This value doesn't exist: "+value.toString());
        return true;
    }

    public HashMap<TKey, TValue> getDict() {
        return dict;
    }
}
