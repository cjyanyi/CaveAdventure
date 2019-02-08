public class Monster {

    private String name;
    public Monster(String s){
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
