package tk.mybatis.simple.model;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/28 18:39
 */
public class SysUser {

    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userInfo;

    private byte[] headImg;

    private Date createTime;

    private SysRole role;

    private List<SysRole> sysRoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", headImg=" + Arrays.toString(headImg) +
                ", createTime=" + createTime +
                ", role=" + role +
                '}';
    }
}
