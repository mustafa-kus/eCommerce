package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	private List<User> users=new ArrayList<User>();
	public InMemoryUserDao() {
		User admin=new User(1,"Mustafa","Ku�","mustafa_kus@hotmail.com","12345",true);
		this.users.add(admin);
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getFirstName() + " " + user.getLastName() + " kay�t edildi!");
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getFirstName() + " " + user.getLastName() + " g�ncellendi!");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getFirstName() + " " + user.getLastName() + " silindi!");
	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getFirstName() + " " + user.getLastName() + " oturum a�t�!");
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
		System.out.println("Kullan�c� ad�: " + user.getFirstName());
		return user;
	}

	@Override
	public List<User> getAll() {
		for (User user : users) {
			System.out.println(user.getFirstName());
		}
		System.out.println("================================");
		return this.users;
	}

}
