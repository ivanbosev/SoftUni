import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfBarcodes = Integer.parseInt ( scanner.nextLine ( ) );
        String regex = "(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";
        Pattern pattern = Pattern.compile ( regex );

        for (int i = 0; i < numberOfBarcodes; i++) {

            String input = scanner.nextLine ( );
            Matcher matcher = pattern.matcher ( input );

            if (matcher.find ( )) {
                Pattern patternOfDigits = Pattern.compile ( "\\d" );
                matcher = patternOfDigits.matcher ( input );
                String result = "";
                while (matcher.find ( )) {
                    result += matcher.group ( );
                }
                if (result.equals ( "" )) {
                    result = "00";
                }
                System.out.println ( "Product group: " + result );
            } else {
                System.out.println ( "Invalid barcode" );
            }
        }
    }
}
