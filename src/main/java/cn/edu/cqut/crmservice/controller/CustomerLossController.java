package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.service.ICustomerLossService;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.service.IOrdersService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
@RestController//给前端返回json数据
@RequestMapping("/customerLoss")
@CrossOrigin//允许跨域请求
public class CustomerLossController {
    @Autowired//自动从Spring容器中获取对象给变量赋值
    private ICustomerLossService customerLossService;
    @Autowired
    private IOrdersService ordersService;
    /**
     * @param limit 每页行数
     * @param page  第几页
     * @return page1
     */
    @Auth(roles = "SALES")
    @GetMapping("/getCustomerLossList")
    public TableResult<CustomerLoss> getCustomerList(Integer limit, Integer page) {
        Page<CustomerLoss> customerLossPage = new Page<>(page, limit);
        Page<CustomerLoss> page1 = customerLossService.page(customerLossPage); // 调用service层的page方法,返回分页
        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }
    @Auth(roles = "SALES")
    @PostMapping ("/updateLoss")
    public TableResult<CustomerLoss> updateLoss(CustomerLoss customerLoss) {
        customerLossService.updateById(customerLoss);
        return TableResult.ok("成功！");
    }

    //定时任务,每天晚上2点执行,将180天没订单的客户加入流失表
    @Scheduled(cron = "0 0 2 * * *")
    @GetMapping("/getCustomerLossrep")
    public TableResult<Integer> updateCustomerState(){
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        List<Customer> lossCustomerList = customerLossService.querryLossCustomers();
        if(lossCustomerList !=null && lossCustomerList.size()>0){
            List<CustomerLoss> customerLossList=new ArrayList<>();
            lossCustomerList.forEach(customer -> {
                queryWrapper.eq("cus_id",customer.getCusId());
                Orders orders=ordersService.getOne(queryWrapper);
                CustomerLoss customerLoss=new CustomerLoss();
                customerLoss.setClLossTime(null);
                customerLoss.setClLossReason("");
                customerLoss.setClOrderTime(orders.getOdrTime());
                customerLoss.setClPause("");
                customerLoss.setCusId(customer.getCusId());
                customerLoss.setClStatus(1);
                customerLoss.setCusSalesman(customer.getCusSalesman());
                customerLossList.add(customerLoss);
                System.out.println(customerLoss);
                customerLossService.save(customerLoss);
            });
        }
        return TableResult.ok("成功",lossCustomerList.size());
    }
}
