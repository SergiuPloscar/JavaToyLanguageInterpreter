package Model;

public class DoStmtWhile implements IStmt {
    IStmt stmt;
    Exp exp;
    public DoStmtWhile( IStmt stmt, Exp exp) {
        this.stmt=stmt;
        this.exp=exp;
    }

    @Override
    public String toString() {
        return "do (" + stmt.toString() + ") while (" + exp.toString() + " )";
    }

    @Override
    public PrgState execute(PrgState state) throws MyStmtExecException {
        try {
            state.getExeStack().push (new CompStmt(stmt,(new IfStmt(exp,new DoStmtWhile(stmt,exp),new PrintStmt(new ConstExp(0))))));
        }
        catch (Exception e)
        {
            throw new MyStmtExecException("Error evaluating statement: "+e.getMessage());
        }
        return state;
    }

}
