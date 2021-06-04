package DAO;

import model.News;

import java.sql.Date;
import java.util.List;

public interface NewsDAO {
    public boolean insert(News news);
    public List<News> findAllToday();
    public News findById(String shopuser_id, Date time, String title);
}
