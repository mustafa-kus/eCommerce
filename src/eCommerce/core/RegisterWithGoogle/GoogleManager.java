package eCommerce.core.RegisterWithGoogle;

import eCommerce.business.abstracts.AuthService;
import eCommerce.core.utilities.BusinessRules;
import eCommerce.entities.concretes.User;

public class GoogleManager implements AuthService {

	private AuthService authService;

	public GoogleManager(AuthService authService) {
		super();
		this.authService = authService;
	}

	@Override
	public boolean validate(User user) {
		boolean result = authService.validate(user);
		if (result != true) {
			return false;
		}
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kiþisi Google ile kayýt olundu!");
		return true;
	}

	@Override
	public boolean login(User user) {
		boolean result = BusinessRules.Run(checkEMailAndPassword(user));
		if (result) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " kiþisi Google ile oturum açdý!");
			return result;
		}
		return false;
	}

	private boolean checkEMailAndPassword(User user) {
		if (user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Kullanýcý adý veya parola yanlýþtýr!");
			return false;
		}
		return true;
	}

}

