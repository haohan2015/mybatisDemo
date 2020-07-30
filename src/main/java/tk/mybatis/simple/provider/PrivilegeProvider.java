package tk.mybatis.simple.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/29 16:45
 */
public class PrivilegeProvider {

    public String selectById(final Long id){
        return new SQL(){
            {
                SELECT("id,privilege_name,privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
