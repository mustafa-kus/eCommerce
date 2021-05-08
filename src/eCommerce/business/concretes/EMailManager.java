package eCommerce.business.concretes;

import java.util.Random;

import eCommerce.business.abstracts.EMailService;

public class EMailManager implements EMailService {
	int verificationCode;

	public EMailManager() {
		Random random = new Random();
		this.verificationCode = random.nextInt(1000) * 10;
	}

	@Override
	public int eMailSend() {
		return verificationCode;
	}

}
