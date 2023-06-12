package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.service.IContactService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 前端控制器
 *
 * @author CQUT
 * @since 2023-06-08
 */
@RestController
@RequestMapping("/contact")
@CrossOrigin // 允许跨域请求
public class ContactController {
    @Autowired // 自动从Spring容器中获取对象给变量赋值
    private IContactService contactService;

    /**
     * @param limit 每页行数
     * @param page  显示第几页
     * @return TableResult
     */
    @GetMapping("/getContacts")
    public TableResult<Contact> getContactList(Integer limit, Integer page, Contact contact) {
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        if (contact.getCusId() == null) {
            Page<Contact> contactPage = new Page<>(page, limit);
            IPage<Contact> page1 = contactService.myPage(contactPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        } else {
            // 条件查询
            wrapper.eq("cus_id", contact.getCusId()); // 第一个参数是字段名
            // wrapper.or().eq() ，wrapper默认是and 需要eq前用or才能使用sql的or

            Page<Contact> contactPage = new Page<>(page, limit);
            IPage<Contact> page1 = contactService.myPage(contactPage, wrapper); // 调用service层的page方法,返回分页
            // getTotal()方法返回表里的总记录数,getRecords()方法返回当前页的数据列表
            return TableResult.ok("查询成功", page1.getTotal(), page1.getRecords());
        }
    }

    @PostMapping("/updateContact")
    public TableResult<Contact> updateContact(Contact contact) {
        contactService.updateById(contact);
        return TableResult.ok("修改联系人信息成功");
    }

    @PostMapping("/addContact")
    public TableResult<Contact> addContact(Contact contact) {
        contactService.save(contact);
        return TableResult.ok("新增联系人信息成功");
    }

    @PostMapping("/deleteContact")
    public TableResult<Contact> deleteContact(Integer[] ids) {//参数名要和前端ajax方法中data参数的属性名要一致
        contactService.removeByIds(Arrays.asList(ids));//asList方法把数组转成list
        return TableResult.ok("删除联系人信息成功");
    }
}
