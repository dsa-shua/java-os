import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class myDate extends Program {

    public myDate(int setPID) {
        super(setPID, "date");
    }

    @Override
    public int main(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        System.out.println("Current time: "+dtf.format(localDate));
        return 0;
    }
    
}
