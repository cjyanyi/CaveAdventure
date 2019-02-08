import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class FinalMission extends Adventure {

    public FinalMission(String description, String treasure, String monster, textScanner ts) {
        super(description,treasure,monster,ts);
    }

    public void run() throws Exception {
        System.out.println("Are you ready for the final mission?");
        //String[] inputs = new String[100];
        HashSet<String> hs = new HashSet<>();
        String s;
        for (int i=0; i<100; i++){
            System.out.println("Village Idiot #" + String.valueOf(i+1)+", what is your special word?");
            System.out.print("> ");
            s = textScanner.nextLine();
            if (s.equals("quit")) {
                break;
            }
            hs.add(s);
        }
        System.out.println("Generate the poem made up of a random selection of the special words entered and you are DONE!");
        System.out.println(poem(hs.toArray()));
    }

    private String poem(Object[] arr) {
        Random rand = new Random();


        for (int i = arr.length - 1; i > 0; i--) {
            int j= rand.nextInt(i + 1);
            String tmp = (String) arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        String s="";
        for (Object n:arr) {
            s+=((String) n+' ');
        }
        return s;
    }
}
