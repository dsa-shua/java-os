class Hello extends Program {

    public Hello(int setPID) {
        super(setPID, "hello");
    }

    @Override
    public int main(){
        System.out.println("Hello World!");
        return 0;
    }
    
}
