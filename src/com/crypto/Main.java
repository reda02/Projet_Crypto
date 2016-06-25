package com.crypto;

import java.io.File;
import java.util.List;

import com.crypto.Transposition.Transposition;

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
		System.out.println("encoded Message : " + encodedMessage);
		//dencode
		String decodedMessage =mono.decode(filecrypted, filegeneration, filedecrypted);
		System.out.println("decoded Message : " + decodedMessage);
		System.out.println("  ");
		
		
		String encodedtext =mono.encode(fileText, filegeneration, filecrypted);
		System.out.println("encoded text : " + encodedtext);
		String decodedtext =mono.decode(filecrypted, filegeneration, filedecrypted);
		System.out.println("decoded text : " + decodedtext);
		
		System.out.println(" #####  Transposition ####### ");
		Transposition t=new Transposition();
		String message= "EXEMPLE";
		System.out.println(message);
	    List<Integer> keyp=t.generatePermutation(3);
		System.out.println(keyp);
		String messageEncoded=t.encode(message, keyp);
		System.out.println(messageEncoded);
		
		
		System.out.println("#####  PolyAlpha ####### ");
		PolyAlpha pa=new PolyAlpha();
	    String keya=pa.generateKey();
		System.out.println("key: "+keya);
		String messagea="TCMWUB";
		System.out.println("message: "+messagea);
		String messageEncodeda=pa.encoded(keya,messagea);
		String messageDecodeda=pa.decoded("BC",messagea);
		System.out.println("message encoded: "+messageEncodeda);
		System.out.println("message decoded: "+messageDecodeda);
	}

}
