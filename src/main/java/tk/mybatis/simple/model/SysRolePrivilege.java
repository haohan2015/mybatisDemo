package tk.mybatis.simple.model;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/28 18:45
 */
public class SysRolePrivilege {

    private Long roleId;

    private Long privilegeId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
