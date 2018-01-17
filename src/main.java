import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		String animeSearch = "Kill+la+kill";
		String url = "http://openings.ninja/" + animeSearch + "/op/1";
		Document doc = Jsoup.connect(url).get();
        
		ArrayList<String> ar = new ArrayList<String>();
		String themeout = null;
		for (Element link : doc.select("#mirror > li")) {
		    String urlout = link.attr("data-url");
		    themeout = link.attr("data-theme");
		    //String output = urlout;
		    String output = themeout+":" + urlout;
		    if(output.indexOf("youtube") <0 && output.indexOf("web.archive.org") <0){
		    	//String outputlink = output.substring(themeout.length());
		    	ar.add(output);
	        }
		}
		
		//System.out.println(ar);
		int mirrorSelect = 0;
		
		if (Desktop.isDesktopSupported()) {
		    Desktop.getDesktop().browse(new URI(ar.get(mirrorSelect).substring(themeout.length() + 1)));
		}
		
		
		
	}

}
