package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.Country;

import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/29 10:44
 */
public interface CountryMapper {

    List<Country> selectAll();

}
