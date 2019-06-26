package io.pivotal.pal.tracker.users;

import io.pivotal.pal.tracker.users.data.UserDataGateway;
import io.pivotal.pal.tracker.users.data.UserRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDataGateway gateway;

    public UserController(UserDataGateway gateway) {
        this.gateway = gateway;
    }


    @GetMapping("/{userId}")
    public UserInfo show(@PathVariable long userId) {
        UserRecord record = gateway.find(userId);

        if (record == null) {
            return null;
        }

        return new UserInfo(record.id, record.name, "user info");
    }

    @GetMapping
    public ResponseEntity<List<UserInfo>> list() {

        List<UserRecord> list = gateway.list();

        List<UserInfo> returnList = new ArrayList<>();
        for (UserRecord userRecord : list) {
            UserInfo userInfo = new UserInfo(userRecord.id, userRecord.name, "user info");

            returnList.add(userInfo);
        }

        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }
}
