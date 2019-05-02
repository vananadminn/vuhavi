package ClientCallToServer;

import java.util.Scanner;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CallToServer {

	public static void main(String[] args) {
		getid();
	}

	public static String getid() {
		String url = null;
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id: ");
		if (sc.hasNextInt()) {
			id = sc.nextInt();
			url = "http://localhost:8888/api/product/" + id;
			System.out.println("URL: " + url);
			try {
				Client client = Client.create();
				WebResource webResource = client.resource((url));
				ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
				try {
					if (response.getStatus() == 200) {
						String output = response.getEntity(String.class);
						System.out.println("Output from Server .... \n");
						System.out.println(output + response.getStatus());
					} else {
						String error = response.getEntity(String.class);
						System.out.println("Failed with HTTP Error code:");
						System.out.println("Error: " );
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("Server has been closed");
			}

		} else {
			System.out.println("Error data type");
		}
		return url;
	}

}
