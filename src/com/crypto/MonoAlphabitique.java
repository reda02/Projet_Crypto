package com.crypto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class MonoAlphabitique implements ICypher {

	final char[] KeyBase = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };

	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " ";


	@Override
	public String encode(File message, File key, File crypted) {

		String readKey = this.readKey(key).toString();
		String readMessage = this.readKey(message).toString();

		HashMap<Character,Character> table = buildConversionTable(readKey, false);
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0 ; i < readMessage.length()-1; i++){
			 stringBuilder.append(table.get(readMessage.charAt(i)));
		}

		writeKey(stringBuilder, crypted);
		
		return stringBuilder.toString();
	}

	private HashMap<Character, Character> buildConversionTable(String key, boolean reverse){
		HashMap<Character,Character> table = new HashMap<Character, Character>();
		for(int i=0 ; i < alphabet.length(); i++){
			if(reverse){
				table.put(key.charAt(i), alphabet.charAt(i));
			}else{
				table.put(alphabet.charAt(i), key.charAt(i));
				
			}
		}
		System.out.println("encoded:  "+ table);
		return table;
		
	}
	@Override
	public String decode(File message1, File key, File crypted1) {
		
		String readKey = this.readKey(key).toString();
		String readcrypted= this.readKey(message1).toString();
		
		  HashMap<Character,Character> table = buildConversionTable(readKey, true);
	        StringBuilder stringBuilder = new StringBuilder();

	        for (int i = 0 ; i < readcrypted.length()-1; i++){
	            stringBuilder.append(table.get(readcrypted.charAt(i)));
	        }

	     
	        writeKey(stringBuilder, crypted1);
			
			return stringBuilder.toString();

	}

	@Override
	public Object generateKey(File key) {

		 char[] charTable = alphabet.toCharArray();
	        int currentIndex = charTable.length, randomIndex;
	        char temporaryValue;

	        // While there remain elements to shuffle...
	        while (0 != currentIndex) {

	            // Pick a remaining element...
	            randomIndex = (int) Math.floor(Math.random() * currentIndex);
	            currentIndex -= 1;

	            // And swap it with the current element.
	            temporaryValue = charTable[currentIndex];
	            charTable[currentIndex] = charTable[randomIndex];
	            charTable[randomIndex] = temporaryValue;
	        }


		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(key));
			writer.write(new String(charTable));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return new String(charTable);
	}

	@Override
	public Object readKey(File f) {
		String chaine="";
		try{
			InputStream ips=new FileInputStream(f); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				//System.out.println(ligne);
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return chaine;
	}

	@Override
	public void writeKey(Object key, File f) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(new String(key.toString()));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}



}


