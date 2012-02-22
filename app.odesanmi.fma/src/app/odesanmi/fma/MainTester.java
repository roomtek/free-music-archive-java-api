package app.odesanmi.fma;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class MainTester {

	static String API = "7GU7FIOUDBBXXXX"; // DEVELOPER API KEY PLEASE REPLACE

	public static void main(String[] args) {

		FMAClient fmaclient = new FMAClient(API);

		try {
			// get first curator
			NodeList nlist = fmaclient.getCurators(1);
			Document d = nlist.item(0).getOwnerDocument();

			// int l =
			// nlist.item(0).getParentNode().getChildNodes().getLength();
			// for (int n = 0; n < l; n++) {

			System.out.println(d.getElementsByTagName(FMAClient.curator_title)
					.item(0).getTextContent());
			System.out.println(d.getElementsByTagName(FMAClient.curator_id)
					.item(0).getTextContent());

			// System.out.println(d
			// .getElementsByTagName(FMAClient.CURRATORTAGLINE)
			// .item(n).getTextContent());
			//
			// System.out.println(d
			// .getElementsByTagName(FMAClient.CURRATORIMAGE).item(n)
			// .getTextContent());

			System.out.println();
			// }

			// get first album
			nlist = fmaclient.getAlbumsForCuratorID(
					d.getElementsByTagName(FMAClient.curator_id).item(0)
							.getTextContent(), 1);
			d = nlist.item(0).getOwnerDocument();

			System.out.println(d.getElementsByTagName(FMAClient.album_title)
					.item(0).getTextContent());

			System.out.println(d.getElementsByTagName(FMAClient.album_id)
					.item(0).getTextContent());

			System.out.println();

			// get first track in album
			nlist = fmaclient.getTracksForAlbumID(
					d.getElementsByTagName(FMAClient.album_id).item(0)
							.getTextContent(), 1);
			d = nlist.item(0).getOwnerDocument();

			System.out.println(d.getElementsByTagName(FMAClient.track_title)
					.item(0).getTextContent());

			System.out.println(d.getElementsByTagName(FMAClient.track_id)
					.item(0).getTextContent());

			// get downloadlink for first track
			String url = fmaclient.getTracksDownloadLinkForTrackID(d
					.getElementsByTagName(FMAClient.track_id).item(0)
					.getTextContent());

			System.out.println(url);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
