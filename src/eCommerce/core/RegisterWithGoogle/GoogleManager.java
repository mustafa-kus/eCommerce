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
		System.out.println(user.getFirstName() + " " + user.getLastName() + " ki�isi Google ile kay�t olundu!");
		return true;
	}

	@Override
	public boolean login(User user) {
		boolean result = BusinessRules.Run(checkEMailAndPassword(user));
		if (result) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " ki�isi Google ile oturum a�d�!");
			return result;
		}
		return false;
	}

	private boolean checkEMailAndPassword(User user) {
		if (user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Kullan�c� ad� veya parola yanl��t�r!");
			return false;
		}
		return true;
	}

}

