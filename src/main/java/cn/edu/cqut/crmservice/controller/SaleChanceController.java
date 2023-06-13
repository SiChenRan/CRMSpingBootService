package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.SaleChance;
import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.ICustomerService;
import cn.edu.cqut.crmservice.service.ISaleChanceService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jetbrains.annotations.NotNull;
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
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/saleChance")
@CrossOrigin
public class SaleChanceController {
    @Autowired
    private ISaleChanceService saleChanceService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/getSaleChanceList")
    public TableResult<SaleChance> getSaleChanceList(Integer limit, Integer page) {
        Page<SaleChance> saleChancePage = new Page<>(page, limit);
        //调用service层的list方法，返回数据表中的所有数据,调用page方法实现分页查询
        Page<SaleChance> page1 = saleChanceService.page(saleChancePage);
        //getTotal返回表里的总记录数，getRecords返回当前页的数据列表
        return TableResult.ok("查询成功！", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/addSaleChance")//映射的地址与方法名没有关系
    public TableResult<SaleChance> addSaleChance(@NotNull SaleChance saleChance) {
//        System.out.println(request.getAttribute("suName"));
//        saleChance.setSalCreator((String) request.getAttribute("suName"));

        saleChance.setSalCreatTime(LocalDateTime.now());
        saleChance.setSalState(1);
        saleChanceService.save(saleChance);
        return TableResult.ok("新增销售机会成功！");
    }

    @PostMapping("/updateSaleChance")
    public TableResult<SaleChance> updateSaleChance(SaleChance saleChance) {
        saleChanceService.updateById(saleChance);
        return TableResult.ok("修改销售机会成功！");
    }

    @PostMapping("/deleteSaleChance")//映射的地址与方法名没有关系
    public TableResult<SaleChance> deleteSaleChance(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        saleChanceService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除销售机会信息成功！");
    }

    @PostMapping("/assto")
    public TableResult<SaleChance> assto(SaleChance saleChance) {
        saleChance.setSalAssTime(LocalDateTime.now());
        saleChance.setSalState(2);
        saleChanceService.updateById(saleChance);
        return TableResult.ok("指派成功！");
    }

    @GetMapping("/getPersonalSaleChanceList")
    public TableResult<SaleChance> getPersonalSaleChanceList(Integer limit, Integer page, SysUser sysUser) {
        QueryWrapper<SaleChance> wrapper = new QueryWrapper<>();
        if (sysUser.getSuName() == null) {
            Page<SaleChance> saleChancePage = new Page<>(page, limit);
            IPage<SaleChance> page1 = saleChanceService.page(saleChancePage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            // 条件查询
            wrapper.eq("sal_assto", sysUser.getSuName()); // 第一个参数是字段名
            // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or

            Page<SaleChance> saleChancePage = new Page<>(page, limit);
            IPage<SaleChance> page1 = saleChanceService.page(saleChancePage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    @PostMapping("/devSuccess")
    public TableResult<SaleChance> devSuccess(SaleChance saleChance) {
        saleChance.setSalState(3);
        Customer customer = new Customer();
        customer.setCusName(saleChance.getCusName());
        customer.setCusRegion("华东");
        customer.setCusIndustry("金融");
        customer.setCusLevel("普通客户");
        customer.setCusRate(5);
        customer.setCusCredit(5);
        customer.setCusAddr("上海市浦东区");
        customer.setCusPhone(saleChance.getSalContactTel());
        customerService.save(customer);
        saleChanceService.updateById(saleChance);
        return TableResult.ok("修改销售机会成功！");
    }

    @PostMapping("/devFailure")
    public TableResult<SaleChance> devFailure(SaleChance saleChance) {
        saleChance.setSalState(4);
        saleChanceService.updateById(saleChance);
        return TableResult.ok("修改销售机会成功！");
    }


}
