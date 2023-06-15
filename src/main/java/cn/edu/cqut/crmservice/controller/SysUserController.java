package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.ISysUserService;
import cn.edu.cqut.crmservice.util.Auth;
import cn.edu.cqut.crmservice.util.JWTUtil;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-11
 */
@RestController
@RequestMapping("/sysUser")
@CrossOrigin
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")

    public TableResult<SysUser> login(SysUser sysUser) {
        //查询多条件为等于关系
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>(sysUser);
        SysUser user = sysUserService.getOne(wrapper);
        if (user != null) {
            String token = jwtUtil.createJwt(user);
            return TableResult.ok(token, user);
        } else {
            return TableResult.error(1, "用户名或密码错误");
        }
    }

    @Auth(roles = {"ADMIN"})

    @PostMapping("/addSysUser")//映射的地址与方法名没有关系
    public TableResult<SysUser> addCustomer(SysUser sysUser) {
        sysUserService.save(sysUser);
        return TableResult.ok("新增客户信息成功！");
    }

    @Auth(roles = {"ADMIN"})

    @GetMapping("/getSalesList")
    public List<SysUser> getSalesList() {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        // 条件查询
        wrapper.eq("su_role", "SALES"); // 第一个参数是字段名
        // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or
        return sysUserService.list(wrapper);
    }

    @Auth(roles = {"ADMIN"})

    //    @Auth()
    @PostMapping("/create")
    public TableResult<Boolean> createUser(@RequestBody SysUser sysUser) {
        return TableResult.ok("create ok", sysUserService.save(sysUser));
    }

    @Auth(roles = {"ADMIN"})

    //    @Auth()
    @GetMapping("/list")
    public TableResult<SysUser> getAllUserList(Integer limit, Integer page) {
        Page<SysUser> userPage = sysUserService.page(new Page<>(page, limit));
        return TableResult.ok("list ok", userPage.getTotal(), userPage.getRecords());
    }

    @Auth(roles = {"ADMIN"})

    //    @Auth()
    @DeleteMapping("/del")
    public TableResult<Boolean> deleteUserById(@RequestParam Integer id) {
        return TableResult.ok("del ok", sysUserService.remove(new LambdaQueryWrapper<SysUser>().eq(SysUser::getSuId, id)));
    }

    @Auth(roles = {"ADMIN"})

    //    @Auth()
    @PostMapping("/update")
    public TableResult<Boolean> updateUser(@RequestBody SysUser sysUser) {
        return TableResult.ok("update ok", sysUserService.update(sysUser, new LambdaUpdateWrapper<SysUser>().eq(SysUser::getSuId, sysUser.getSuId())));
    }
}
