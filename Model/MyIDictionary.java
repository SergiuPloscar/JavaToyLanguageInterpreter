package Model;

import java.util.HashMap;

public interface MyIDictionary<TKey,TValue> {
    void put(TKey key,TValue value);
    void remove(TKey key) throws MyDataException;
    TValue get(TKey key) throws MyDataException;
    boolean containsKey(TKey key) throws MyDataException;
    boolean containsValue(TValue value) throws MyDataException;
    HashMap<TKey,TValue> getDict();
    String toString();
}
