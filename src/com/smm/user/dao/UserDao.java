package com.smm.user.dao;

import com.smm.user.pojo.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

/**
 * Created by TaroChen on 2017/8/4.
 */
public class UserDao extends HibernateDaoSupport {

    // Dao完成登录的代码
    public User login(User user) {
        String hql = "from User where username = ? and password = ?";
        List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
