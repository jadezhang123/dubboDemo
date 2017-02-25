package own.jadezhang.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import own.jadezhang.common.service.AbstractServiceImpl;
import own.jadezhang.user.dao.IUserDAO;
import own.jadezhang.user.domain.User;
import own.jadezhang.user.domain.UserEx;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Junwei on 2016/10/16.
 */
@Service("userServiceImpl")
public class UserServiceImpl extends AbstractServiceImpl<IUserDAO, User> implements IUserService<IUserDAO, User> {

    @Resource
    private TransactionTemplate transactionTemplate;

    @Autowired
    private IUserDAO userDAO;

    @Override
    public IUserDAO getDao() {
        return userDAO;
    }


    @Override
    public Integer deleteUser(final Long id) {

        Integer count = transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                Integer count = userDAO.deleteById(id);
                return count;
            }
        });
        return count;
    }

    @Override
    public List<UserEx> getUserWithArticles(Map<String, Object> condition) {
        return userDAO.getUserWithArticles(condition);
    }
}
