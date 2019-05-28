package com.vnext.projekt.accountservice.api.controllers.sys;

import com.vnext.projekt.accountservice.api.forms.sys.UserCreateForm;
import com.vnext.projekt.accountservice.api.views.sys.UserView;
import com.vnext.projekt.accountservice.models.FullName;
import com.vnext.projekt.accountservice.models.Password;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.accountservice.services.UserService;
import com.vnext.projekt.common.api.responses.ApiError;
import com.vnext.projekt.common.api.responses.CreatedResponse;
import com.vnext.projekt.common.api.responses.ResourceResponse;
import com.vnext.projekt.common.api.responses.location.Location;
import com.vnext.projekt.common.api.responses.location.LocationType;
import com.vnext.projekt.common.api.responses.validation.ErrorCode;
import com.vnext.projekt.common.exceptions.ResourceNotFoundException;
import com.vnext.projekt.common.exceptions.ResourceViolationException;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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

        List<ApiError> errors = new ArrayList<>();

        Email email = Email.of(_form.getEmail());
        Password password = Password.of(_form.getPassword());

        if (!FullName.isValidLastName(_form.getFirstName())) {
            errors.add(new ApiError(ErrorCode.INVALID_PARAMETER, "invalid firstName",
                    new Location(LocationType.BODY, "/firstName")));
        }

        if (!FullName.isValidLastName(_form.getLastName())) {
            errors.add(new ApiError(ErrorCode.INVALID_PARAMETER, "invalid lastName",
                    new Location(LocationType.BODY, "/lastName")));
        }

        if(!errors.isEmpty()) {
            throw new ResourceViolationException("invalid user create", errors);
        }

        FullName fullName = FullName.of(_form.getFirstName(), _form.getLastName());
        User user = userService.createUser(email, password, fullName);
        UserView view = new UserView(user);
        return new CreatedResponse<>(view);
    }

    @GetMapping("/{id:\\d+}")
    public ResourceResponse<UserView> show(@PathVariable("id") String _id) throws ResourceNotFoundException {
        UserId userId;
        try {
            userId = UserId.of(_id);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
        User user = this.userService.getUser(userId);
        UserView view = new UserView(user);
        return new ResourceResponse<>(view);
    }

}
