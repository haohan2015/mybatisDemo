package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.enums.Enabled;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.model.SysRole;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/29 16:20
 */
public class RoleMapperTest extends BaseMapperTest{


    @Test
    public void selectByIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById(1L);
            System.out.println(sysRole.toString());
        }
    }


    @Test
    public void selectById2Test(){
        try(SqlSession sqlSession = getSqlSession()){
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById3(1L);
            System.out.println(sysRole.toString());
        }
    }

    @Test
    public void insertTest(){
        SqlSession sqlSession = getSqlSession();
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setId(3L);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            sysRole.setEnabled(Enabled.disabled);
            sysRole.setRoleName("test");
            roleMapper.insert(sysRole);

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }


    @Test
    public void insert2Test(){
        SqlSession sqlSession = getSqlSession();
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setId(3L);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(new Date());
            sysRole.setEnabled(Enabled.disabled);
            sysRole.setRoleName("test");
            roleMapper.insert2(sysRole);
            System.out.printf("id ="+sysRole.getId());

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void selectRoleByUserIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoles = roleMapper.selectRoleByUserId(1001L);
            for (SysRole sysRole:sysRoles) {
                System.out.println(sysRole.toString());
                System.out.println(sysRole.getSysPrivileges().size());
            }
        }
    }

    @Test
    public void selectRoleByUserIdChooseTest(){
        try(SqlSession sqlSession = getSqlSession()){
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoles = roleMapper.selectRoleByUserIdChoose(1L);
            for (SysRole sysRole:sysRoles) {
                System.out.println("角色名称=" + sysRole.toString());
                if(sysRole.getSysPrivileges() != null){
                    for (SysPrivilege sysPrivilege:sysRole.getSysPrivileges()) {
                        System.out.println("权限名称=" + sysPrivilege.getPrivilegeName());
                    }
                }
            }
        }
    }

    @Test
    public void updateByIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole role = roleMapper.selectById(2L);
            Assert.assertEquals(Enabled.disabled,role.getEnabled());
            role.setEnabled(Enabled.disabled);
            roleMapper.updateById(role);
            sqlSession.rollback();
        }
    }

}
