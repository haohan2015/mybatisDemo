package tk.mybatis.simple.model;

import tk.mybatis.simple.enums.Enabled;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/28 18:46
 */
public class SysRole implements Serializable{

    private static final long serialVersionUID = -9136674056856806600L;

    private Long id;

    private String roleName;

    private Enabled enabled;

    private Long createBy;

    private Date createTime;

    private SysUser user;

    private List<SysPrivilege> sysPrivileges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<SysPrivilege> getSysPrivileges() {
        return sysPrivileges;
    }

    public void setSysPrivileges(List<SysPrivilege> sysPrivileges) {
        this.sysPrivileges = sysPrivileges;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled=" + enabled +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", user=" + user +
                '}';
    }
}
