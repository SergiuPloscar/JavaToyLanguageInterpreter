package Repository;
import Model.*;

public interface MyIRepo {
    void addProgram(IStmt prg);
    void addProgram(PrgState p);
    void logPrgStateExec() throws MyRepoException;
    void displayPrgStateExec() throws MyRepoException;
    PrgState getCrtPrg() throws MyRepoException ;
}
