package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.DevPlan;
import cn.edu.cqut.crmservice.service.IDevPlanService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-12
 */
@RestController
@RequestMapping("/devPlan")
@CrossOrigin
public class DevPlanController {
    @Autowired
    private IDevPlanService devPlanService;

    @GetMapping("/getDevPlanList")
    public TableResult<DevPlan> getDevPlanList(Integer limit, Integer page, DevPlan devPlan) {
//        Page<DevPlan> devPlanPage = new Page<>(page, limit);
//        //调用service层的list方法，返回数据表中的所有数据,调用page方法实现分页查询
//        Page<DevPlan> page1 = devPlanService.page(devPlanPage);
//        //getTotal返回表里的总记录数，getRecords返回当前页的数据列表
//        return TableResult.ok("查询成功！", page1.getTotal(), page1.getRecords());
        QueryWrapper<DevPlan> wrapper = new QueryWrapper<>();
        if (devPlan.getSalId() == null) {
            Page<DevPlan> devPlanPage = new Page<>(page, limit);
            IPage<DevPlan> page1 = devPlanService.page(devPlanPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            // 条件查询
            wrapper.eq("sal_id", devPlan.getSalId()); // 第一个参数是字段名
            // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or

            Page<DevPlan> devPlanPage = new Page<>(page, limit);
            IPage<DevPlan> page1 = devPlanService.page(devPlanPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    @PostMapping("/addDevPlan")//映射的地址与方法名没有关系
    public TableResult<DevPlan> addDevPlan(DevPlan devPlan) {
//        devPlan.setDevDate(LocalDate.now());
        devPlanService.save(devPlan);
        return TableResult.ok("制定开发计划成功！");
    }

    @PostMapping("/updateDevPlan")
    public TableResult<DevPlan> updateSaleChance(DevPlan devPlan) {
        devPlanService.updateById(devPlan);
        return TableResult.ok("修改开发计划成功！");
    }

    @PostMapping("/execDevPlan")
    public TableResult<DevPlan> execSaleChance(DevPlan devPlan) {
        devPlan.setDevDateexec(LocalDate.now());
        boolean isFirst = true;
        for (int i = devPlan.getDevResult().length() - 1; i >= 0; i--) {
            if (devPlan.getDevResult().charAt(i) == '-') {
                isFirst = false;
                break;
            }
        }
        if (isFirst) {
            devPlan.setDevResult(devPlan.getDevResult() + "----" + LocalDate.now());
        } else {
            if (devPlan.getDevResult().charAt(devPlan.getDevResult().length() - 11) != '2' && devPlan.getDevResult().charAt(devPlan.getDevResult().length() - 12) != '-') {
                devPlan.setDevResult(devPlan.getDevResult() + "----" + LocalDate.now());
            }
        }
        devPlanService.updateById(devPlan);
        return TableResult.ok("填写计划结果成功！");
    }

    @PostMapping("/deleteDevPlan")
    public TableResult<DevPlan> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        devPlanService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除开发计划成功！");
    }

}
