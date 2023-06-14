package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Haibara
 * @since 2023-06-14
 */
public interface CustomerLossMapper extends BaseMapper<CustomerLoss> {
    @Select("select * from customer_loss ${ew.customSqlSegment}")
    @Results({
            //cus_id用于关联查询后，原理的cusId属性不会有值，为了让它有值，需要重新映射一遍
            @Result(column = "cus_id", property = "cusId"),
            // 多对一关联查询
            @Result(column = "cus_id", property = "customer",
                    // 多对一用One，一对多用many，select参数是更具关联字段查询关联对象的mapper方法
                    one = @One(select = "cn.edu.cqut.crmservice.mapper.CustomerMapper.selectById", fetchType = FetchType.EAGER))})
    IPage<CustomerLoss> myPage(IPage<CustomerLoss> page, @Param(Constants.WRAPPER) QueryWrapper<CustomerLoss> queryWrapper);
}
