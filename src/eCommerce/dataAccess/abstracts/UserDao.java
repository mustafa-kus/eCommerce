package eCommerce.dataAccess.abstracts;

import eCommerce.entities.concretes.User;

import java.util.List;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	void login(User user);
	User get(int id);
	List<User> getAll();

}
