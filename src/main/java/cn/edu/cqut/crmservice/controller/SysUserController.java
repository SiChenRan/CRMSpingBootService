package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.ISysUserService;
import cn.edu.cqut.crmservice.util.JWTUtil;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private JWTUtil jwtUtil = new JWTUtil();

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

}
