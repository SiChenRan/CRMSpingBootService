package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Contact;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
public interface IContactService extends IService<Contact> {
    IPage<Contact> myPage(
            IPage<Contact> page, @Param(Constants.WRAPPER) QueryWrapper<Contact> queryWrapper);

}
