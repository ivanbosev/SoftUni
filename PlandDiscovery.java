import java.util.*;

public class PlandDiscovery {

    static class Plant {
        String name;
        int rarity;
        List<Double> ratings;

        public Plant ( String name, int Rarity ) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<> (  );
        }

        public String getName () {
            return name;
        }

        public void setRarity ( int rarity ) {
            this.rarity = rarity;
        }

        public void addRating ( double rating ) {
            this.ratings.add ( rating );
        }

        public void ressetRating () {
            this.ratings.clear ( );
        }
    }

    public static void main ( String[] args ) {
        Map<String, Plant> plantsByName = new HashMap<> ( );
        Scanner scanner = new Scanner ( System.in );
        int n = Integer.parseInt ( scanner.nextLine ( ) );

        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scanner.nextLine ( ).split ( "<->" );
            Plant p = new Plant ( nameAndRarity[0], Integer.parseInt ( nameAndRarity[1] ) );
            plantsByName.put ( p.getName ( ), p );
        }

        String command = scanner.nextLine ( );

        while (!command.equals ( "Exhibition" )) {
            String[] commandAdnParamenters = command.split ( ": " );

            switch (commandAdnParamenters[0]) {

                case "Rate":
                    String[] rateParameters = commandAdnParamenters[1].split ( " - " );
                    String ratePlant = rateParameters[0];
                    int rating = Integer.parseInt ( rateParameters[1] );
                    plantsByName.get ( ratePlant ).addRating ( rating );
                    break;
                case "Update":
                    String[] updateParameters = commandAdnParamenters[1].split ( " - " );
                    String updatePlantName = updateParameters[0];
                    int rarity = Integer.parseInt ( updateParameters[1] );
                    plantsByName.get ( updatePlantName ).setRarity ( rarity );
                    break;
                case "Reset":
                    String ressetPlantName = commandAdnParamenters[1];
                    plantsByName.get ( ressetPlantName ).ressetRating ( );
                    break;
                default:
                    System.out.println ( "error" );
                    break;
            }

            command = scanner.nextLine ( );
        }
        System.out.println ("Plants for the exhibition:" );
        plantsByName.values ()
                .stream ()
                .map ( p -> " " + p.getName () + ":Rarity " + p.ge

        }
    }
}
