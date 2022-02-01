package providers.auth;

import api.clients.HttpSession;
import models.User;

public interface Auth {

    HttpSession login(User user);
}
