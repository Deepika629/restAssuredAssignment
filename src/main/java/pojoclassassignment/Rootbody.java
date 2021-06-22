package pojoclassassignment;

import java.util.List;

public class Rootbody {
	
		private int id;
		

	    private Category category;

	    private String name;

	    private List<String> photoUrls;

	    private Tags tags;

	    private String status;

	    public void setId(int id){
	        this.id = id;
	    }
	    public int getId(){
	        return this.id;
	    }
	    public void setCategory(Category category){
	        this.category = category;
	    }
	    public Category getCategory(){
	        return this.category;
	    }

	    public void setTags(Tags tags){
	        this.tags = tags;
	    }
	    public Tags getTags(){
	        return this.tags;
	    }
	    
	    public void setName(String name){
	        this.name = name;
	    }
	    public String getName(){
	        return this.name;
	    }
	    public void setPhotoUrls(List<String> photoUrls){
	        this.photoUrls = photoUrls;
	    }
	    public List<String> getPhotoUrls(){
	        return this.photoUrls;
	    }
	  
	    
	    
	    
	    public void setStatus(String status){
	        this.status = status;
	    }
	    public String getStatus(){
	        return this.status;
	    }

}
