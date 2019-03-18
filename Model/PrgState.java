package Model;

public class PrgState {
    MyIStack<IStmt> exeStack;
    MyIDictionary<String,Integer> symTable;
    MyIList<Integer> out;


    IStmt originalProgram;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Integer> symtbl, MyIList<Integer> ot, IStmt prg) {
        exeStack=stk;
        symTable=symtbl;
        out=ot;
        originalProgram=prg;
        stk.push(prg);
    }

    public String toString(){
        String msg="";
        msg+="____________________________\n\n";
        msg+="Stack:\n"+exeStack.toString()+"\n";
        msg+="SymTable:\n"+symTable.toString()+"\n";
        msg+="Out:\n"+out.toString()+"\n\n";

        return msg;
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(IStmt originalProgram) {
        this.originalProgram = originalProgram;
    }
}
