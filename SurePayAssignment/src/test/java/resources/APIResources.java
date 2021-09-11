/*
 * Enum class  contains collections of constants or methods
 * 
 * 
 * @author Pranav Chembath
 * @version 1.0
 */

package resources;

public enum APIResources {
	
	GetTodosAPI("/todos"),
	CreatePostAPI("/posts"),
	GetCommentsAPI("/comments");
	
	private String resource;

	// Constructor for fetching the constants and methods
	APIResources(String resource) {
		this.resource = resource;
		
	}
	// Method to return the resource 
	public String getResource() {
		return resource;
		
	}
	

}
