package tk.mybatis.simple.mapper;

import netscape.security.Privilege;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;

import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/29 16:51
 */
public class RolePrivilegeMapperTest extends BaseMapperTest{


    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = getSqlSession();
        try{
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege sysPrivilege = privilegeMapper.selectById(1L);
            System.out.println(sysPrivilege.toString());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectPrivilegeByRoleIdTest(){
        try(SqlSession sqlSession = getSqlSession()){
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            List<SysPrivilege> sysPrivileges = privilegeMapper.selectPrivilegeByRoleId(1L);
            for (SysPrivilege sysPrivilege:sysPrivileges) {
                System.out.println(sysPrivilege.toString());
            }
        }
    }

}
