package com.ba.apti.comm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;

public class DropBoxClient {
	
	final public static String APP_KEY 	 = "ceaevd19xej0hec";
	final public static String APP_SECRET 	 = "lyyym35o2b8sh9k";
	final public static String ACCESS_TOKEN = "6FvEk1uKgBAAAAAAAAAABbchIP2tsJrkpQKq1-GJrlrlJkUcQ75JKK4Yk4GzO-e6";
	
	public static synchronized boolean storeFile(InputStream inputStream, long size, String filename) {
		DbxRequestConfig requestConfig = new DbxRequestConfig("BanjaraAptitudeTest", Locale.getDefault().toString());
		DbxClient client = new DbxClient(requestConfig, ACCESS_TOKEN);
	    
		try {
			client.uploadFile("/" + filename, DbxWriteMode.add(), size, inputStream);
		} catch (DbxException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	    finally {
	        try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }	
		return true;
	}
	
	public static String getPublicURL(String path) {
		DbxRequestConfig requestConfig = new DbxRequestConfig("BanjaraAptitudeTest", Locale.getDefault().toString());
		DbxClient client = new DbxClient(requestConfig, ACCESS_TOKEN);
		try {
			return client.createTemporaryDirectUrl("/"+path).url;
		} catch (DbxException e) {
			e.printStackTrace();
			return "null";
		}

	}
}
