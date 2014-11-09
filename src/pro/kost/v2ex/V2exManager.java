package pro.kost.v2ex;

import pro.kost.v2ex.beans.Member;
import pro.kost.v2ex.beans.Node;
import pro.kost.v2ex.beans.NodeList;
import pro.kost.v2ex.beans.ReplyList;
import pro.kost.v2ex.beans.SiteInfo;
import pro.kost.v2ex.beans.SiteStats;
import pro.kost.v2ex.beans.TopicList;
import pro.kost.v2ex.network.AbsRequest;
import pro.kost.v2ex.network.ConcreteRequest;

public class V2exManager {
	public static <T> ConcreteRequest getConcreteRequest(AbsRequest.OnResponse<T> response) {
		ConcreteRequest request = new ConcreteRequest();
		request.setOnResponse(response);
		return request;
	}
	public static void getSiteInfo(AbsRequest.OnResponse<SiteInfo> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.info,SiteInfo.class);
	}
	
	public static void getSiteStats(AbsRequest.OnResponse<SiteStats> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.status,SiteStats.class);
	}
	/**
	 * 获取所有节点信息
	 */
	public static void getNodesAll(AbsRequest.OnResponse<NodeList> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.nodes_all,NodeList.class);
	}
	
	/**
	 * 获取节点信息,可传入节点id或节点名
	 */
	public static void getNodeInfo(String key,String value,AbsRequest.OnResponse<Node> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.nodes_show + "?" + key + "=" + value, Node.class);
	}
	/**
	 * 获取最新主题
	 */
	public static void getLatestTopics(AbsRequest.OnResponse<TopicList> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.topics_latest, TopicList.class);
	}
	
	/**
	 * 获取热议主题
	 */
	public static void getHotTopics(AbsRequest.OnResponse<TopicList> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.topics_hot, TopicList.class);
	}
	
	/**
	 * 获取单个主题信息
	 */
	public static void getTopicShow(String id, AbsRequest.OnResponse<TopicList> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.topics_show + "?id=" + id, TopicList.class);
	}

	/**
	 * 获取主题列表
	 * @param key : username\node_id\node_name
	 */
	public static void getTopics(String key, String value, AbsRequest.OnResponse<TopicList> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.topics_show + "?" + key + "=" + value, TopicList.class);
	}
	
	/**
	 * 获取回复列表
	 * 
	 */
	public static void getReplies(String id, AbsRequest.OnResponse<ReplyList> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.replies_show + "?topic_id=" + id, ReplyList.class);
	}
	
	/**
	 * 获取用户信息
	 * 
	 */
	public static void getMember(String username, AbsRequest.OnResponse<Member> response) {
		ConcreteRequest request = getConcreteRequest(response);
		request.executeReadAsync(Addrs.members_show + "?username=" + username, Member.class);
	}
}
