package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.service.ICustomerLossService;
import cn.edu.cqut.crmservice.service.IOrdersService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-06-14
 */
@RestController  //给前端返回json数据
@CrossOrigin //允许跨域请求
@RequestMapping("/customerloss")
public class CustomerLossController {
    @Autowired  //自动从spring容器中获取对象给变量赋值
    private ICustomerLossService customerLossService;

    /**
     *
     * @param limit 每页行数
     * @param page 第几页
     * @return
     */
    @Auth(roles = "SALES")
    @GetMapping("/getCustomerLossList")
    public TableResult<CustomerLoss> getCustomerLossList(Integer limit, Integer page,CustomerLoss customerLoss){
        QueryWrapper<CustomerLoss> wrapper = new QueryWrapper<>();
        if (customerLoss.getCusId() == null) {
            Page<CustomerLoss> customerLossPage = new Page<>(page, limit);
            IPage<CustomerLoss> page1 = customerLossService.myPage(customerLossPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            // 条件查询
            System.out.println(customerLoss.getCusId());
            wrapper.eq("cus_id", customerLoss.getCusId()); // 第一个参数是字段名
            // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or
            Page<CustomerLoss> customerLossPage = new Page<>(page, limit);
            IPage<CustomerLoss> page1 = customerLossService.myPage(customerLossPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

}
