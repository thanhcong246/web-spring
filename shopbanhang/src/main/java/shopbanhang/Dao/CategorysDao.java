package shopbanhang.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shopbanhang.Entity.Categorys;
import shopbanhang.Entity.MapperCategorys;

@Repository
public class CategorysDao extends BaseDao{
	
	public List<Categorys> GetDataCategory(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "select * from categorys";
		list = _jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
}
