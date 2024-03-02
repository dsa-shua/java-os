public class Item {
    public String name;
    private double price; 

    public Item(String setname, double setprice){
        this.name = setname;
        this.price = setprice;
        System.out.printf("New Item Created: [%s: $%.2f]\n", this.name, this.price);
    }

    public void details(){
        System.out.printf("[Item detail] %s: $%.2f\n", this.name, this.price);
    }

    public double getPrice(){
        return this.price;
    }
    
}
