#V2EX Java Api(Non-official)

# What is this?
This is v2ex java api, you can use it to retrive the content you want.And this api will be integrated into a Material Design App(Still working on it, just for fun^_^).

#Usage
**更多api说明请参见[V2exManager.java](https://github.com/K0ST/V2EX-Java-Api/blob/master/src/pro/kost/v2ex/V2exManager.java)**

获取网站信息
```java
V2exManager.getSiteInfo(new OnResponse<SiteInfo>() {
	public void onRespondResult(SiteInfo result) {
        //TODO
	}
});
```

获取网站状态
```java
V2exManager.getSiteStats(new OnResponse<SiteStats>() {
	public void onRespondResult(SiteStats result) {
		// TODO 
	}
});
```

获取所有节点信息
```java
V2exManager.getNodesAll(new OnResponse<NodeList>() {
	public void onRespondResult(NodeList result) {
		// TODO 
	}
});
```


**更多api说明请参见[V2exManager.java](https://github.com/K0ST/V2EX-Java-Api/blob/master/src/pro/kost/v2ex/V2exManager.java)**


#TODO
- Login.
- 获取一个Node的所有Topics.
- Create new topic.