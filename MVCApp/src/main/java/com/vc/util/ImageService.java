package com.vc.util;

import java.io.InputStream;
import java.util.Map;

public class ImageService {
	public String uploadImage(InputStream imageStream) {
		String result = null;
		try {
			Map<String, Object> uploadResult = CloudinaryUtil.upload(imageStream);
			result = (String) uploadResult.get("secure_url");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
