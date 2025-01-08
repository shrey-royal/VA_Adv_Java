package com.vc.util;

import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUtil {
	private static Cloudinary cloudinaryInstance;
	
	// Private constructor to prevent instantiation
	private CloudinaryUtil() {}
	
	/**
     * Initializes the Cloudinary instance if not already done.
     */
	private static void init() {
		if (cloudinaryInstance == null) {
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					"cloud_name", "",
					"api_key", "",
					"api_secret", "",
					"secure", true));
		}
	}
	
	/**
     * Returns the Cloudinary instance.
     *
     * @return Cloudinary instance
     */
	public static Cloudinary getInstance() {
		if (cloudinaryInstance == null) {
			init();
		}
		return cloudinaryInstance;
	}
	
	/**
     * Uploads an image to Cloudinary and returns the result map.
     *
     * @param filePath The file path or InputStream of the image to be uploaded
     * @param options  Optional parameters for the upload
     * @return Map containing upload response from Cloudinary
     * @throws Exception if upload fails
     */
	public static Map<String, Object> upload(Object filePath) throws Exception {
		Cloudinary cloudinary = getInstance();
		return cloudinary.uploader().upload(filePath, null);
	}
}