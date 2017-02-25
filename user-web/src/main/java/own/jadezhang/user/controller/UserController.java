package own.jadezhang.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import own.jadezhang.user.api.dto.UserDto;
import own.jadezhang.user.api.rpc.IUserService4Rpc;

import java.util.List;

/**
 * Created by Zhang Junwei on 2016/10/16.
 */
@Controller
@RequestMapping("/user/base")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService4Rpc userService4Rpc;

    @ResponseBody
    @RequestMapping(value = "/findUsers")
    public List<UserDto> findUsers(String userName) {
        logger.debug("invoke rpc service");
        List<UserDto> users = userService4Rpc.findUsers(userName);
        return users;
    }
}
