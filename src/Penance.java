import java.util.Random;
public class Penance {
    private String name;
    private textScanner ts;

    public Penance (textScanner ts){
        name="";
        this.ts=ts;
        //generate();
    }
    public void generate() {
        Random rand = new Random();
        if (rand.nextInt()%2==1) {
            sing();
        }
        else {
            math();
        }

    }

    private void sing() {
        name="to sing the Twelve Days of Christmas.";
        System.out.println("They tricked you into picking up a second treasure, your penance is "+name);

        System.out.println("On the first day of Christmas my true love gave to me, a partridge in a pear tree\n" +
                "On the second day of Christmas my true love gave to me, two turtle doves and a partridge in a pear tree.\n" +
                "On the third day of Christmas my true love gave to me, three French hens, two turtle doves and a partridge in a pear tree. Etc.....");
    }
    private void math(){
        name="to perform 5 random math equations.";
        System.out.println("They tricked you into picking up a second treasure, your penance is "+name);

        Random rand = new Random();
        for (int i=0;i<5;i++){
            int res = rand.nextInt(10);
            int a = rand.nextInt(10);
            System.out.println("x + "+String.valueOf(a)+" = "+String.valueOf(a+res) + ", x=?");
            int input=ts.nextInt();
            while(input!=res) {
                System.out.println("Your answer is wrong!");
                input=ts.nextInt();
            }
        }
    }
}
