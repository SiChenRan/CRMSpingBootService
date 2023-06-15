package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import cn.edu.cqut.crmservice.mapper.CustomerLossMapper;
import cn.edu.cqut.crmservice.service.ICustomerLossService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
@Service
public class CustomerLossServiceImpl extends ServiceImpl<CustomerLossMapper, CustomerLoss> implements ICustomerLossService {
    @Override
    public List<Customer> querryLossCustomers() {
        return baseMapper.querryLossCustomers();
    }
    @Override
    public IPage<CustomerLoss> myPage(IPage<CustomerLoss> page, @Param(Constants.WRAPPER) QueryWrapper<CustomerLoss> queryWrapper){
        return baseMapper.myPage(page,queryWrapper);
    }
}
