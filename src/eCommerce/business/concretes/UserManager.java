package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.EMailService;
import eCommerce.business.abstracts.UserService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private EMailService eMailService;
	private AuthService authService;
	public UserManager(UserDao userDao, AuthService authService, EMailService eMailService) {
		this.eMailService = eMailService;
		this.userDao = userDao;
		this.authService = authService;
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		if (authService.validate(user)) {
			userDao.add(user);
			System.out.println("Doðrulama kodu gönderildi! " + eMailService.eMailSend());
			System.out.print("Doðrulama kodunu girin: ");

		} else {
			System.out.println("Hata oluþtu! Kullanýcý bilgilerini kontrol edin!");
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		if (authService.login(user)) {
			userDao.login(user);
		}
	}

	@Override
	public void userVerify(User user, int verificationCode) {
		// TODO Auto-generated method stub
		int result = eMailService.eMailSend();
		if (result == verificationCode) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " kullanýcýsý doðrulandý!");
		} else {
			System.out.println("Doðrulama kodunuz yanlýþ");
		}
	}

}
