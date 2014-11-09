package pro.kost.v2ex;

public class Addrs {
	public static final String prefix = "http://www.v2ex.com";
	
	//获取网站信息
	public static final String info = prefix + "/api/site/info.json";	
	
	//获取网站状态
	public static final String status = prefix + "/api/site/stats.json";
	
	//获取所有节点
	public static final String nodes_all = prefix + "/api/nodes/all.json";
	
	/**
	 * 获取节点信息 : id/name 选其一
	 */
	public static final String nodes_show = prefix + "/api/nodes/show.json";
	
	//获取最新主题
	public static final String topics_latest = prefix + "/api/topics/latest.json";
	
	//获取热议主题
	public static final String topics_hot = prefix + "/api/topics/hot.json";
	
	/**取主题信息 : id
	 * 
	 * 根据提供信息取主题 : username\node_id\node_name 选其一
	 * 
	 */
	public static final String topics_show = prefix + "/api/topics/show.json";
	
	/**
	 * 获取主题回复：topic_id(必选)/page/page_size
	 */
	public static final String replies_show = prefix + "/api/replies/show.json";
	
	/**
	 * 取用户信息: username
	 */
	public static final String members_show = prefix + "/api/members/show.json";
}
