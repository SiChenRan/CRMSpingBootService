package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Contact;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * Mapper 接口
 *
 * @author CQUT
 * @since 2023-06-08
 */
public interface ContactMapper extends BaseMapper<Contact> {
    /**
     * #是一个占位符，$是拼接符; 使用 # 能够防止sql注入，$不能避免注入攻击。 #的方式引用参数，mybatis会先对sql语句进行预编译，
     * 然后再引用值，能够有效防止sql注入，提高安全性。 $的方式引用参数，sql语句不进行预编译。
     */
    @Select("select * from contact ${ew.customSqlSegment}")
    @Results({
            //cus_id用于关联查询后，原理的cusId属性不会有值，为了让它有值，需要重新映射一遍
            @Result(column = "cus_id", property = "cusId"),
            // 多对一关联查询
            @Result(column = "cus_id", property = "customer",
                    // 多对一用One，一对多用many，select参数是更具关联字段查询关联对象的mapper方法
                    one = @One(select = "cn.edu.cqut.crmservice.mapper.CustomerMapper.selectById", fetchType = FetchType.EAGER))})
    IPage<Contact> myPage(IPage<Contact> page, @Param(Constants.WRAPPER) QueryWrapper<Contact> queryWrapper);
}
