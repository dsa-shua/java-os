import java.util.HashMap;
import java.util.ArrayList;

public class Shop extends Program {
    private HashMap<String, Double> itemList = new HashMap<String, Double>();
    private ArrayList<String> userList = new ArrayList<String>();


    public Shop(int setPID) {
        super(setPID, "shop");
        System.out.println("The shop is now open...");
    }

    public void addUser(User user){
        userList.add(user.getUserName());
        System.out.printf("[Shop] User Added: %s\n", user.getUserName());
    }

    public void addItem(Item item){
        
    }



    @Override
    public int main(){
        return 0;
    }

    
    
}
