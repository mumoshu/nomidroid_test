package jp.mumoshu.app.nomi.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import jp.mumoshu.app.nomi.R;
import jp.mumoshu.http.Http;
import jp.mumoshu.http.HttpStub;
import jp.mumoshu.webapi.hotpepper.HotpepperCondition;
import jp.mumoshu.webapi.hotpepper.HotpepperData;
import jp.mumoshu.webapi.hotpepper.HotpepperSearch;
import jp.mumoshu.webapi.hotpepper.Point;

import org.json.JSONException;

import android.test.AndroidTestCase;

public class HotpepperSearchTest extends AndroidTestCase {

	private HotpepperSearch search;

	public void testHotpepperSearch() {
		fail("Not yet implemented");
	}

	public void testExecute() throws MalformedURLException, IOException, JSONException {
		HotpepperData result = search.execute();
		assertEquals("1åèñ⁄Ç™Åuéë† è† ëÂçËìXÅv", result.getSpots().get(0).getName(), "éë† è† ëÂçËìX");
	}

	public void testNextPage() {
		fail("Not yet implemented");
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		final String stubName = "http://webservice.recruit.co.jp/hotpepper/gourmet/v1?key=4e134a6779786c91&lat=35.619911&lng=139.728175";
		InputStream in = getContext()
			.getResources()
			.openRawResource(R.raw.v1_json);
		Http.setHttpClient(new HttpStub(stubName, in));
		
		this.search = new HotpepperSearch(new HotpepperCondition(new Point(1, 2)), "<apiKey>");
	}
}
