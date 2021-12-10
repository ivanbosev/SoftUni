import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector02 {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        String numberRegex = "\\d";
        String emojiRegex = "([\\\\*:])\\1([A-Z][a-z]{2,})\\1\\1";

        Pattern numberPattern = Pattern.compile ( numberRegex );
        Matcher numberMatcher = numberPattern.matcher ( input );
        List<Integer> numberList = new ArrayList<> ( );

        while (numberMatcher.find ( )) {
            int number = Integer.parseInt ( numberMatcher.group ( ) );
            numberList.add ( number );
        }

        long coolnes = numberList.stream ( ).reduce ( 1, ( a, b ) -> a * b );

        System.out.println ( "Cool threshold: " + coolnes );

        Pattern emojiPattern = Pattern.compile ( emojiRegex );
        Matcher emojiMatcher = emojiPattern.matcher ( input );

        List<String> emojis = new ArrayList<> ( );
        List<String> totalFoundEmojis = new ArrayList<> ( );
        while (emojiMatcher.find ( )) {
            totalFoundEmojis.add ( emojiMatcher.group ( 0 ) );
            String separator = emojiMatcher.group ( 1 );
            String emojiText = emojiMatcher.group ( 2 );
            if (isEmojiCool ( emojiText, coolnes )) {
                String fullEmojis = separator + separator + emojiText + separator + separator;
                emojis.add ( fullEmojis );
            }
        }
        System.out.printf ( "%d emojis found in the text. The cool ones are:%n", totalFoundEmojis.size ( ) );

        emojis.stream ( ).forEach ( System.out::println );
    }

    public static boolean isEmojiCool ( String emojiText, long coolnesTtreshhold ) {
        long emojiCoolnes = 1;
        for (int i = 0; i < emojiText.length ( ); i++) {
            char emojiCharacter = emojiText.charAt ( i );
            emojiCoolnes += emojiCharacter;
        }
        return emojiCoolnes >= coolnesTtreshhold;
    }
}
