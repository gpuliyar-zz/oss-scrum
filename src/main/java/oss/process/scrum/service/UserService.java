package oss.process.scrum.service;

import java.util.List;

import oss.process.scrum.domain.User;

public interface UserService {
    List<User> getUsers(String query);
}
