package JacksonJSON;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("C:\\Users\\Himanshu Kumar\\IdeaProjects\\DSA\\ProblemSolving\\src\\main\\java\\jackson\\data.json");
			InputStream in = new FileInputStream(file);
			System.out.println(in);
			InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("\"C:\\\\Users\\\\Himanshu Kumar\\\\IdeaProjects\\\\DSA\\\\ProblemSolving\\\\src\\\\main\\\\java\\\\jackson\\\\data.json\"");
			System.out.println(input);
			MyObject p = mapper.readValue(in, MyObject.class);// user null string with Mapper
			in.close();
			System.out.println(p.person + " " + p.surname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
