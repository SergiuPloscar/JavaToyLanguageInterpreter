package Model;

public class PrintStmt implements IStmt {
    Exp exp;

    public PrintStmt(Exp exp) {

        this.exp=exp;
    }

    @Override
    public String toString() {
        return "Print("+exp.toString()+")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyStmtExecException {
        try {
            MyIDictionary<String,Integer> symTbl= state.getSymTable();
            int val = exp.eval(symTbl);
            state.getOut().add(val);
        }
        catch (MyExpExecException e)
        {
            throw new MyStmtExecException("Error : "+e.getMessage());
        }
        return state;
    }
}
