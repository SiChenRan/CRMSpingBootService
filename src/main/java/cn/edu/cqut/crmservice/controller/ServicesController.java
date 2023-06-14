package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.IServicesService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@RestController // 给前端返回JSON数据
@RequestMapping("/services")
@CrossOrigin // 允许跨域请求
public class ServicesController {
    @Autowired // 自动从Spring容器中获取对象给变量赋值
    private IServicesService servicesService;

    /**
     * @param limit 每页行数
     * @param page  显示第几页
     * @return TableResult
     */
    @GetMapping("/getServiceList")
    @Auth(roles = "SALES")
    public TableResult<Services> getServicesList(Integer limit, Integer page) {
        Page<Services> servicesPage = new Page<>(page, limit);
        Page<Services> page1 = servicesService.page(servicesPage); // 调用service层的page方法,返回分页
        // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @GetMapping("/getWaitProcessList")
    @Auth(roles = "SALES")
    public TableResult<Services> getWaitProcessList(Integer limit, Integer page, SysUser sysUser) {
        if (sysUser.getSuName() != null) {
            QueryWrapper<Services> wrapper = new QueryWrapper<>();
            // 条件查询
            wrapper.eq("ser_handler", sysUser.getSuName()); // 第一个参数是字段名
            Page<Services> servicePage = new Page<>(page, limit);
            Page<Services> page1 = servicesService.page(servicePage, wrapper);
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            return TableResult.error(1, "系统异常，无法获取当前登录用户");
        }
    }

    @GetMapping("/getWaitFeedbackList")
    @Auth(roles = "SALES")
    public TableResult<Services> getWaitFeedbackList(Integer limit, Integer page, SysUser sysUser) {
        if (sysUser.getSuName() != null) {
            QueryWrapper<Services> wrapper = new QueryWrapper<>();
            // 条件查询
            wrapper.eq("ser_handler", sysUser.getSuName()); // 第一个参数是字段名
            wrapper.eq("ser_state", "已处理");
            Page<Services> servicePage = new Page<>(page, limit);
            Page<Services> page1 = servicesService.page(servicePage, wrapper);
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            return TableResult.error(1, "系统异常，无法获取当前登录用户");
        }
    }

    @GetMapping("/getArchivingServicesList")
    @Auth(roles = "SUPERVISOR")
    public TableResult<Services> getArchivingServicesList(Integer limit, Integer page, Services service) {
        QueryWrapper<Services> wrapper = new QueryWrapper<>();

        // 条件查询
        if(!Objects.equals(service.getSerType(), "")&&service.getSerType()!=null) {
            wrapper.eq("ser_type", service.getSerType());
        }
        wrapper.eq("ser_state", "已归档");
        if(!Objects.equals(service.getSerHandler(), "")&&service.getSerHandler()!=null) {
            wrapper.eq("ser_handler", service.getSerHandler());
        }
        Page<Services> servicePage = new Page<>(page, limit);
        Page<Services> page1 = servicesService.page(servicePage, wrapper);
        return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
    }

    @PostMapping("/assignService")
    @Auth(roles = "SUPERVISOR")
    public TableResult<Services> assignService(Services service) {
        servicesService.updateById(service);
        return TableResult.ok("分配服务成功");
    }

    @PostMapping("/processService")
    @Auth(roles = "SALES")
    public TableResult<Services> processService(Services service) {
        service.setSerState("已处理");
        servicesService.updateById(service);
        return TableResult.ok("添加服务处理信息成功");
    }

    @PostMapping("/feedbackService")
    @Auth(roles = "SALES")
    public TableResult<Services> feedbackService(Services service) {
        if (service.getSerCusRate() < 3) {
            service.setSerState("已分配");
            service.setSerCusFeedback("");
            service.setSerProcessMethod("");
            service.setSerCusRate(null);
            service.setSerFeedbackTime(null);
            service.setSerProcessTime(null);
        } else {
            service.setSerState("已归档");
        }
        servicesService.updateById(service);
        return TableResult.ok("添加服务反馈信息成功");
    }

    @PostMapping("/addService")
    @Auth(roles = "SALES")
    public TableResult<Services> addService(Services service) {
        service.setSerState("新创建");
        servicesService.save(service);
        return TableResult.ok("新增服务信息成功");
    }

}
