package com.vnext.projekt.accountservice.api.controllers.sys;

import com.vnext.projekt.accountservice.api.forms.sys.UserCreateForm;
import com.vnext.projekt.accountservice.api.views.sys.UserView;
import com.vnext.projekt.accountservice.models.FullName;
import com.vnext.projekt.accountservice.models.Password;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.accountservice.services.UserService;
import com.vnext.projekt.common.api.CreatedResponse;
import com.vnext.projekt.common.exceptions.ResourceViolationException;
import com.vnext.projekt.common.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/sys/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public CreatedResponse<UserView> create(@RequestBody @Valid UserCreateForm _form) throws URISyntaxException, ResourceViolationException {

        Email email = Email.of(_form.getEmail());
        Password password = Password.of(_form.getPassword());
        FullName fullName = FullName.of(_form.getFirstName(), _form.getLastName());
        User user = userService.createUser(email, password, fullName);
        UserView view = new UserView(user);
        return new CreatedResponse<>(view);
    }

}
