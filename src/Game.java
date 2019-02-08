import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;

public class Game {
    protected textScanner scanner;
    protected Player player;

    public Game() {

        this(null);
    }
    public Game(java.io.File save) {

        // Parse room from file
        this.scanner = new textScanner();
        acceptTask();

    }

    public void start() throws NullPointerException {
        try {
            arrangeAdventure(3);
        } catch(Exception n) {
            start();
        }

        /*
        try {
            String input = "";
            while(input.compareTo("quit") != 0) {
                System.out.print("> ");
                input = this.scanner.nextLine();
            }
            }catch(Exception n) {
                System.out.println("I don't understand that \n\nException: \n" + n);
                n.printStackTrace();
                start();
            }*/
    }

    public void acceptTask(){
        System.out.println("Brave knight!!! What is your name?");
        this.player = new Player(this.scanner.next());
        System.out.println("We are in need of your help, "+this.player.getName()+'!');
        System.out.println("Our village is being overrun by the goblins of the NorthernCaves. \nWe need you to defeat them!");
        String input="";
        while(!input.equals("Y")) {
            System.out.println("Will you accept the challenge (Y/N)?");
            input = this.scanner.next();
        }
        System.out.println("Thank You Thank You Oh brave knight, are you ready to enter the mouth of the caves (Y/N)?");
        input=this.scanner.next();
        while(!input.equals("Y")) {
            System.out.println(".... Please, please help up brave knight, are you ready to enter the mouth of the caves (Y/N)?");
            input=this.scanner.next();
        }
    }

    private void arrangeAdventure(int num) throws Exception {
        ArrayList<CaveTask> al = new ArrayList<>();
        int seed=(new Random()).nextInt(num);
        for (int i=0;i<num;i++) {
            CaveTask t= (i==seed)? new AdventureTrick(AdvDescp[i],treasures[i],monsters[i],scanner) : new Adventure(AdvDescp[i],treasures[i],monsters[i],scanner);
            al.add(t);
        }
        al.add(new FinalMission("final mission","", "", scanner));

        for (CaveTask t:al) {
            t.run();
        }
    }

    private static String[] AdvDescp ={
            "You are now entering the mouth of the cave, what would you like to do?\n" +
            "1) Attack the evil goblin and clean all the cob webs\n" +
            "2) Pick up the golden sword",
            "You have ventured deeper into the cave, what would you like to do?\n" +
                    "1) Attack the evil wombat and turn off the goblin’s water supply\n" +
                    "2) Pick up the golden shield",
            "Great! You have now reached the depths of the caves, what would you like to do?\n" +
                    "1) Attack the hobgoblin lord\n" +
                    "2) Pick up the golden helmet"};
    private static String[] monsters ={"evil goblin Marcel","evil wombat Limpian","hobgoblin lord DivaDon"};
    private static String[] treasures = {"golden sword","golden shield","golden helmet"};

}
