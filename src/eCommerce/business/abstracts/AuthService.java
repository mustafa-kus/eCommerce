package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface AuthService {
	boolean validate(User user);

	boolean login(User user);
}
