package pro.kost.v2ex.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

import com.google.gson.Gson;

public class ConcreteRequest extends AbsRequest {

	@Override
	public String executePostSync(String targetURL,
			HashMap<String, String> params) {
		URL url;
		HttpURLConnection connection = null;
		try {
			String urlParameters = mapToString(params);
			if (urlParameters == null)
				urlParameters = "";
			// Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length",
					"" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@Override
	public void executePostAsync(final String url,
			final HashMap<String, String> params) {
		new Thread(new Runnable() {
			public void run() {
				if (mOnResponse != null)
					mOnResponse.onRespondResult(executePostSync(url, params));
			}
		}).start();
	}

	@Override
	public void executeGetAsync(String url, HashMap<String, String> params) {
		// TODO Auto-generated method stub

	}

	@Override
	public String executeGetSync(String url, HashMap<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String executeReadSync(String url) {
		try {
			
			URL connection = new URL(url);
			HttpURLConnection yc = (HttpURLConnection) connection.openConnection();
			String encoding = yc.getContentEncoding();
			BufferedReader in = null;
			if(encoding!=null && encoding.contains("gzip")){//首先判断服务器返回的数据是否支持gzip压缩，  
				in = new BufferedReader(new InputStreamReader(new GZIPInputStream(yc.getInputStream()),Charset.forName("UTF-8")));			
			} else {
				in = new BufferedReader(new InputStreamReader(yc.getInputStream(),Charset.forName("UTF-8")));			
			}
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine).append("\n");
			}
			in.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> void executeReadAsync(final String url,final Class<T> type) {
		new Thread(new Runnable() {
			public void run() {
				if (mOnResponse != null) {
					try {
						String resultString = executeReadSync(url);
						System.out.println(resultString);
						T instance = type.newInstance();
						instance = new Gson().fromJson(resultString, type);
						mOnResponse.onRespondResult(instance);
					} catch (InstantiationException e) {
						mOnResponse.onRespondResult(null);
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						mOnResponse.onRespondResult(null);
						e.printStackTrace();
					}
					
				}
			}
		}).start();
	}

}
