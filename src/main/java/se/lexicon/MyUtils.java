package se.lexicon;

import java.util.Arrays;

public class MyUtils {

    public static String[] addToArray(String[] source, String value){

        //Copy and expand array
        String[] newArray = Arrays.copyOf(source,source.length +1);

        //Add Element in the array.
        newArray[newArray.length -1] = value;

        return newArray;

    }
}
