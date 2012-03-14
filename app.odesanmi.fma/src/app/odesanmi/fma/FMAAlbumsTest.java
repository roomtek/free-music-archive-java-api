package app.odesanmi.fma;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class FMAAlbumsTest {

	static String API = "7GU7FIOUDXXXXXXXXX";

	public static void main(String[] args) {

		FMAClient fmaclient = new FMAClient(API);

		try {
			// get first curator
			NodeList nlist = fmaclient.getAlbumsForCuratorID("1", 0);
			Document d = nlist.item(0).getOwnerDocument();

			int l = nlist.item(0).getParentNode().getChildNodes().getLength();
			for (int n = 0; n < l; n++) {

				System.out.println(d
						.getElementsByTagName(FMAClient.album_title).item(n)
						.getTextContent());
				System.out.println(d.getElementsByTagName(FMAClient.album_id)
						.item(n).getTextContent());
				System.out.println(d.getElementsByTagName(FMAClient.album_type)
						.item(n).getTextContent());
				System.out.println(d.getElementsByTagName(FMAClient.album_date_released)
						.item(n).getTextContent());

				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
