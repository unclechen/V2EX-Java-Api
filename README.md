#V2EX Java Api(Non -official)
---
Please use these fucking codes

```
	public static void main(String[] args) {  
		V2exManager.getSiteInfo(new OnResponse<SiteInfo>() {
		
			public void onRespondResult(SiteInfo result) {
				//DO whatever you want here
			}
		});
	}
```