package jackson;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyObject {
	public String person;
    public String surname;
    
    @JsonCreator
    public MyObject(@JsonProperty("person")String person, @JsonProperty("surname")String surname) {
    	this.person = person;
    	this.surname = surname;
    }
    
}
