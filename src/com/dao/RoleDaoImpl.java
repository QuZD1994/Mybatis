package com.dao;

import com.Util.GetSession;
import com.entity.Role;
import org.apache.ibatis.session.SqlSession;

public class RoleDaoImpl implements RoleDao{
    @Override

    public Role getRoleID(Long id) {

        SqlSession sqlSession = null;
        Role role = null;
        try {
            //4.持久化操作
            sqlSession = GetSession.getSqlSession();
            role = sqlSession.selectOne("com.dao.RoleDao.getRoleID", id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭
            GetSession.close(sqlSession);
        }
        return role;
    }
}
