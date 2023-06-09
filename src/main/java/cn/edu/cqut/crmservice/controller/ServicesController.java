package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.service.IServicesService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
@RestController//给前端返回json数据
@CrossOrigin//允许跨域请求
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IServicesService servicesService;

    /**
     * @param limit 每页行数
     * @param page  第几页
     * @return page1
     */
    @GetMapping("/getServicesList")
    public TableResult<Services> getServicesList(Integer limit, Integer page) {
        Page<Services> servicesPage = new Page<>(page, limit);
        //调用service层的list方法，返回数据表中的所有数据,调用page方法实现分页查询
        Page<Services> page1 = servicesService.page(servicesPage);
        //getTotal返回表里的总记录数，getRecords返回当前页的数据列表
        return TableResult.ok("查询成功！", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/addService")//映射的地址与方法名没有关系
    public TableResult<Customer> addCustomer(Services services) {
        services.setSerCreTime(LocalDateTime.now());
        services.setSerState("新创建");
        servicesService.save(services);
        return TableResult.ok("新增服务成功！");
    }

    @PostMapping("/updateService")
    public TableResult<Services> updateCustomer(Services services) {
        servicesService.updateById(services);
        return TableResult.ok("修改服务成功！");
    }

    @PostMapping("/deleteService")//映射的地址与方法名没有关系
    public TableResult<Customer> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        servicesService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除服务成功！");
    }

}
