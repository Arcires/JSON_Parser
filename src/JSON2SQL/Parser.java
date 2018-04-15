package JSON2SQL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static void main(String[] args) throws Exception {

        //Parsing the source *.json file. Switch to either dist_persons, or dist_locations for best results."
        JSONObject objPersons = (JSONObject) ((JSONObject) new JSONParser().parse(new FileReader("src/JSON2SQL/dist_persons.json"))).get("Persons");

        HashMap<String, HashMap> persons = new HashMap<>();
        persons.putAll(objPersons);

        for (Map.Entry<String, HashMap> entryPersons : persons.entrySet()) {
            String pplRawName = (String) entryPersons.getValue().get("name");
            String pplMail = (String) entryPersons.getValue().get("email");
            String pplDesc = (String) entryPersons.getValue().get("description");
            String pplPictureURL = (String) entryPersons.getValue().get("pictureURL");
            String pplRole = (String) entryPersons.getValue().get("role");
            String pplRoomName = (String) entryPersons.getValue().get("roomName");

            System.out.println("(\"" + pplRawName + "\", \"" + pplMail + "\", \"" + pplDesc + "\", \"" + pplPictureURL + "\", \"" + pplRole + "\", \"" + pplRoomName + "\"),");
        }

        JSONObject objLocations = (JSONObject) ((JSONObject) new JSONParser().parse(new FileReader("src/JSON2SQL/dist_locations.json"))).get("Locations");

        HashMap<String, HashMap> locations = new HashMap<>();
        locations.putAll(objLocations);

        for (Map.Entry<String, HashMap> entryLocations : locations.entrySet()) {
            String locName = (String) entryLocations.getValue().get("name");
            String locDesc = (String) entryLocations.getValue().get("description");
            String locFloor = (String) entryLocations.getValue().get("floor");
            String locLandmark = (String) entryLocations.getValue().get("landmark");

            /* Experimental portion. Needs further work to correctly import positions.

            JSONObject objPositions= (JSONObject) ((JSONObject) new JSONParser().parse(new FileReader("src/JSON2SQL/dist_locations.json"))).get("position");

            HashMap<String, HashMap> positions = new HashMap<>();
            positions.putAll(objPositions);



            for (Map.Entry<String, HashMap> entryPositions : locations.entrySet()) {
                String locPosLatitude = (String) entryPositions.getValue().get("latitude");
                String locPosLongitude = (String) entryPositions.getValue().get("longitude");
                System.out.println(locPosLatitude + locPosLongitude);
            }*/

            System.out.println("(\"" + locName + "\", \"" + locDesc + "\", \"" + locFloor + "\", \"" + locLandmark + "\"),");

        }
    }
}

