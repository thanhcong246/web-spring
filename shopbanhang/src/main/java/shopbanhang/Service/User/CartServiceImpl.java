package shopbanhang.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopbanhang.Dao.CartDao;
import shopbanhang.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartDao cartDao = new CartDao();

	@Override
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) { // thêm vào giỏ hàng
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) { // sửa
		return cartDao.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) { // xóa
		return cartDao.DeleteCart(id, cart);
	}

	@Override
	public int TotalQuanty(HashMap<Long, CartDto> cart) { // tổng số lượng sản phẩm
		return cartDao.TotalQuanty(cart);
	}

	@Override
	public double TotalPrice(HashMap<Long, CartDto> cart) { // tổng số tiền sản phẩm
		return cartDao.TotalPrice(cart);
	}

}
