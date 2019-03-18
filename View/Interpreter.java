package View;
import Controller.*;
import Repository.*;
import Model.*;
import Test.*;
import java.util.Scanner;

public class Interpreter {
    public static void main(String[] args) throws MyRepoException{


       // Test test = new Test();
       // test.start();

        IStmt ex1=new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new VarExp("v")));
        PrgState prg1 = new PrgState(new MyStack(), new MyDictionary(), new MyList(), ex1);
        IStmt ex2= new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2),new ArithExp(new ConstExp(3), new ConstExp(5),3),1)), new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"), new ConstExp(1),1)), new PrintStmt(new VarExp("b"))));
        IStmt ex3=new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2), new ConstExp(2),2)), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
        PrgState prg2 = new PrgState(new MyStack(),new MyDictionary(),new MyList(),ex2);
        PrgState prg3 = new PrgState(new MyStack(),new MyDictionary(),new MyList(),ex3);
        Scanner reader = new Scanner(System.in);
        String FilePath1 =reader.next();
        MyIRepo repo1 = new MyRepo(prg1,FilePath1);
        MyController ctr1 = new MyController(repo1);
        String FilePath2 =reader.next();
        MyIRepo repo2 = new MyRepo(prg2,FilePath2);
        MyController ctr2 = new MyController(repo2);
        String FilePath3 =reader.next();
        MyIRepo repo3 = new MyRepo(prg3,FilePath3);
        MyController ctr3 = new MyController(repo3);
        IStmt ex4= new CompStmt(new AssignStmt("v",new ConstExp(20)),new DoStmtWhile(new CompStmt(new PrintStmt(new VarExp("v")),new AssignStmt("v",new ArithExp(new VarExp("v"),new ConstExp(1),2))),new ArithExp(new VarExp("v"),new ConstExp(10),2)));
        String FilePath4 =reader.next();
        PrgState prg4 = new PrgState(new MyStack(),new MyDictionary(),new MyList(),ex4);
        MyIRepo repo4 = new MyRepo(prg4,FilePath4);
        MyController ctr4 = new MyController(repo4);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1","Run example 1: " + ex1.toString(),ctr1));
        menu.addCommand(new RunExample("2","Run example 2: " +ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3","Run example 3: " +ex3.toString(),ctr3));
        menu.addCommand(new RunExample("4","Run example 4: " +ex4.toString(),ctr4));
        menu.show();



    }
}
