package com.monica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLongestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l = lengthOfLongestSubstring("abxysaabddcssx");
		System.out.println(l);

	}
	 public static int lengthOfLongestSubstring(String s) {
	        int length = s.length();
	        int maxlength=0;
            String substring = null;
            	List<Character> longestsubstring = new ArrayList<Character>();
	        for (int i=0;i<length;i++){
	        	System.out.println(i +"--"+s.charAt(i));
	            if(longestsubstring.size() ==0){
	               longestsubstring.add(s.charAt(0)); 
	               maxlength = 1;
	               substring= longestsubstring.stream().map(String::valueOf).collect(Collectors.joining()); 
	            }else{
	            for(int j=0;j<longestsubstring.size();j++){
	            	System.out.println(longestsubstring);
	            	if(longestsubstring.get(j)==s.charAt(i)){
	            		//longestsubstring.clear();
	            		for(int k =j;k>=0;k--){
		            		longestsubstring.remove(k)	;
		            		System.out.println("reomve -"+longestsubstring);
		            		}
	            		j=longestsubstring.size();
	            		longestsubstring.add(s.charAt(i));
	            		if(maxlength<longestsubstring.size()){
		                	maxlength = longestsubstring.size();
		                    substring= longestsubstring.stream().map(String::valueOf).collect(Collectors.joining()); 
		                    
		                }
	            	}else if(j+1==longestsubstring.size()){
	            		longestsubstring.add(s.charAt(i));
	            		if(maxlength<=longestsubstring.size()){
	            		maxlength = longestsubstring.size();
	                    substring= longestsubstring.stream().map(String::valueOf).collect(Collectors.joining());
	            		}
	                    break;
	            	}
	                
	            }
	            }
	        }
	        System.out.println(substring);
			return maxlength;
	        
	    }
}
