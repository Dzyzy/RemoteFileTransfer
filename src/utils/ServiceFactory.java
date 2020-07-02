package utils;

import service.UserService;
import service.impl.UserServiceImpl;

public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
