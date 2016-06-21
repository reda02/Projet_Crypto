package com.crypto;

import java.io.File;

public interface ICypher {
	
	//String encode(String message, Object key);
    //String decode(String crypted, Object key);
	void encode(File message, File key,File crypted);
	void decode(File message, File key,File crypted1);
  
    Object readKey(File f);
    void writeKey(Object key ,File f);
	Object generateKey(File key);
}
