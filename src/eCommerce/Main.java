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
		User user = new User(2, "Muzaffer", "Övün", "muzafferovun@gmail.com", "Dikce14!",true);
		UserService userService = new UserManager(new InMemoryUserDao(), new AuthManager(), new EMailManager());

		System.out.println("====================== Kayýt iþlemi ======================");
		userService.add(user);
		Scanner verify = new Scanner(System.in);
		int verificationCode = verify.nextInt();
		userService.userVerify(user, verificationCode);

		System.out.println("====================== Oturum açma iþlemi ======================");
		userService.login(user);

		System.out.println("====================== Google ile kayýt iþlemi ======================");
		AuthService googleManager = new GoogleManager(new AuthManager());
		googleManager.validate(user);

		System.out.println("====================== Google ile oturum açma iþlemi ======================");
		googleManager.login(user);
	}

}
