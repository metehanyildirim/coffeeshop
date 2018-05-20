package edu.hacettepe.services;

import edu.hacettepe.DAO.User;
import edu.hacettepe.repository.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private Repository repository;

    public synchronized User addUser(User user) throws IOException {
        return repository.addUser(user);
    }

    public synchronized User getUser(String username) throws IOException{
        return repository.getUser(username);
    }

    public User getUser(int userId) throws IOException {
        return repository.getUser(userId);
    }

    public List<User> listUsers() throws IOException {
        return repository.listUsers();
    }

    public synchronized User deleteUser(int id) throws IOException {
        return repository.deleteUser(id);
    }

    public synchronized void updateUser(User user) throws IOException{
        repository.updateUser(user);
    }

    public User login(String username, String password) throws IOException{
        return repository.getUser(username, password);
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
