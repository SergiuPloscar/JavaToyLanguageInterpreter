package Model;

public class IfStmt implements IStmt {
    Exp exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {
        exp=e;
        thenS=t;
        elseS=el;
    }

    public String toString(){
        return "IF "+ exp.toString()+" THEN " +thenS.toString()+" ELSE "+elseS.toString();
    }

    @Override
    public PrgState execute(PrgState state) throws MyStmtExecException {
        try {
            MyIDictionary<String,Integer> symTbl= state.getSymTable();
            MyIStack<IStmt> stk=state.getExeStack();
            int val = exp.eval(symTbl);
            if(val!=0){
                stk.push(thenS);
            }
            else
                stk.push(elseS);
        } catch (MyExpExecException e) {
            throw new MyStmtExecException("Error : "+e.getMessage());
        }
        return state;
    }
}
