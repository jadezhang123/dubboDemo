package own.jadezhang.user.api.rpc;

import own.jadezhang.user.api.dto.UserDto;

import java.util.List;

/**
 * Created by Zhang Junwei on 2017/2/24.
 */
public interface IUserService4Rpc {
    /**
     * 通过姓名模糊查询用户
     * @param userName
     * @return
     */
    List<UserDto> findUsers(String userName);
}
