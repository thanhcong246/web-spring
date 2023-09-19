package shopbanhang.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import shopbanhang.Entity.MapperMenus;
import shopbanhang.Entity.Menus;

@Repository
public class MenusDao extends BaseDao {
	public List<Menus> GetDataMenus(){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "select * from menus";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
}
