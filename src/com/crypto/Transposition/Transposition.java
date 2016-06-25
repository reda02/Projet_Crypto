package com.crypto.Transposition;
import java.util.Arrays;
import java.util.List;

public class Transposition {

	public List<Integer> generatePermutation(Integer size){
        return Arrays.asList(new Integer[]{2,4,0,1,3});
    }
	
	public String encode(String message, List<Integer> key){

        String messageEncoded = "";
        String messageNew = message;

        for (int i = 0; i < (message.length() % key.size())+1; i++) 
        	messageNew+=" ";// add space at the end
        
        for (int i = 0, keyIndex = 0, pieceIndex = 0; i < messageNew.length(); i++) {
        	messageEncoded+=messageNew.charAt(pieceIndex+key.get(keyIndex));
            if(++keyIndex >= key.size()){
            	pieceIndex = i+1;
                keyIndex = 0;
            }
        }
        return messageEncoded;
    }

}
