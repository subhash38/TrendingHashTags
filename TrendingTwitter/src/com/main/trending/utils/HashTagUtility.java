package com.main.trending.impl;

import java.util.*;


/*HashTag Utility class for extracting HashTags*/
public class HashTagUtility {


	public  static Map<String,Integer> extractHashTags(ArrayList<String> listOfTweets)
	{
		Map<String,Integer> hashTags=new HashMap<String,Integer>();
		for(String tweet:listOfTweets)
		{
			int tweet_len=tweet.length(),i=0;
			while(i<tweet_len)
			{
				char ch=tweet.charAt(i);
				//If the character starts with # iterate for next space
				if(ch=='#')
				{
					int j=i;
					StringBuilder hashTagWord=new StringBuilder();
					while(j<tweet_len&&tweet.charAt(j)!=' '){
						hashTagWord=hashTagWord.append(tweet.charAt(j));
						j++;
					}

					String word=hashTagWord.toString();
					if(hashTags.containsKey(word))
						hashTags.put(word,hashTags.get(word)+1);
					else 
						hashTags.put(word,1);
					i=j;
				}
				else 
					i++;
			}


		}

		return hashTags;
	}


	public static ArrayList<String> getTopHashtags(Map<String,Integer> hashTags,int noOfHastags)
	{
		ArrayList<String> topHashtagList=new ArrayList<String>();
		// Create a list from elements of HashMap 
		List<Map.Entry<String, Integer> > listOfTags = new LinkedList<Map.Entry<String, Integer> >(hashTags.entrySet()); 

		// Sort the listOfTags 
		Collections.sort(listOfTags, new Comparator<Map.Entry<String, Integer> >() { 
			public int compare(Map.Entry<String, Integer> o1,  
					Map.Entry<String, Integer> o2) 
			{ 
				return o2.getValue()-o1.getValue(); 
			} 
		}); 


		if(listOfTags.size()<noOfHastags)
			return topHashtagList;

		else
		{
			int countHashTag=0;
			//Add the HashTags into List
			for (Map.Entry<String, Integer> aa : listOfTags)
			{
				if(countHashTag==noOfHastags)break;
				topHashtagList.add(aa.getKey());
				countHashTag++;
			}
		}
		return topHashtagList;
	}
}