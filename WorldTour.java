import java.util.Scanner;

public class WorldTour {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        StringBuilder allStops = new StringBuilder ( scanner.nextLine ( ) );

        String command = scanner.nextLine ( );

        while (!command.equals ( "Travel" )) {

            String[] commandParts = command.split ( ":" );
            switch (commandParts[0]) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt ( commandParts[1] );
                    String insertString = commandParts[2];
                    if (isValidIndex ( allStops,insertIndex )) {
                        allStops.insert ( insertIndex, insertString );
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt ( commandParts[1] );
                    int endIndex = Integer.parseInt ( commandParts[2] );
                    if (isValidIndex ( allStops,startIndex ) && isValidIndex ( allStops,endIndex )) {
                        allStops.replace ( startIndex, endIndex + 1, "" );
                    }
                    break;
                case "Switch":
                    String oldtString = commandParts[1];
                    String newtString = commandParts[2];
                    allStops = new StringBuilder ( allStops.toString ( ).replace ( oldtString, newtString ) );
                    break;
                default:
                    System.out.println ( "unknown command:" + command );
                    break;
            }
            System.out.println ( allStops );
            command = scanner.nextLine ( );
        }
        System.out.println ( "Ready for world tour! Planned stops: " + allStops );
    }
    static boolean isValidIndex (StringBuilder string, int index){
        return index >=0 && index < string.length ();
    }
}
