package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.service.IOrdersService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {
    @Autowired
    IOrdersService ordersService;

    @Auth(roles = "SALES")
    @GetMapping("/getOrdersList")
    public TableResult<Orders> getOrdersList(Integer limit, Integer page) {
        Page<Orders> ordersPage = new Page<>(page, limit);
        Page<Orders> page1 = ordersService.page(ordersPage); // 调用service层的page方法,返回分页
        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }
}
