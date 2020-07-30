package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/28 19:22
 */
public class UserMapperTest extends BaseMapperTest{


    @Test
    public void selectByIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            System.out.println(user);
        }
    }

    @Test
    public  void  selectAllTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUsers = userMapper.selectAll();
            for (SysUser sysUser:sysUsers) {
                System.out.println(sysUser);
            }
        }
    }

    @Test
    public void selectAllProTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUsers = userMapper.selectAllPro();
            for (SysUser sysUser:sysUsers) {
                System.out.println(sysUser);
            }
        }
    }

    @Test
    public void selectRolesByUserIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRoles = userMapper.selectRolesByUserId(1L);
            for (SysRole sysRole:sysRoles) {
                System.out.println(sysRole);
            }
        }
    }

    @Test
    public void insertTest(){
        SqlSession sqlSession = getSqlSession();
        try{

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1,2,3});
            sysUser.setCreateTime(new Date());
            int result = userMapper.insert(sysUser);
            Assert.assertEquals(1,result);
            Assert.assertNull(sysUser.getId());

        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void insert2Test(){
        SqlSession sqlSession = getSqlSession();
        try{

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1,2,3});
            sysUser.setCreateTime(new Date());
            int result = userMapper.insert2(sysUser);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(sysUser.getId());

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void insert3Test(){
        SqlSession sqlSession = getSqlSession();
        try{

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1,2,3});
            sysUser.setCreateTime(new Date());
            int result = userMapper.insert3(sysUser);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(sysUser.getId());

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void updateByIdTest(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("admin",user.getUserName());

            user.setUserName("admin_test");

            user.setUserEmail("test@mybatis.tk");

            int result = userMapper.updateById(user);

            Assert.assertEquals(1,result);

            user = userMapper.selectById(1L);

            Assert.assertEquals("admin_test",user.getUserName());
        }finally {
            sqlSession.rollback();

            sqlSession.close();
        }
    }

    @Test
    public void selectByUserTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser = userMapper.selectByUser(sysUser);
            System.out.printf(sysUser.toString());
        }
    }

    @Test
    public void selectByIdListTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<>();
            idList.add(1L);
            idList.add(1001L);
            List<SysUser> sysUsers = userMapper.selectByIdList(idList);
            for (SysUser sysUser:sysUsers) {
                System.out.println(sysUser.toString());
            }
        }
    }

    @Test
    public void selectUserAndRoleByIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectUserAndRoleById(1001L);
            System.out.println(sysUser);
        }
    }

    @Test
    public void selectUserAndRoleById2Test(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectUserAndRoleById2(1001L);
            System.out.println(sysUser);
        }
    }

    @Test
    public void selectUserAndRoleByIdSelectTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectUserAndRoleByIdSelect(1001L);
            System.out.println(sysUser.getUserName());
            sysUser.equals(null);
            System.out.println("加载role");
            System.out.println(sysUser.getRole().toString());
        }
    }

    @Test
    public void selectAllUserAndRolesTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUsers = userMapper.selectAllUserAndRoles();
            for (SysUser sysUser:sysUsers) {
                System.out.println(sysUser.toString());
                System.out.println(sysUser.getSysRoles().size());
            }
        }
    }

    @Test
    public void selectAllUserAndRolesSelectTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectAllUserAndRolesSelect(1L);
            System.out.println("用户姓名="+sysUser.getUserName());
            for (SysRole sysRole:sysUser.getSysRoles()) {
                System.out.println("角色名称="+sysRole.getRoleName());
                for (SysPrivilege sysPrivilege:sysRole.getSysPrivileges()) {
                    System.out.println("权限名称="+sysPrivilege.getPrivilegeName());
                }
            }
        }
    }

    @Test
    public void selectUserByIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setId(1L);
            userMapper.selectUserById(sysUser);
            System.out.println(sysUser);
        }
    }

    @Test
    public void selectUserPageTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> params = new HashMap<>();
            params.put("userName","ad");
            params.put("offset",0);
            params.put("limit",10);
            List<SysUser> userList = userMapper.selectUserPage(params);
            Long total = (Long) params.get("total");
            System.out.println("总数：" + total);
            for (SysUser sysUser:userList) {
                System.out.println(sysUser);
            }
        }
    }

    @Test
    public void insertUserAndRolesTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1,2,3});

            userMapper.insertUserAndRoles(sysUser,"1,2");

            Assert.assertNotNull(sysUser.getId());
            Assert.assertNotNull(sysUser.getCreateTime());

            sqlSession.commit();

            userMapper.deleteUserById(sysUser.getId());
        }
    }

    @Test
    public void selectByIdMapTest(){
        try(SqlSession sqlSession = getSqlSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = userMapper.selectByIdMap(1L);
            System.out.println(map);
        }
    }
}
