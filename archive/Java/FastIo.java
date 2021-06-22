class FastIo{
	public static void main(String[] args) throws IOException  
	    { 
	        //Enter data using BufferReader 
	        BufferedReader reader =  
	                   new BufferedReader(new InputStreamReader(System.in)); 
	         
	        // Reading data using readLine 
	        String name = reader.readLine(); 
	  
	        // Printing the read line 
	        System.out.println(name);         
	    }
}