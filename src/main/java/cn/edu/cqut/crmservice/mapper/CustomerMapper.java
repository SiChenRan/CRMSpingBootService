package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("SELECT COUNT(*) value, cus_region item from customer GROUP BY cus_region")
    List<Report> getCustomerCountByRegion();

    @Select("SELECT Sum(odr_amount) value, cus_id item from orders GROUP BY cus_id")
    List<Report> getAmountByReCusID();

    @Select("SELECT cus_name FROM customer WHERE cus_id = #{id}")
    String getCustomerNameById(@Param("id") int id);
}
