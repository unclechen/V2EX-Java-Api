package pro.kost.v2ex;

import java.util.HashMap;

import pro.kost.v2ex.network.AbsRequest.OnResponse;
import pro.kost.v2ex.network.ConcreteRequest;


public class V2ex {

	public static void main(String[] args) {
	
		ConcreteRequest request = new ConcreteRequest();
		request.setOnResponse(new OnResponse() {
			public void onRespondResult(String result) {
				System.out.println(result);
			}
		});
		request.executeReadAsync(Addrs.nodes_all);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "kost");
	}

}
