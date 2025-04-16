import java.util.*;

public class Main
{
    
    
	public static void main(String[] args) 
	{
		/*
		    Map is a collection of Entry<Key,Value> objects map->[e1, e2, ..en] Each Entry is a unique object.
		    So, to iterate the map, we actually iterate through the Set of Entry objects.
		    Which we get by - mapObj.entrySet(); 
		    
		    Set<Map.Entry<keyDataType,valDataType> s = mapObj.entrySet();
		    Then we iterate through the set, to get the key value items
		*/
  		Map<String, Integer> strFreq = new HashMap<>();
  		strFreq.put("A",2);
  		strFreq.put("C",5);
  		strFreq.put("B",1);
  		strFreq.put("D",7);
		  
	    /*1. Using entrySet() method*/	
    	for(Map.Entry<String,Integer> entry : strFreq.entrySet())
    	{
    	    String str = entry.getKey();
    	    Integer freq = entry.getValue();
    	    
    		System.out.println("Entry - [" + str + "|" + freq + "]");
    	}
    	
    	System.out.println();
    	
    	/*2. Using keySet(), then get the value using get()*/
    	for(String ky : strFreq.keySet())
    	{
    	    Integer val = strFreq.get(ky);
    	    System.out.println("Entry - [" + ky + "|" + val + "]");
    	}
    	
    	System.out.println();
    	
    	/*3. Using iterator() - specially, when you want to remove the entries*/
    	Iterator<Map.Entry<String,Integer>> iterator = strFreq.entrySet().iterator();
    	while(iterator.hasNext())
    	{
    	    Map.Entry<String,Integer> entry = iterator.next();
    	    String ky = entry.getKey();   
    	    Integer val = entry.getValue();
    	    
    	    System.out.println("Entry - [" + ky + "|" + val + "]");
    	    
    	    if(ky.equals("D"))
    	        iterator.remove();
    	}
	    System.out.println("Map size " + strFreq.size());
    	
    	System.out.println();
    	
    	/*4. Using Java 8+ forEach (lambda style) — Clean and modern*/
    	strFreq.forEach((key, value) -> {
    	    System.out.println("Entry - [" + key + "|" + value + "]");
        });

	}
}


/**


      Method	                Use-case	                                            Efficient?
      -----------------------------------------------------------------------------------------------------
      entrySet()	            When you need both key and value	                    ✅ Best
      keySet() + get()	      Need keys, or keys with value	                        ⚠️ Slightly slower
      values()	              Only need values	                                    ✅
      Iterator	              Want to remove items while looping	                  ✅
      forEach()	              Java 8+ concise syntax	                              ✅



*/


