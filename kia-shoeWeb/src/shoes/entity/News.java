package shoes.entity;

public class News {
	private int NId = 0;
	private String Title = "";
	private String Content = "";
	private String Published = "";
	
	public News() {}
	
	public News(int NId, String Title, String Content, String Published) {
		this.NId = NId;
		this.Title = Title;
		this.Content = Content;
		this.Published = Published;
	}

	public int getNId() {
		return NId;
	}

	public void setNId(int id) {
		NId = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPublished() {
		return Published;
	}

	public void setPublished(String published) {
		Published = published;
	}
}
