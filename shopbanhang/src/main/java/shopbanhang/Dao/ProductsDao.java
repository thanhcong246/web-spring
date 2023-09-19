package shopbanhang.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import shopbanhang.Dto.ProductsDto;
import shopbanhang.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {
	private String SqlString() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    p.id AS id_product, ");
		sql.append("    p.id_category, ");
		sql.append("    p.sizes, ");
		sql.append("    p.name, ");
		sql.append("    p.price, ");
		sql.append("    p.sale, ");
		sql.append("    p.title, ");
		sql.append("    p.highlight, ");
		sql.append("    p.new_product, ");
		sql.append("    p.details, ");
		sql.append("    c.id AS id_color, ");
		sql.append("    c.name AS name_color, ");
		sql.append("    c.code AS code_color, ");
		sql.append("    c.img, ");
		sql.append("    p.created_at, ");
		sql.append("    p.updated_at ");
		sql.append("FROM ");
		sql.append("    products AS p ");
		sql.append("INNER JOIN ");
		sql.append("    colors AS c ");
		sql.append("ON ");
		sql.append("    p.id = c.id_product ");
		sql.append("GROUP BY ");
		sql.append("    p.id, c.id_product;");
		return sql.toString();
	}

	public List<ProductsDto> GetDataProducts() {
		String sql = SqlString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
}
