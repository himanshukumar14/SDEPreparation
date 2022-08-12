import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Arcesium {
	public static void main(String[] args) {
		List<String> query = new ArrayList<>();
		query.add("address.city");
		query.add("IN");
		query.add("Kolkata,Mumbai");
		List<Integer> x = searchUserData(query);
		for(int y : x) {
			System.out.println(y);
		}
	}
	
	private static final String uri = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

	private static String getUserData(User user, String query) {
		String[] key = query.split("\\.");
		if (key[0].equals("id")) {
			return String.valueOf(user.getId());
		} else if (key[0].equals("username")) {
			return user.getUsername();
		} else if (key[0].equals("name")) {
			return user.getName();
		} else if (key[0].equals("email")) {
			return user.getEmail();
		} else if (key[0].equals("address")) {
			if(key[1].equals("street")) {
				return user.getAddress().getStreet();
			} else if(key[1].equals("suite")) {
				return user.getAddress().getSuite();
			} else if(key[1].equals("city")) {
				return user.getAddress().getCity();
			} else if(key[1].equals("zipcode")) {
				return user.getAddress().getZipcode();
			} else if(key[1].equals("geo")) {
				if(key[2].equals("lat")) {
					return user.getAddress().getGeo().getLat();
				} else if(key[1].equals("lng")) {
					return user.getAddress().getGeo().getLng();
				}
			}
		} else if (key[0].equals("website")) {
			return user.getWebsite();
		} else if (key[0].equals("company")) {
			if(key[1].equals("name")) {
				return user.getCompany().getName();
			} else if(key[1].equals("basename")) {
				return user.getCompany().getBasename();
			}
		}
		return "";
	}

	public static List<Integer> searchUserData(List<String> query) {
		String jsonString = getApiData(uri);
		User[] user = mapResponseToObject(jsonString);

		if (query.get(1).equals("EQUALS")) {
			return getEqualsQueryValue(user, query.get(0), query.get(2));
		} else {
			return getInQueryValue(user, query.get(0), query.get(2));
		}
	}

	public static List<Integer> getEqualsQueryValue(User[] user, String key, String value) {
		List<Integer> ans = new ArrayList<>();
		for(int i = 0; i < user.length; ++i) {
			String val = getUserData(user[i], key);
			if(val.equals(value))
				ans.add(user[i].getId());
		}
		return ans;
	}

	public static List<Integer> getInQueryValue(User[] user, String key, String value) {
		List<Integer> ans = new ArrayList<>();
		String[] valArr = value.split(",");
		for (int i = 0; i < user.length; ++i) {
			String val = getUserData(user[i], key);
			for(String v : valArr) {
				if(val.equals(v))
					ans.add(user[i].getId());
			}
		}
		return ans;
	}

	public static String getApiData(String urll) {
		try {
			URL url = new URL(urll);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			String inline = "";
			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				inline += scanner.nextLine();
			}

			scanner.close();
			return inline;
		} catch (Exception e) {
			System.out.println("exception code =" + e);
		}
		return "";
	}

	public static User[] mapResponseToObject(String response) {
		User[] user = null;
		try {
			Gson gson = new GsonBuilder().create();
			user = gson.fromJson(response, User[].class);
		} catch (Exception ex) {
			System.out.println("error in holding gson parding =[" + ex + "]");
		}
		return user;
	}

	public class User {
		private int id;
		private String name;
		private String username;
		private String email;
		private Address address;
		private String website;
		private Company company;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}
	}

	public class Address {
		private String street;
		private String suite;
		private String city;
		private String zipcode;
		private Geolocation geo;

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getSuite() {
			return suite;
		}

		public void setSuite(String suite) {
			this.suite = suite;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public Geolocation getGeo() {
			return geo;
		}

		public void setGeo(Geolocation geo) {
			this.geo = geo;
		}

	}

	private class Geolocation {
		private String lat;
		private String lng;

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}

	}

	public class Company {
		private String name;
		private String basename;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBasename() {
			return basename;
		}

		public void setBasename(String basename) {
			this.basename = basename;
		}

	}
}
