package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.provider.PrivilegeProvider;

import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/28 18:54
 */
public interface PrivilegeMapper {

    @SelectProvider(type = PrivilegeProvider.class,method = "selectById")
    SysPrivilege selectById(Long id);


    List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}
