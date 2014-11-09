package pro.kost.v2ex.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author kost
 *
 */
public abstract class AbsRequest {
	
	public abstract void executeGetAsync (String url,HashMap<String, String> params);
	public abstract String executeGetSync(String url,HashMap<String, String> params);
	public abstract void executePostAsync (String url,HashMap<String, String> params);
	public abstract String executePostSync(String url,HashMap<String, String> params);
	public abstract String executeReadSync(String url);
	public abstract <T> void executeReadAsync(String url,Class<T> type);
	
	protected OnResponse mOnResponse = null;
	public void setOnResponse(OnResponse response) {
		this.mOnResponse = response;
	}
	public interface OnResponse<T>{
		void onRespondResult(T result);
	}
	public String mapToString(HashMap<String, String> parmas) {
		StringBuffer urlParams = new StringBuffer();
		if (parmas == null)
			return null;
		for (String key : parmas.keySet()) {
			try {
				urlParams.append(key + "=" + URLEncoder.encode(parmas.get(key).toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return urlParams.toString();
	}
}
