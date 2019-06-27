package com.dao;

import com.Util.GetSession;
import com.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersDaoImpl implements UsersDao{

    private SqlSession sqlSession = null;
    @Override
    public List<Users> getUserList() {

        SqlSession sqlSession = null;
        List<Users> usersList = null;
        try {
            //4.持久化操作
            sqlSession = GetSession.getSqlSession();
            usersList = sqlSession.selectList("com.dao.UsersDao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭
            GetSession.close(sqlSession);
        }
        return usersList;
    }

    @Override
    public Users getUsersByID(Long id) {

        SqlSession sqlSession = null;
        Users users = null;
        try {
            //4.持久化操作
            sqlSession = GetSession.getSqlSession();
            users = sqlSession.selectOne("com.dao.UsersDao.getUsersByID", id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭
            GetSession.close(sqlSession);
        }
        return users;
    }

    @Override
    public Users getUserByNamePwd(String name, String pwd) {

        SqlSession sqlSession = null;
        //需要传递两个参数，采用接口Mapper反射的方式
        //三个参数及以上可用对象封装
        Users users = null;
        try {
            //4.持久化操作
            sqlSession = GetSession.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            users = usersDao.getUserByNamePwd(name, pwd);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭
            GetSession.close(sqlSession);
        }
        return users;
    }

    @Override
    public List<Users> getUsersByNameRID(String name, Integer roleId) {
        /*SqlSession sqlSession = getSqlsession();
        //需要传递两个参数，采用接口Mapper反射的方式
        //三个参数及以上可用对象封装
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        List<Users> users = usersDao.getUsersByNameRID(name, roleId);*/
        SqlSession sqlSession = null;
        List<Users> usersList = null;
        try {
            sqlSession = GetSession.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            usersList = usersDao.getUsersByNameRID(name, roleId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSession.close(sqlSession);
        }
        return usersList;
    }

    @Override
    public Integer insert(Users users) {
        SqlSession sqlSession = null;
        Integer num = null;
        try {
            sqlSession = GetSession.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            num = usersDao.insert(users);
            sqlSession.commit();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSession.close(sqlSession);
        }
        return num;
    }

    @Override
    public Integer delete(Long id) {
        SqlSession sqlSession = null;
        Integer num = null;
        try {
            sqlSession = GetSession.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            num = usersDao.delete(id);
            sqlSession.commit();
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSession.close(sqlSession);
        }
        return num;
    }

    @Override
    public Integer update(Users users) {
        SqlSession sqlSession = null;
        Integer num = null;
        try {
            sqlSession = GetSession.getSqlSession();
            UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
            num = usersDao.update(users);
            sqlSession.commit();
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            GetSession.close(sqlSession);
        }
        return num;
    }


}
