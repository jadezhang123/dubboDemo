package own.jadezhang.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import own.jadezhang.common.dao.IBaseDAO;
import own.jadezhang.user.domain.User;
import own.jadezhang.user.domain.UserEx;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Junwei on 2016/10/16.
 */
@Repository
public interface IUserDAO extends IBaseDAO<User> {
    /**
     * 查询用户，附带关联的文章
     * @param condition
     * @return
     */
    List<UserEx> getUserWithArticles(@Param("condition") Map<String, Object> condition);
}
