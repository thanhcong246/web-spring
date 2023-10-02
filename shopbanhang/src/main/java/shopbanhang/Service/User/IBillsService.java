package shopbanhang.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import shopbanhang.Dto.CartDto;
import shopbanhang.Entity.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);

	public void AddBillsDetail(HashMap<Long, CartDto> carts);
}
