package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.DevPlan;
import cn.edu.cqut.crmservice.service.IDevPlanService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public TableResult<DevPlan> getDevPlanList(Integer limit, Integer page) {
        Page<DevPlan> devPlanPage = new Page<>(page, limit);
        //调用service层的list方法，返回数据表中的所有数据,调用page方法实现分页查询
        Page<DevPlan> page1 = devPlanService.page(devPlanPage);
        //getTotal返回表里的总记录数，getRecords返回当前页的数据列表
        return TableResult.ok("查询成功！", page1.getTotal(), page1.getRecords());
    }
}
