package eCommerce;

import java.util.Scanner;

import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.EMailManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.RegisterWithGoogle.GoogleManager;
import eCommerce.dataAccess.concretes.InMemoryUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(2, "Muzaffer", "�v�n", "muzafferovun@gmail.com", "Dikce14!",true);
		UserService userService = new UserManager(new InMemoryUserDao(), new AuthManager(), new EMailManager());

		System.out.println("====================== Kay�t i�lemi ======================");
		userService.add(user);
		Scanner verify = new Scanner(System.in);
		int verificationCode = verify.nextInt();
		userService.userVerify(user, verificationCode);

		System.out.println("====================== Oturum a�ma i�lemi ======================");
		userService.login(user);

		System.out.println("====================== Google ile kay�t i�lemi ======================");
		AuthService googleManager = new GoogleManager(new AuthManager());
		googleManager.validate(user);

		System.out.println("====================== Google ile oturum a�ma i�lemi ======================");
		googleManager.login(user);
	}

}
