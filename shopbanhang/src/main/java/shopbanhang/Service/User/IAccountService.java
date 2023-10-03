package shopbanhang.Service.User;

import org.springframework.stereotype.Service;

import shopbanhang.Entity.Users;

@Service
public interface IAccountService {
	public int AddAccount(Users user);

	public Users CheckAccount(Users user);
	
    public Users GetUserByEmail(String email);
}
