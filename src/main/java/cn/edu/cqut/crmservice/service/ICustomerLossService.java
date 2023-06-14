package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Haibara
 * @since 2023-06-14
 */
public interface ICustomerLossService extends IService<CustomerLoss> {
    IPage<CustomerLoss> myPage(
            IPage<CustomerLoss> page, @Param(Constants.WRAPPER) QueryWrapper<CustomerLoss> queryWrapper);
}
