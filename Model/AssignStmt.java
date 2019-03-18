package Model;

public class AssignStmt implements IStmt {
    String id;
    Exp exp;
    public AssignStmt(String id, Exp exp) {
        this.id=id;
        this.exp=exp;
    }

    @Override
    public String toString() {
        return "("+id+"="+exp.toString()+")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyStmtExecException {
        try {
            MyIDictionary<String,Integer> symTbl= state.getSymTable();
            int val = exp.eval(symTbl);
            symTbl.put(id, val);
        }
        catch (MyExpExecException e)
        {
            throw new MyStmtExecException("Error evaluating statement: "+e.getMessage());
        }
        return state;
    }
}
