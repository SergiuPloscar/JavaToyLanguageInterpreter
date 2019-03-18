package Repository;
import Model.*;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyRepo implements MyIRepo {

    MyIList<PrgState> programs;
   String logFilePath;

    public MyRepo(PrgState p,String L) throws MyRepoException {
        programs = new MyList<PrgState>();
        programs.add(p);
       logFilePath = L;
    }

    public void addProgram(IStmt prg){
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String,Integer> symtbl = new MyDictionary<String,Integer>();
        MyIList<Integer> out = new MyList<Integer>();
        programs.add(new PrgState(stk,symtbl, out,prg));
    }

    public void addProgram(PrgState p){
        programs.add(p);
    }

    public void logPrgStateExec() throws  MyRepoException
    {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.append("ExeStack:");
            logFile.println();
            MyIStack<IStmt> EStk = getCrtPrg().getExeStack();
            ListIterator EStkIt = EStk.ReverseIterator();
            while ( EStkIt.hasPrevious()) {
                logFile.append(EStkIt.previous().toString());
                logFile.println();
            }
            logFile.append("SymTable:");
            logFile.println();
            MyIDictionary<String,Integer> STable = getCrtPrg().getSymTable();
            for (Map.Entry<String, Integer> entry : STable.getDict().entrySet())
            {  logFile.append(entry.getKey().toString() + " --> " + entry.getValue().toString());
                logFile.println();
            }
            logFile.append("Out:");
            logFile.println();
            MyIList<Integer> O = getCrtPrg().getOut();
            Iterator<Integer> OIterator = O.iterator();
            while ( OIterator.hasNext())
            {
                logFile.append(OIterator.next().toString());
                logFile.println();
            }
            logFile.println();
            logFile.close();


        }
        catch (IOException e) {
            throw new MyRepoException("Problems opening the file");
        }
    }


    public void displayPrgStateExec() throws  MyRepoException
    {
        try {
            System.out.println("ExeStack:");
            MyIStack<IStmt> EStk = getCrtPrg().getExeStack();
            ListIterator EStkIt = EStk.ReverseIterator();
            while (EStkIt.hasPrevious()) {
                System.out.println(EStkIt.previous().toString());
            }
            System.out.println("SymTable:");
            MyIDictionary<String, Integer> STable = getCrtPrg().getSymTable();
            for (Map.Entry<String, Integer> entry : STable.getDict().entrySet()) {
                System.out.println(entry.getKey().toString() + " --> " + entry.getValue().toString());
            }
            System.out.println("Out:");
            MyIList<Integer> O = getCrtPrg().getOut();
            Iterator<Integer> OIterator = O.iterator();
            while (OIterator.hasNext()) {
                System.out.println(OIterator.next().toString());
            }
            System.out.println("");
        }
        catch (MyRepoException e){
            throw new MyRepoException("Problems with the current program"); }
    }

    @Override
    public PrgState getCrtPrg() throws MyRepoException{
        try {
            return programs.get(0);
        } catch (MyDataException e) {
            throw new MyRepoException("No programs available");
        }
    }

}
