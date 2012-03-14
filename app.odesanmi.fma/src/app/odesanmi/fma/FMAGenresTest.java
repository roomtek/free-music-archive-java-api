package app.odesanmi.fma;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class FMAGenresTest {

	static String API = "7GU7FIOUDXXXXXXXXX";

	public static void main(String[] args) {

		FMAClient fmaclient = new FMAClient(API);

		try {
			// get first curator
			NodeList nlist = fmaclient.getGenresForCuratorID("1", 50);
			Document d = nlist.item(0).getOwnerDocument();

			int l = nlist.item(0).getParentNode().getChildNodes().getLength();
			for (int n = 0; n < l; n++) {

				System.out.println(d
						.getElementsByTagName(FMAClient.genre_title).item(n)
						.getTextContent());
				System.out.println(d.getElementsByTagName(FMAClient.genre_id)
						.item(n).getTextContent());

				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
