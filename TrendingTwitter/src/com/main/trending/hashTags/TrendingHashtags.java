package com.main.trending.hashTags;
import com.main.trending.impl.HashTagUtility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;


class TrendingHashtags{

	public static void main(String a[] ) throws Exception 
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int noOfTweets=Integer.parseInt(br.readLine());

		ArrayList<String> listOfTweets=new ArrayList<String>();
		while(noOfTweets-->0)
		{
			String tweet = br.readLine(); 
			listOfTweets.add(tweet);
		}

		Map<String,Integer> hashTagWords=HashTagUtility.extractHashTags(listOfTweets);
		//no of top hashtags is 10 in this case ,can be extended by passing required no of top hashtags
		if(hashTagWords.size()<10)
			System.out.println("No of Hashtags are less than :"+noOfTweets);
		else{
			ArrayList<String> topHashtags=HashTagUtility.getTopHashtags(hashTagWords,10);

			for(String hashTags:topHashtags){
				System.out.println(hashTags);
			}
		}
	}




}