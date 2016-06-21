package com.crypto;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File filegeneration = new File("C:\\Users\\Rida\\Desktop\\result.txt");
		File filekey = new File("C:\\Users\\Rida\\Desktop\\in.txt");
		File file = new File("C:\\Users\\Rida\\Desktop\\crypted.txt");
		MonoAlphabitique mono = new MonoAlphabitique();

		Object key = mono.readKey(filekey);
		System.out.println("message "+key);
		// String encodedMessage = mono.encode( key, );
		mono.generateKey(filegeneration);
		System.out.println(filegeneration);
		mono.encode(filekey, filegeneration, file);
		
	}

}
