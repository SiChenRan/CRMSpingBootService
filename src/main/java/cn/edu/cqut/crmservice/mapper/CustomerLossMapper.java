package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
public interface CustomerLossMapper extends BaseMapper<CustomerLoss> {
    @Select("SELECT * FROM customer c \n" +
            "WHERE c.cus_state='正常'\n" +
            "AND c.cus_id  IN(\n" +
            "select DISTINCT o.cus_id from orders o, customer c \n" +
            "\twhere o.cus_id=c.cus_id and c.cus_state='正常' and \n" +
            "\tnot EXISTS(select * from customer_loss cl where cl.cl_status in(1,2) and o.cus_id=cl.cus_id)\n" +
            "GROUP BY o.cus_id HAVING DATEDIFF(now(),max(o.odr_time))>180\n" +
            ")")
    List<Customer> querryLossCustomers();

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
