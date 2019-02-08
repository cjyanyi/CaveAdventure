public class Treasure {
    private String name;
    public Treasure(String s){
        this.name = s;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public void update(String s){
        this.name=s;
    }
}
