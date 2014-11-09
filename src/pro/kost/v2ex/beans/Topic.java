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
    
    //注意:v2ex返回的时间后面要加000
    public long created;
    public long last_modified;
    public long last_touched;
}
