public class AdventureTrick extends Adventure {
    private Penance p;
    public AdventureTrick (String description, String treasure, String monster, textScanner ts) {
        super(description,treasure,monster,ts);
        p=new Penance(ts);
    }

    public void run() throws Exception {
        int num=0;
        num=this.scanner.scanInt(2,'\n'+description);
        switch (num) {
            case 1: // kill monster
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
            case 2: // grab the treasure
                System.out.println("You have picked up the treasure, now go rest before continuing the mission.");
                System.out.println((new Song()).generate());
                String s = "Great! You are awake and rested what would you like to do?\n 1) Attack the " + monster + " and turn off the goblin’s water supply"+
                        "\n 2) Pick up the silver tray of life";

                int nostop=1;
                while (nostop>0) {
                    int k = this.scanner.scanInt(2, s);
                    switch (k) {
                        case 1: // kill moster
                            ss="Oh brave knight, you were not tricked and have killed the "+monster+ ", what would you like to do?\n" + nextstr;
                            textScanner.scanInt(1,ss);
                            nostop=0;
                            break;
                        case 2: // do penance
                            p.generate();
                            s="Great! You have done your penance, what would you like to do?\n 1) Attack the " + monster + " and turn off the goblin’s water supply"+
                            "\n Pick up the silver tray of life";
                            break;
                    }
                }
        }
    }
}
