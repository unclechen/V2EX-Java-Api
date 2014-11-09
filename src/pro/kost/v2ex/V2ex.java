package pro.kost.v2ex;

import pro.kost.v2ex.beans.SiteInfo;
import pro.kost.v2ex.network.AbsRequest.OnResponse;


public class V2ex {
	public static void main(String[] args) {
		V2exManager.getSiteInfo(new OnResponse<SiteInfo>() {
			public void onRespondResult(SiteInfo result) {
				//DO whatever you want here
			}
		});
	}
}
