package own.jadezhang.user.dao;

import org.springframework.stereotype.Repository;
import own.jadezhang.common.dao.IBaseDAO;
import own.jadezhang.user.domain.Article;

/**
 * Created by Zhang Junwei on 2016/10/16.
 */
@Repository
public interface IArticleDAO extends IBaseDAO<Article> {
}
