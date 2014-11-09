package pro.kost.v2ex;

public class Addrs {
	public static final String prefix = "http://www.v2ex.com";
	
	//��ȡ��վ��Ϣ
	public static final String info = prefix + "/api/site/info.json";	
	
	//��ȡ��վ״̬
	public static final String status = prefix + "/api/site/stats.json";
	
	//��ȡ���нڵ�
	public static final String nodes_all = prefix + "/api/nodes/all.json";
	
	/**
	 * ��ȡ�ڵ���Ϣ : id/name ѡ��һ
	 */
	public static final String nodes_show = prefix + "/api/nodes/show.json";
	
	//��ȡ��������
	public static final String topics_latest = prefix + "/api/topics/latest.json";
	
	//��ȡ��������
	public static final String topics_hot = prefix + "/api/topics/hot.json";
	
	/**ȡ������Ϣ : id
	 * 
	 * �����ṩ��Ϣȡ���� : username\node_id\node_name ѡ��һ
	 * 
	 */
	public static final String topics_show = prefix + "/api/topics/show.json";
	
	/**
	 * ��ȡ����ظ���topic_id(��ѡ)/page/page_size
	 */
	public static final String replies_show = prefix + "/api/replies/show.json";
	
	/**
	 * ȡ�û���Ϣ: username
	 */
	public static final String members_show = prefix + "/api/members/show.json";
}
