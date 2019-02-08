public class Adventure implements CaveTask {

    protected String description;
    protected Treasure treasure;
    protected Monster monster;
    protected textScanner scanner;
    protected String nextstr;

    protected static String nextadv=" 1) Move on to the next adventure";
    protected static String finalmission=" 1) Move on to the final mission";

    public Adventure (String description, String treasure, String monster, textScanner ts) {
        this.description = description;
        this.treasure = new Treasure(treasure);
        this.monster = new Monster(monster);
        this.scanner = ts;
        this.nextstr=nextadv;
        if (treasure.equals("golden helmet")) {
            this.nextstr=finalmission;
        }

    }

    public void run() throws Exception {
        int num=0;
        num=this.scanner.scanInt(2, '\n'+description);
        switch (num) {
            case 1:
                String ss="You slayed the " + monster + " and are sill alive, what would you like to do?\n" + nextstr +"\n 2) Pick up the "+treasure;
                int i=this.scanner.scanInt(2, ss);
                switch (i) {
                    case 1:
                        System.out.println("YOU ARE KILLED! You have to restart.");
                        throw new Exception();

                    case 2:
                        System.out.println("You have picked up the "+treasure+" and are still alive, you can move on to your next Adventure!");
                }

                break;
            case 2:
                System.out.println("You have picked up the treasure, now go rest before continuing the mission.");
                System.out.println((new Song()).generate());
                String s = "Great! You are awake and rested what would you like to do?\n 1) Attack the " + monster + " and turn off the goblin’s water supply";
                this.scanner.scanInt(1, s);
                s="You slayed the " + monster + " and are sill alive, what would you like to do?\n" + nextstr;
                this.scanner.scanInt(1, s);
                break;
        }

    }


}
