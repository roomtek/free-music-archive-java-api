package app.odesanmi.fma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;

public class FMAClient {

	private String apikey;
	private String urlprefix = "http://freemusicarchive.org/api/get/";

	public FMAClient(String api) {
		apikey = api;

	}

	String getAllArtists() {

		return urlprefix.concat("artists").concat(".xml?api_key=")
				.concat(apikey);
	}

	String getAllCurators() throws Exception {

		String urla = urlprefix.concat("curators").concat(".xml?api_key=")
				.concat(apikey);

		Element ele = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new URL(urla).openStream()).getDocumentElement();
		ele.normalize();

		// System.out.println("root of document = " + ele.getNodeName());
		// ele.getChildNodes().getLength() // number of curators
		return ele.getElementsByTagName("*").item(0).getNodeName();
		

	}

	String getCuratorDataSet(String dataset, String value) throws Exception {
		String urla = urlprefix.concat("curators").concat(".xml?api_key=")
				.concat(apikey).concat("&" + dataset).concat("=").concat(value);

		URL url = new URL(urla);
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream(),
					"UTF-8"));
			for (String line; (line = reader.readLine()) != null;) {
				builder.append(line.trim());
			}

		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException logOrIgnore) {
				}
		}

		return builder.toString();

	}

	String getAllAlbums() {

		return urlprefix.concat("albums").concat(".xml?api_key=")
				.concat(apikey);
	}

	String getAllGenres() {

		return urlprefix.concat("genres").concat(".xml?api_key=")
				.concat(apikey);
	}

	String getAllTracks() {

		return urlprefix.concat("tracks").concat(".xml?api_key=")
				.concat(apikey);
	}

}
