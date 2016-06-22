package com.crypto;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File filegeneration = new File("C:\\Users\\Rida\\Desktop\\result.txt");
		File filekey = new File("C:\\Users\\Rida\\Desktop\\in.txt");
		File filecrypted = new File("C:\\Users\\Rida\\Desktop\\crypted.txt");
		File filedecrypted = new File("C:\\Users\\Rida\\Desktop\\decrypted.txt");
		File fileText = new File("C:\\Users\\Rida\\Desktop\\textexo.txt");
		
		
		MonoAlphabitique mono = new MonoAlphabitique();

		String   key = (String) mono.readKey(filekey);
		System.out.println("message "+key);
		
		// String encodedMessage = mono.encode( key, );
	       mono.generateKey(filegeneration);
		
		//encode
		String encodedMessage =mono.encode(filekey, filegeneration, filecrypted);
		System.out.println("encoded Message: " + encodedMessage);
		//dencode
		String decodedMessage =mono.decode(filecrypted, filegeneration, filedecrypted);
		System.out.println("decoded Message: " + decodedMessage);
		
		Frequencies f=new Frequencies();
		
		String encodedtext =mono.encode(fileText, filegeneration, filecrypted);
		System.out.println("encoded text: " + encodedtext);
		String decodedtext =mono.decode(filecrypted, filegeneration, filedecrypted);
		System.out.println("decoded text: " + decodedtext);
	}

}
