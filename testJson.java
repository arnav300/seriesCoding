import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 * @author Arnav Bhati
 *
 */
public class testJson {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	public static void main(String[] args) throws JsonProcessingException, IOException {

		try {
			Object obj = new JSONParser().parse(new FileReader(
					"readJson.json"));

			JSONObject jo = (JSONObject) obj;

			String fname = (String) jo.get("firstName");

			JSONArray jarr = (JSONArray) jo.get("phoneNumbers");
			JSONArray jarr1 = (JSONArray) jo.get("cars");

			// read json file data to String
			byte[] jsonData = Files.readAllBytes(
					Paths.get("employee.txt"));

			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			// read JSON like DOM Parser
			JsonNode rootNode = objectMapper.readTree(jsonData);
			JsonNode idNode = rootNode.path("id");
			System.out.println("id = " + idNode.asInt());

			JsonNode phoneNosNode = rootNode.path("phoneNumbers");
			Iterator<JsonNode> elements = phoneNosNode.getElements();
			while (elements.hasNext()) {
				JsonNode phone = elements.next();
				System.out.println("Phone No = " + phone.asLong());
			}

			JsonNode addressNodes = rootNode.path("address");
			Iterator<JsonNode> elements1 = addressNodes.getElements();
			while (elements1.hasNext()) {
				JsonNode city = elements1.next();
				System.out.println("cities = " + city.toString());
			}

			for (int i = 0; i < jarr.size(); i++) {
				System.out.println(jarr.get(i));

				if (jarr.get(i) == "212 555-1234") {
					System.out.println("hello");
				}
			}

			for (int i = 0; i < jarr1.size(); i++) {
				System.out.println(jarr1.get(i));

				if (jarr1.get(i) == "212 555-1234") {
					System.out.println("hello");
				}
			}

			System.out.println(fname);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch bloFk
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

