package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.BusinessRecord;
import cn.edu.cqut.crmservice.service.IBusinessRecordService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/businessRecord")
@CrossOrigin
public class BusinessRecordController {
    @Autowired // 自动从Spring容器中获取对象给变量赋值
    private IBusinessRecordService businessRecordService;

    /**
     * @param limit 每页行数
     * @param page 显示第几页
     * @return TableResult
     */
    @GetMapping("/getBusinessRecordList")
    @Auth(roles = "SALES")
    public TableResult<BusinessRecord> getBusinessRecordList(Integer limit, Integer page, BusinessRecord businessRecord) {
        if (businessRecord.getCusId() == null) {
            Page<BusinessRecord> businessRecordPage = new Page<>(page, limit);
            Page<BusinessRecord> page1 = businessRecordService.page(businessRecordPage); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            // 条件查询
            QueryWrapper<BusinessRecord> wrapper = new QueryWrapper<>();
            wrapper.eq("cus_id", businessRecord.getCusId()); // 第一个参数是字段名
            // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or

            Page<BusinessRecord> businessRecordPage = new Page<>(page, limit);
            Page<BusinessRecord> page1 = businessRecordService.page(businessRecordPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    @PostMapping("/updateBusinessRecord")
    @Auth(roles = "SALES")
    public TableResult<BusinessRecord> updateBusinessRecord(BusinessRecord businessRecord){
        businessRecordService.updateById(businessRecord);
        return TableResult.ok("修改联系人信息成功");
    }

    @PostMapping("/addBusinessRecord")
    @Auth(roles = "SALES")
    public TableResult<BusinessRecord> addBusinessRecord(BusinessRecord businessRecord){
        businessRecordService.save(businessRecord);
        return TableResult.ok("新增联系人信息成功");
    }

    @PostMapping("/deleteBusinessRecord")
    @Auth(roles = "SALES")
    public TableResult<BusinessRecord> deleteBusinessRecord(Integer[] ids){//参数名要和前端ajax方法中data参数的属性名要一致
        businessRecordService.removeByIds(Arrays.asList(ids));//asList方法把数组转成list
        return TableResult.ok("删除联系人信息成功");
    }
}
