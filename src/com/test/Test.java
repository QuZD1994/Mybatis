package com.test;

import com.dao.RoleDao;
import com.dao.RoleDaoImpl;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.entity.Role;
import com.entity.Users;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        UsersDao usersDao = new UsersDaoImpl();
        RoleDao roleDao = new RoleDaoImpl();
        /*List<Users> usersList = usersDao.getUserList();
        System.out.println(usersList.size());*/
        /*Users users = usersDao.getUsersByID(new Long(1));
        System.out.println(users.getName() + " " + users.getPwd());*/
        /*Users users = usersDao.getUserByNamePwd("曲志雕", "123456");
        System.out.println(users.getId());*/
        /*List<Users> usersList = usersDao.getUsersByNameRID("曲晨",2);
        System.out.println("用户编号\t用户名\t角色名称\t");
        for (Users users: usersList) {
            System.out.println(users.getId() + "\t" + users.getName()+ "\t" + users.getRole().getRoleName());
        }*/
        /*Role role = roleDao.getRoleID(new Long(3));
        System.out.println(role.getRoleName());
        //查询角色实体时，能不能把角色相关用户列表查询出来：在角色实体中放一个用户集合
        List<Users> usersList = role.getUsersList();
        System.out.println("用户编号\t用户名\t");
        for (Users users: usersList) {
            System.out.println(users.getId() + "\t" + users.getName()+ "\t");
        }*/
        /*Users users = new Users(new Long(8), "陈明", "123456" , new Long(3));
        Integer integer = usersDao.insert(users);
        System.out.println(integer);*/
        /*Integer integer = usersDao.delete(new Long(9));*/
        Users users = usersDao.getUsersByID(new Long(8));
        users.setName("陈同");
        users.setRoleId(new Long(2));
        usersDao.update(users);

    }
}
