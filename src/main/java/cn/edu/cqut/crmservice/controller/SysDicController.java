package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.SysDic;
import cn.edu.cqut.crmservice.service.ISysDicService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haibara
 * @since 2023-06-14
 */
@RestController
@CrossOrigin
@RequestMapping("/sysDic")
public class SysDicController {

    @Autowired
    private ISysDicService dicService;

    @PostMapping("/create")
    public TableResult<Boolean> createDic(@RequestBody SysDic dic) {
        return TableResult.ok("create ok", dicService.save(dic));
    }

    @GetMapping("/list")
    public TableResult<SysDic> getAllDicList(Integer limit, Integer page) {
        Page<SysDic> userPage = dicService.page(new Page<>(page, limit));
        return TableResult.ok("list ok", userPage.getTotal(), userPage.getRecords());
    }

    @DeleteMapping("/del")
    public TableResult<Boolean> deleteDicById(@RequestParam Integer id) {
        return TableResult.ok("del ok", dicService.remove(new LambdaQueryWrapper<SysDic>().eq(SysDic::getId, id)));
    }

    @PostMapping("/update")
    public TableResult<Boolean> updateDic(@RequestBody SysDic sysDic) {
        return TableResult.ok("update ok", dicService.update(sysDic, new LambdaUpdateWrapper<SysDic>().eq(SysDic::getId, sysDic.getId())));
    }

}
