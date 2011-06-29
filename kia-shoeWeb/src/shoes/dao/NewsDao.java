package shoes.dao;
import java.util.List;
import shoes.entity.News;

public interface NewsDao {
	
	public int addNews(String Title,String Content);
	
	public int deleteNews(int nId);
	
	public List findAllNews();
	
	public List findNewFiveNews();
	
	public News findNews(int NId);
}
