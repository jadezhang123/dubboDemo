package own.jadezhang.user.api.rpc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import own.jadezhang.user.api.dto.UserDto;
import own.jadezhang.user.api.rpc.IUserService4Rpc;
import own.jadezhang.user.domain.UserEx;
import own.jadezhang.user.service.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Junwei on 2017/2/25.
 */
public class UserService4RpcImpl implements IUserService4Rpc {
    @Autowired
    private IUserService userService;

    @Override
    public List<UserDto> findUsers(String userName) {
        Map<String, Object> condition = new HashMap<String, Object>();
        List<UserDto> users = new ArrayList<UserDto>();
        condition.put("name", userName);
        List<UserEx> userWithArticles = userService.getUserWithArticles(condition);
        UserDto userDto;
        for (UserEx userWithArticle : userWithArticles) {
            userDto = new UserDto();
            userDto.setId(userWithArticle.getId());
            userDto.setName(userWithArticle.getName());
            userDto.setSex(userWithArticle.getSex());
            users.add(userDto);
        }
        return users;
    }
}
