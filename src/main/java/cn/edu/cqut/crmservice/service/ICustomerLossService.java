package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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
    IPage<CustomerLoss> myPage(
            IPage<CustomerLoss> page, @Param(Constants.WRAPPER) QueryWrapper<CustomerLoss> queryWrapper);

}
