

public class Clear extends Program {

    public Clear(int setPID) {
        super(setPID, "clear");
    }

    @Override
    public int main(){
        System.out.print("\033[H\033[2J");
        return 0;
    }
    
}
