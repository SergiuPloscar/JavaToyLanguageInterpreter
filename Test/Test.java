package Test;
import Controller.*;
import Repository.*;
import Model.*;

public class Test {
    public Test() {

    }

    public void start() {
        try {
            test_ConstExp();
            test_ArithExp();
            test_VarExp();
            test_AssignStmt();
            test_PrintStmt();
            test_CompStmt();
            test_IfStmt();
        } catch (MyExpExecException | MyStackException | MyDataException | MyStmtExecException e) {
            e.printStackTrace();
        }

    }

    void test_ConstExp() throws MyExpExecException {
        Exp e = new ConstExp(100);
        assert (100 == e.eval(null));
    }

    void test_ArithExp() throws MyExpExecException {
        Exp e = new ArithExp(new ConstExp(2), new ConstExp(3), 1);
        assert (5 == e.eval(null));
    }

    void test_VarExp() throws MyExpExecException {
        Exp e2 = new VarExp("x");
        MyIDictionary d = new MyDictionary();
        d.put("x", 100);
        assert (100 == e2.eval(d));
    }

    void test_AssignStmt() throws MyStmtExecException, MyStackException, MyDataException {
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Integer> symtbl = new MyDictionary<String, Integer>();
        MyIList<Integer> out = new MyList<Integer>();
        PrgState s = new PrgState(stk, symtbl, out, new AssignStmt("x", new ConstExp(100)));
        s.getExeStack().pop().execute(s);
        assert (100 == s.getSymTable().get("x"));
    }

    void test_PrintStmt() throws MyStmtExecException, MyStackException, MyDataException {

        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Integer> symtbl = new MyDictionary<String, Integer>();
        MyIList<Integer> out = new MyList<Integer>();
        IStmt stmt = new PrintStmt(new ConstExp(5));
        PrgState s = new PrgState(stk, symtbl, out, stmt);

        s.getExeStack().pop().execute(s);
        assert (5 == s.getOut().get(0));
    }

    void test_CompStmt() throws MyStmtExecException, MyStackException, MyDataException {
        IStmt stmt = new CompStmt(new PrintStmt(new ConstExp(2)), new PrintStmt(new ConstExp(3)));

        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Integer> symtbl = new MyDictionary<String, Integer>();
        MyIList<Integer> out = new MyList<Integer>();
        PrgState s = new PrgState(stk, symtbl,  out, stmt);

        s.getExeStack().pop().execute(s);
        s.getExeStack().pop().execute(s);
        s.getExeStack().pop().execute(s);
        assert (2 == s.getOut().get(0));
        assert (3 == s.getOut().get(1));
    }

    void test_IfStmt() throws MyStmtExecException, MyStackException, MyDataException {
        IStmt stmt = new IfStmt(new ConstExp(1), new PrintStmt(new ConstExp(2)), new PrintStmt(new ConstExp(3)));
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String, Integer> symtbl = new MyDictionary<String, Integer>();
        MyIList<Integer> out = new MyList<Integer>();
        PrgState s = new PrgState(stk, symtbl, out, stmt);

        s.getExeStack().pop().execute(s);
        s.getExeStack().pop().execute(s);

        assert (2 == s.getOut().get(0));
    }
}
