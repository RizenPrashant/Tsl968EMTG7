package createAccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CreateAccount {
	public static void details(String url, String un) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/repo.property"));
		url = prop.getProperty("url");
		un = prop.getProperty("username");
	}
}
