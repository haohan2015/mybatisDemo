package tk.mybatis.simple.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.*;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 16:03
 */
@Intercepts(
        @Signature(
                type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}
        )
)
public class CameHumpInterceptor implements Interceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> list = (List<Object>) invocation.proceed();
        for (Object o:list) {
            if(o instanceof Map){
                processMap((Map<String, Object>) o);
            }else{
                break;
            }
        }
        return list;
    }

    private void processMap(Map<String,Object> map){
        Set<String> keySet = new HashSet<String>(map.keySet());
        for (String key:keySet) {
            if((key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') || key.indexOf("_") >= 0){
                Object value = map.get(key);
                map.remove(key);
                map.put(underLineToCamehump(key),value);
            }
        }
    }

    public static String underLineToCamehump(String inputString){
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCar = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if(c == '_'){
                if(sb.length() > 0){
                    nextUpperCar = true;
                }
            }else{
                if(nextUpperCar){
                    sb.append(Character.toUpperCase(c));
                    nextUpperCar = false;
                }else{
                    sb.append(Character.toLowerCase(c));
                }
            }
        }

        return sb.toString();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
