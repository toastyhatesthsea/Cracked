package Strings;

import java.util.HashMap;

public class StringCompression
{
    String someString;
    HashMap<Character, Integer> collectionOfChars;

    public StringCompression(String aString)
    {
        someString = aString;
        collectionOfChars = new HashMap<>();
    }

    private void collectValues()
    {
        HashMap<Character, Integer> collectionOfChars = new HashMap<>();

        for (int i = 0; i < someString.length(); i++)
        {
            char aChar = someString.charAt(i);

            if (collectionOfChars.putIfAbsent(aChar, 1) != null)
            {
                int aValue = collectionOfChars.get(aChar);
                collectionOfChars.put(aChar, aValue + 1);
            }
        }
    }

    public String compressString()
    {
        char current = 0;
        char next = 0;
        int currentSameCount = 1;
        String returnString = "";

        for (int i = 0; i + 1 < someString.length(); i++)
        {
            current = someString.charAt(i);
            next = someString.charAt(i + 1);

            if (current == next)
            {
                currentSameCount++;
                if (i + 2 >= someString.length())
                {
                    returnString = returnString.concat(Character.toString(current) + currentSameCount);
                }
            } else //Reset counter
            {
                returnString = returnString.concat(Character.toString(current) + currentSameCount);
                currentSameCount = 1;

                if (i + 2 >= someString.length())
                {
                    returnString = returnString.concat(Character.toString(next) + currentSameCount);
                }
            }
        }
        if (returnString.length() >= someString.length())
        {
            return someString;
        } else
        {
            return returnString;
        }
    }
}


class CompressionTesters
{
    public static void main(String[] asdasdasd)
    {
        StringCompression aCompressor = new StringCompression("aabbc");
        aCompressor.compressString();
    }
}