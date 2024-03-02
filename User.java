public class User {
    private String username;
    private String password = "";
    private Boolean locked = false;

    

    public User(String setname){
        System.out.printf("User created: %s\n", setname);
        this.username = setname;
    }

    public User(String setname, String setpassword){
        System.out.printf("User created: %s with password\n", setname);
        this.username = setname;
        this.password = setpassword;
        this.locked = true;
    }

    public String getUserName(){
        return this.username;
    }

    public Boolean hasPassword(){
        return this.locked;
    }

    // Checks if the password is correct.
    // Use for verification...
    public Boolean verify(String input){
        return (input.equals(this.password));
    }


    // Buy something from the job
    public void buy(String item, int quantity){
        
    }

    

    
}
