package futsal.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWebData {
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("https://www.vlcm.net/rc/pc/indexPc.php?action_CRA08_01do=true&isSearch=1&cid=00127");
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			InputStream in = httpConn.getInputStream();
			BufferedReader r = new BufferedReader(new InputStreamReader(in, "Shift_JIS"));
			StringBuilder lines = new StringBuilder();
			for (;;) {
				String line = r.readLine();
				if (line == null) {
					break;
				}
				lines.append(line+"\n");
			}
			System.out.println(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
