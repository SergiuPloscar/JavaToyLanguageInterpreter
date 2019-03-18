package Controller;
import Model.*;
import Repository.*;
public class MyController {

    public MyIRepo repo;
    public MyController(MyIRepo repo){
        this.repo=repo;
    }


    public void addProgram(IStmt prg){
        repo.addProgram(prg);
    }

    public PrgState oneStep(PrgState state) throws MyControllerException{
        try{
            MyIStack<IStmt> stk = state.getExeStack();
            if(stk.isEmpty());
            IStmt crtStmt=stk.pop();
            return crtStmt.execute(state);
        }
        catch(MyStackException e){
            throw new MyControllerException("Program terminated successfully \n");
        }
        catch(MyStmtExecException e){
            throw new MyControllerException(" Error at step: "+e.getMessage());
        }

    }

    public void allStep() throws MyControllerException {
        String output = "";
        try {
            PrgState prg = repo.getCrtPrg();
            output += prg.toString();
            while (true) {
                oneStep(prg);
                repo.logPrgStateExec();
                repo.displayPrgStateExec();
                output += prg.toString();
            }
        }
        catch(MyControllerException |MyRepoException  e){
            throw new MyControllerException(output+"\n"+e.getMessage());

        }


    }
}
