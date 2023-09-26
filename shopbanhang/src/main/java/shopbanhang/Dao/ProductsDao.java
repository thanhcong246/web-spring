package shopbanhang.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import shopbanhang.Dto.ProductsDto;
import shopbanhang.Dto.ProductsDtoMapper;

// Xử lý hiển thị sản phẩm
@Repository
public class ProductsDao extends BaseDao {
	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlString() { // sql sản phẩm chung
		StringBuffer sql = new StringBuffer();
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
		return sql;
	}

	private String SqlProducts(boolean newProduct, boolean highLight) { // sản phẩm
		StringBuffer sql = SqlString();
		sql.append("WHERE 1=1 ");
		if (highLight) {
			sql.append("AND p.highlight = true ");
		}
		if (newProduct) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY ");
		sql.append("    p.id, c.id_product ");
		sql.append("   	ORDER BY RAND() ");
		if (highLight) {
			sql.append("   	LIMIT 9 ");
		}
		if (newProduct) {
			sql.append("   	LIMIT 12 ");
		}
		return sql.toString();
	}

	private String SqlProductsById(int id) { // sản phẩm theo id category
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append(" AND id_category = " + id + " ");
		return sql.toString();
	}

	private String SqlProductsPaginate(int start, int end) { // phân trang sản phẩm
		StringBuffer sql = SqlString();
		sql.append(" LIMIT " + start + ", " + end);
		return sql.toString();
	}

	public List<ProductsDto> GetDataNewProducts() { // xử lý sản phẩm mới
		String sql = SqlProducts(YES, NO);
		List<ProductsDto> listNewProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listNewProducts;
	}

	public List<ProductsDto> GetDataHightlightProducts() { // xử lý sản phẩm nổi bật
		String sql = SqlProducts(NO, YES);
		List<ProductsDto> listHightlightProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listHightlightProducts;
	}

	public List<ProductsDto> GetAllProductsByID(int id) { // xử lý sản phẩm theo id category
		String sql = SqlProductsById(id);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductsDto> GetDataProductsPaginate(int start, int end) { // xử lý phân trang sản phẩm
		String sql = SqlProductsPaginate(start, end);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

}
