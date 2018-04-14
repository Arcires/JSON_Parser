import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) throws Exception {

        //Parsing the source *.json file. Switch to either dist_persons, or dist_locations for best results."
        Object obj = new JSONParser().parse(new FileReader("src/dist_persons.json"));

        //typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        //Retrieve 'persons'
        Map persons = ((Map) jo.get("Persons"));

        //Iterating persons Map
        for (Map.Entry pair : (Iterable<Map.Entry>) persons.entrySet()) {
            String rawName = (String) persons.get("name");
            String mail = (String) persons.get("email");
            String desc = (String) persons.get("description");
            String pictureURL = (String) persons.get("pictureURL");
            String role = (String) persons.get("role");
            String roomName = (String) persons.get("roomName");

            System.out.println("('" + rawName + "', '" + mail + "', '" + desc + "', '" + pictureURL + "', '" + role + "', '" + roomName + "),\n");
        }

        //while (itr1.hasNext()) {
        //   Map.Entry pair = itr1.next();
        //   System.out.println(pair.getKey() + " : " + pair.getValue());
        //}
    }
}
