import java.util.Random;
import java.util.Arrays;

public class Song {
    private static String prefix="Old MacDonald had a farm e-i-e-i-o, and on this farm he had a ";
    private static String surfix = " e-i-e-i o, with a moo-moo here and a moo-moo there here a moo there a moo everywhere a moo-moo";
    private static String[] arr= {"cow", "sheep", "pig" , "chicken"};

    public Song(){}
    public String generate(){
        int[] ids={0,1,2,3};
        int[] newid=shuffle(ids);

        String s="";
        for (int i=0;i<arr.length;i++) {
            s+=prefix+arr[newid[i]]+surfix+",\n" ;
        }
        //s+='\n';
        return s;
    }

    private int[] shuffle(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Random rand = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j= rand.nextInt(i + 1);
            int tmp = copy[i];
            copy[i] = copy[j];
            copy[j] = tmp;
        }
        return copy;
    }

}
