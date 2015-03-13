This is a freemusicarchive.org java api. Users must obtain a developer key from the website freemusicarchive.org to allow them make calls to FMA via this  Java API.

Usage:
```

static String API = "YOUR_API_KEY_GOES_HERE";
FMAClient fmaclient = new FMAClient(API);

// to get curators with limit = 34
NodeList nlist = fmaclient.getCurators(34);

// to get track list for a specific album, where album_id = 8662 , and limit = 20
NodeList nlist = fmaclient.getTracksForAlbumID("8662", 20);


// to get albums by curator, where the curator_id = 1 and limit = 10
NodeList nlist = fmaclient.getAlbumsForCuratorID("1", 10);

int l = nlist.item(0).getParentNode().getChildNodes().getLength();
for (int n = 0; n < l; n++) {
  System.out.println(d.getElementsByTagName(FMAClient.album_title).item(n).getTextContent());
  System.out.println(d.getElementsByTagName(FMAClient.album_id).item(n).getTextContent());
  System.out.println(d.getElementsByTagName(FMAClient.album_type).item(n).getTextContent());
  System.out.println(d.getElementsByTagName(FMAClient.album_date_released).item(n).getTextContent());
 }

```