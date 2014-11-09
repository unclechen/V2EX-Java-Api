package pro.kost.v2ex;

import pro.kost.v2ex.beans.TopicList;
import pro.kost.v2ex.network.AbsRequest.OnResponse;

public class V2ex {
	public static void main(String[] args) {
		V2exManager.getTopics("node_name", "github", new OnResponse<TopicList>() {
			public void onRespondResult(TopicList result) {
				System.out.println(result.size());
			}
		});
	}
}
