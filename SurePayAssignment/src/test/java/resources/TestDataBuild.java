/*
 * This class is created to build test data (Payload) using Serialization Concept
 * @author Pranav Chembath
 * @version 1.0
 */

package resources;

import pojo.Posts;

public class TestDataBuild {
	
	//Creating Payload for 
	public Posts postsbyUser(String title, String body, String userid ) {
		
		Posts p =new Posts();
		p.setTitle(title);
		p.setBody(body);
		p.setUserId(userid);
		return p;
	}

}
