package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.mapper.CustomerMapper;
import cn.edu.cqut.crmservice.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public List<Report> getCustomerCountByRegion() {
        return baseMapper.getCustomerCountByRegion();
    }


}
