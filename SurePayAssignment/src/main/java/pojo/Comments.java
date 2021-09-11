package pojo;

public class Comments {

	private Integer postId;
	private Integer id;
	private String name;
	private String email;

	public String getEmail() {
		return email;
	}

	private String body;

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
