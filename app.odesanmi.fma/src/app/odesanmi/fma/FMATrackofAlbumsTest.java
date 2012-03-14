package app.odesanmi.fma;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class FMATrackofAlbumsTest {

	static String API = "7GU7FIOUXXXXXXXXXXX";

	public static void main(String[] args) {

		FMAClient fmaclient = new FMAClient(API);

		try {
			// get first curator
			NodeList nlist = fmaclient.getTracksForAlbumID("8662", 20);
			Document d = nlist.item(0).getOwnerDocument();

			int l = nlist.item(0).getParentNode().getChildNodes().getLength();

			for (int n = 0; n < l; n++) {

				System.out.println(d
						.getElementsByTagName(FMAClient.track_title).item(n)
						.getTextContent());
				System.out.println(d.getElementsByTagName(FMAClient.track_id)
						.item(n).getTextContent());
				System.out.println(d.getElementsByTagName(FMAClient.track_url)
						.item(n).getTextContent());
				System.out.println(d
						.getElementsByTagName(FMAClient.track_composer).item(n)
						.getTextContent());

				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
