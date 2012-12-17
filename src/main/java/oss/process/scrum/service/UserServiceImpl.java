package oss.process.scrum.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import oss.process.scrum.domain.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private static List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<User>();
        User user = new User();
        user.setEmailId("gpuliyar@metricstream.com");
        user.setFirstName("Gopalakrishnan");
        user.setLastName("P");
        user.setUsername("gpuliyar");
        users.add(user);
        user = new User();
        user.setEmailId("rishabhr@metricstream.com");
        user.setFirstName("Rishabh");
        user.setLastName("Rao");
        user.setUsername("rishabhr");
        users.add(user);
    }

    @Override
    public List<User> getUsers(String query) {
        List<User> filteredUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getEmailId().contains(query) || user.getFirstName().contains(query) || user.getLastName().contains(query)) {
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    public static void main(String args[]) {
        String query = "rish";
        for (User user : users) {
            if (user.getEmailId().contains(query) || user.getFirstName().contains(query) || user.getLastName().contains(query)) {
                System.out.println(user.getEmailId());
            }
        }
    }
}
