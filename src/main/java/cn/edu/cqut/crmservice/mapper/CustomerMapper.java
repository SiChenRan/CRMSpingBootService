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

    @Select("SELECT SUM(orders.odr_amount) value ,customer.cus_name item\n" +
            "FROM customer\n" +
            "JOIN orders ON customer.cus_id = orders.cus_id\n" +
            "WHERE customer.cus_name = #{username}\n" +
            "GROUP BY customer.cus_id")
    Report getAmountByReCusName(@Param("username") String username);

    @Select("SELECT CONCAT(cus_level, ', ', cus_industry)  item, COUNT(*) value  FROM customer GROUP BY cus_level, cus_industry")
    List<Report> getCustomerCountByIndustry();
    @Select("SELECT CONCAT(cus_credit, ', ', cus_industry) item, COUNT(*) value  FROM customer GROUP BY cus_credit, cus_industry")
    List<Report> getCustomerCountByCredit();
    @Select("SELECT ser_type AS item, COUNT(*) AS value FROM services WHERE YEAR(ser_process_time) = #{year} GROUP BY ser_type")
    List<Report> getServiceCountByTypeAndYear(@Param("year") int year);

    @Select("SELECT ser_type AS item, COUNT(*) AS value FROM services  GROUP BY ser_type")
    List<Report> getServiceCountByType();
//    @Select("SELECT customer_loss.cus_id, customer.cus_name, customer_loss.su_id, sys_user.su_name " +
//            "FROM customer_loss cl " +
//            "JOIN customer c ON cl.cus_id = c.cus_id " +
//            "JOIN sys_user u ON cl.su_id = u.su_id " +
//            "WHERE c.cus_name = #{name}")
//    List<Report> getCustomerLossRecordsByCustomerName(@Param("name") String name);

    @Select("SELECT  u.su_name item,COUNT(*)  value " +
            "FROM customer_loss cl " +
            "JOIN customer c ON cl.cus_id = c.cus_id " +
            "JOIN sys_user u ON cl.su_id = u.su_id " +
            "WHERE u.su_name = #{name}")
    List<Report> getCustomerLossRecordsBySalespersonName(@Param("name") String name);


}
