package eCommerce.business.concretes;

import java.util.regex.Pattern;

import eCommerce.business.abstracts.AuthService;
import eCommerce.core.utilities.BusinessRules;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public boolean validate(User user) {
		boolean result = BusinessRules.Run(checkFirstNameAndLastName(user), checkEMailAndPassword(user),
				checkEMail(user), checkStrengthPassword(user));
		return result;
	}

	private boolean checkFirstNameAndLastName(User user) {
		if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2) {
			return true;
		}
		System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr!");
		return false;
	}

	private boolean checkEMailAndPassword(User user) {
		if (user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Kullanýcý adý veya parola yanlýþtýr!");
			return false;
		}
		return true;
	}

	private boolean checkEMail(User user) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail()).find();
	}

	private boolean checkStrengthPassword(User user) {
		int passwordScore = 0;

		if (user.getPassword().length() >= 6) {
			passwordScore += 2;
		}

		if (user.getPassword().matches("(?=.*[0-9]).*")) {
			passwordScore += 2;
		}

		if (user.getPassword().matches("(?=.*[a-z]).*")) {
			passwordScore += 2;
		}

		if (user.getPassword().matches("(?=.*[A-Z]).*")) {
			passwordScore += 2;
		}

		if (user.getPassword().matches("(?=.*[~!@#$%^&*()_-]).*")) {
			passwordScore += 2;
		}

		if (passwordScore == 10)
			return true;

		return false;

	}

	@Override
	public boolean login(User user) {
		boolean result = BusinessRules.Run(checkEMailAndPassword(user));
		return result;
	}
}
