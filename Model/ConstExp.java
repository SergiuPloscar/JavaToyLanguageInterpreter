package Model;

public class ConstExp extends Exp {

    int number;

    public ConstExp(int number) {
        this.number=number;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> tbl) {
        return number;
    }

    @Override
    public
    String toString() {
        return String.valueOf(number);
    }
}
