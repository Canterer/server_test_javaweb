package com.zs.json;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class JsonTools {
	public static String createJsonString(String key, Object value){
		
		JSONObject json = new JSONObject();
		
		try{
			json.put(key, value);
		}catch( JSONException e){
			e.printStackTrace();
		}
		
		return json.toString();
	}
}
