package tk.mybatis.simple.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import tk.mybatis.simple.enums.Enabled;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 11:02
 */
public class EnabledTypeHandler implements TypeHandler<Enabled>{

    private final Map<Integer,Enabled> enabledMap = new HashMap<>();

    public EnabledTypeHandler() {
        for (Enabled enabled:Enabled.values()) {
            enabledMap.put(enabled.getValue(),enabled);
        }
    }

    public EnabledTypeHandler(Class<?> type){
        this();
        System.out.println("type = [" + type.getName() + "]");
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Enabled enabled, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,enabled.getValue());
    }

    @Override
    public Enabled getResult(ResultSet resultSet, String s) throws SQLException {
        Integer value = resultSet.getInt(s);
        return enabledMap.get(value);
    }

    @Override
    public Enabled getResult(ResultSet resultSet, int i) throws SQLException {
        Integer value = resultSet.getInt(i);
        return enabledMap.get(value);
    }

    @Override
    public Enabled getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer value = callableStatement.getInt(i);
        return enabledMap.get(value);
    }
}
