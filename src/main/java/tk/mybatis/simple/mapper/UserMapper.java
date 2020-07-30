package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/28 18:53
 */
public interface UserMapper {

    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysUser> selectAllPro();

    List<SysRole> selectRolesByUserId(Long userId);

    int insert(SysUser sysUser);

    int insert2(SysUser sysUser);

    int insert3(SysUser sysUser);

    int updateById(SysUser sysUser);

    SysUser selectByUser(SysUser sysUser);

    List<SysUser> selectByIdList(@Param("ids") List<Long> idList);

    SysUser selectUserAndRoleById(Long id);

    SysUser selectUserAndRoleById2(Long id);

    SysUser selectUserAndRoleByIdSelect(Long id);

    List<SysUser> selectAllUserAndRoles();

    SysUser selectAllUserAndRolesSelect(Long id);

    void selectUserById(SysUser sysUser);

    List<SysUser> selectUserPage(Map<String,Object> params);

    int insertUserAndRoles(@Param("user") SysUser user,@Param("roleIds") String roleIds);

    int deleteUserById(Long id);

    Map<String,Object> selectByIdMap(Long id);
}
