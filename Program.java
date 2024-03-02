import java.io.IOException;

public class Program {
    protected int pid = -1;
    protected String name = "n/a";
    

    public Program(int setPID){
        this.pid = setPID;
    }

    public Program(int setPID, String setName){
        this.pid = setPID;
        this.name = setName;
    }

    public Program(String setName){
        this.name = setName;
    }

    // Return the PID of the program
    public int getpid(){
        return this.pid;
    }
    
    // return the name of the program
    public String getname(){
        return this.name;
    }

    // def __string__(self):
    public String toString(){
        return String.format(this.name + ": " + "(PID)"+this.pid);
    }


    // Executable part
    public int main() throws IOException{
        return 0;
    }


}
