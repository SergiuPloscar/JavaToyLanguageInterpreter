package Model;

public class ArithExp extends Exp {
    Exp e1;
    Exp e2;
    int op;
    public ArithExp(Exp e1, Exp e2, int op){
        this.e1=e1;
        this.e2=e2;
        this.op=op;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> tbl) throws MyExpExecException {

            if(op==1)
                return e1.eval(tbl)+e2.eval(tbl);
            else if(op==2)
                return e1.eval(tbl)-e2.eval(tbl);
            else if(op==3)
                return e1.eval(tbl)*e2.eval(tbl);
            else if(op==4)
            {
                if(e2.eval(tbl)==0)
                    throw new MyExpExecException("Division by 0 error");
                return e1.eval(tbl)/e2.eval(tbl);
            }
            else
            throw new MyExpExecException("The following operation does not exist: "+op);




    }

    @Override
    public
    String toString() {
        String operation="";
        if (op==1)
            operation="+";
        else if (op==2)
            operation="-";
        else if (op==3)
            operation="*";
        else if (op==4)
            operation="/";
        return e1.toString()+" "+operation+" "+e2.toString();
    }

}
