package practice;



import java.io.IOException;

import com.base_class.BaseClass;

public class demo extends BaseClass{
	public static void main(String[] args) throws IOException {
		LaunchBrowser();
		LaunchUrl("https://www.flipkart.com/");
		Screnshot("flip");
		getTitle();
	}

}
