package shopbanhang.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shopbanhang.Dto.ProductsDto;

@Service
public interface ICategoryService {
	public List<ProductsDto> GetAllProductsByID(int id);

	public List<ProductsDto> GetDataProductsPaginate(int start, int end);
}
