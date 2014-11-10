package pro.kost.v2ex;

import pro.kost.v2ex.beans.NodeList;
import pro.kost.v2ex.beans.SiteInfo;
import pro.kost.v2ex.beans.SiteStats;
import pro.kost.v2ex.network.AbsRequest.OnResponse;


public class V2ex {
	public static void main(String[] args) {
		V2exManager.getNodesAll(new OnResponse<NodeList>() {
			
			public void onRespondResult(NodeList result) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
