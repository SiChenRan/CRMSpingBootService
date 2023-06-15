package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

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
}
