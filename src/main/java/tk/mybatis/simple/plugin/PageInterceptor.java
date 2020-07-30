package tk.mybatis.simple.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 16:50
 */
@Intercepts(
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class,Object.class,
                        RowBounds.class, ResultHandler.class}
        )
)
public class PageInterceptor implements Interceptor{

    private static final List<ResultMapping> EMPTY_RESULTMAPPING = new ArrayList<>(0);

    private Dialect dialect;

    private Field additionalParametersField;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        if(true){

        }

        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
