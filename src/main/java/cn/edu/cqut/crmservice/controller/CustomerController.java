package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jetbrains.annotations.Async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
@RestController//给前端返回json数据
@RequestMapping("/customer")
@CrossOrigin//允许跨域请求
public class CustomerController {

    @Autowired//自动从Spring容器中获取对象给变量赋值
    private ICustomerService customerService;

    /*
      增删改查的开发顺序，1.查询，2.修改，3.新增，4.删除
     */

    /**
     * @param limit 每页行数
     * @param page  第几页
     * @return page1
     */
    @Auth(roles = {"ADMIN","SALES","SUPERVISOR","MANAGER"})
    @GetMapping("/getCustomerList")
    public TableResult<Customer> getCustomerList(Integer limit, Integer page, HttpServletRequest request) {
        System.out.println(request.getAttribute("suId"));
        System.out.println(request.getAttribute("suName"));
        System.out.println(request.getAttribute("suRole"));
        if (limit == null && page == null) {
            List<Customer> customerList = customerService.list();
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功",customerList.size(),customerList);

        } else {
            Page<Customer> customerPage = new Page<>(page, limit);
            Page<Customer> page1 = customerService.page(customerPage); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/updateCustomer")
    public TableResult<Customer> updateCustomer(Customer customer) {
        customerService.updateById(customer);
        return TableResult.ok("修改客户信息成功！");
    }

    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/addCustomer")//映射的地址与方法名没有关系
    public TableResult<Customer> addCustomer(Customer customer) {
        customerService.save(customer);
        return TableResult.ok("新增客户信息成功！");
    }

    @Auth(roles = {"SALES","ADMIN"})
    @PostMapping("/deleteCustomer")//映射的地址与方法名没有关系
    public TableResult<Customer> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        customerService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除客户信息成功！");
    }

//    @Scheduled(cron = "0/5 * * * * *")
//    public void job() {
//        System.out.println("==================="+System.currentTimeMillis());
//    }
}
