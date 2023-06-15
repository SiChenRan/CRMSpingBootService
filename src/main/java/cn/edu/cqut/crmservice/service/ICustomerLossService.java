package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
public interface ICustomerLossService extends IService<CustomerLoss> {
    List<Customer> querryLossCustomers();
}
