package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.mapper.OrdersMapper;
import cn.edu.cqut.crmservice.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
