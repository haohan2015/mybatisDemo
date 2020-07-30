package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/27 15:46
 */
public class CountryMapperTest  extends BaseMapperTest{

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try{
            List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
            printCountryList(countryList);
        }finally {
            sqlSession.close();
        }

    }

    private void printCountryList(List<Country> countryList){
        for (Country country:countryList) {
            System.out.printf("%-4d%4s%4s\n",country.getId(),country.getCountryname(),country.getCountryname());
        }
    }

}
