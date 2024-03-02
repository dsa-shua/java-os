import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class OS extends Program{
    private ArrayList<Program> processList = new ArrayList<Program>();
    private String[] shellBuf = null;
    private static int nextPID = 0;
    private static long startTime;

    public OS(){
        super(0, "OS");
        System.out.println("Welcome to OS!");
        add(this);
        startTime = System.nanoTime();
    }

    public int main(){
        Scanner scanner = new Scanner(System.in);
        Shell myShell = new Shell(nextPID);
        add(myShell);

        while(true){
            System.out.print("$ ");
            shellBuf = scanner.nextLine().split(" ");

            if (shellBuf[0].equals("exit") || shellBuf[0].equals("quit") || shellBuf[0].equals("q")){
                break;
            } else {
                // Run base custom
                // run(shellBuf[0]);

                // Run using the machine shell
                try {
                    myShell.run(shellBuf[0]);
                } catch (Exception e) {
                    System.out.println("shell thrown.");
                    e.printStackTrace();
                }
            }
        }

        scanner.close();
        return 0;
    }

   

    // Add a process to the process list
    private void add(Program program){
        processList.add(program);
        nextPID++;
    }

    // for later
    private void kill(Program prog){
        processList.remove(prog);
    }



    // TODO: use switch statements plz...
    // Run a specific program or syscall
    private void run(String prog_name){
        if (prog_name.equals("ps")){
            ps();
        } 
        
        else if(prog_name.equals("hello")){
            Hello temp = new Hello(nextPID);
            add(temp);

            // kill when successful
            if(temp.main() == 0){
                kill(temp);
            }

            // after exiting this block [run], hello is freed..
        }

        else if(prog_name.equals("date")){
            myDate temp = new myDate(nextPID);
            add(temp);
            if(temp.main() == 0){
                kill(temp);
            }
        }

        else if(prog_name.equals("clear")){
            Clear temp = new Clear(nextPID);
            add(temp);
            if(temp.main() == 0){
                kill(temp);
            }
        } 
        
        else if(prog_name.equals("runtime")){
            runtime();
        }

        else if (prog_name.equals("shop")){
            Shop temp = new Shop(nextPID);
            add(temp);

            if (shellBuf.length == 1){
                System.out.println("Usage: shop <cmd>");
            }
            else {
                if(shellBuf[1].equals("a")){
                    System.out.println("pressed a");
                }
                else if (shellBuf[1].equals("b")){
                    System.out.println("pressed b");
                }
                else {
                    System.out.println("invalid shop param!");
                }
            }


            if(temp.main() == 0){
                System.out.println("shop is now closed..");
                kill(temp);
            }
            
        }
        
        else if (prog_name.equals("shell")){
            
        }


        else if (prog_name.equals("")){

        }
        else {
            System.out.println("no such command!");
        }
    }


     // SystemCalls
    private void ps(){
        Program ps = new Program(nextPID, "ps");
        add(ps);
        
        processList.forEach((process) -> {
            System.out.printf("%s (PID)%d\n", process.getname(), process.getpid());
        });

        kill(ps);
    }

    private void runtime(){
        Program temp = new Program(nextPID, "runtime");
        add(temp);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.printf("runtime: %.3f sec\n", (totalTime/1e9));
        kill(temp);
    }
}
