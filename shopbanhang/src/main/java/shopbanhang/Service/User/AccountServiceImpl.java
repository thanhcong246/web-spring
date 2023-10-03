package shopbanhang.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopbanhang.Dao.UsersDao;
import shopbanhang.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	UsersDao usersDao = new UsersDao();

	public int AddAccount(Users user) { // đăng ký và mã hóa mật khẩu
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return usersDao.AddAccount(user);
	}

	@Override
	public Users CheckAccount(Users user) {
	    String pass = user.getPassword();
	    Users authenticatedUser = usersDao.GetUserByAcc(user);

	    if (authenticatedUser != null && BCrypt.checkpw(pass, authenticatedUser.getPassword())) {
	        return authenticatedUser;
	    } else {
	        return null; // Trả về null nếu không tìm thấy tài khoản hoặc sai mật khẩu
	    }
	}


	@Override
    public Users GetUserByEmail(String email) {
        return usersDao.GetUserByEmail(email);
    }
	
}
