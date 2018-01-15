import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String url = "http://openings.ninja/Kill+la+Kill/op/1";
		String oped = "ed";
		Document doc = Jsoup.connect(url).get();
        
		ArrayList<String> ar = new ArrayList<String>();
		
		for (Element link : doc.select("#mirror > li")) {
		    String urlout = link.attr("data-url");
		    String themeout = link.attr("data-theme");
		    String output = urlout;
		    //String output = themeout+":" + urlout;
		    if(output.indexOf("youtube") <0){
	            ar.add(output);
	        }
		}   
		System.out.println(ar);
		if (Desktop.isDesktopSupported()) {
		    Desktop.getDesktop().browse(new URI(ar.get(3)));
		}
		
		
		
	}

}
