package pro.kost.v2ex.beans;

public class Topic {
    public String id;
    public String title;
    public String url;
    public String content;
    public String contentRendered;
    public int replies;
    public Member member;
    public Node node;
    
    //ע��:v2ex���ص�ʱ�����Ҫ��000
    public long created;
    public long last_modified;
    public long last_touched;
}
