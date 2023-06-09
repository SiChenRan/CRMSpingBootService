package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
    @GetMapping("/getCustomerList")
    public TableResult<Customer> getCustomerList(Integer limit, Integer page) {
        Page<Customer> customerPage = new Page<>(page, limit);
        //调用service层的list方法，返回数据表中的所有数据,调用page方法实现分页查询
        Page<Customer> page1 = customerService.page(customerPage);
        //getTotal返回表里的总记录数，getRecords返回当前页的数据列表
        return TableResult.ok("查询成功！", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/updateCustomer")
    public TableResult<Customer> updateCustomer(Customer customer) {
        customerService.updateById(customer);
        return TableResult.ok("修改客户信息成功！");
    }


    @PostMapping("/addCustomer")//映射的地址与方法名没有关系
    public TableResult<Customer> addCustomer(Customer customer) {
        customerService.save(customer);
        return TableResult.ok("新增客户信息成功！");
    }

    @PostMapping("/deleteCustomer")//映射的地址与方法名没有关系
    public TableResult<Customer> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        customerService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除客户信息成功！");
    }
}
