package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.service.IContactService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
@RestController
@RequestMapping("/contact")
@CrossOrigin
public class ContactController {
    @Autowired
    private IContactService contactService;

    /**
     * .
     *
     * @param limit   每页行数
     * @param page    第几页
     * @param contact 前端传输过来的contact对象
     * @return -
     */
    @GetMapping("/getContacts")
    public TableResult<Contact> getContactList(Integer page, Integer limit, Contact contact) {

        //条件查询
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        //property:属性名;     column:数据库的字段名
        wrapper.eq("cus_id", contact.getCusId());
        /*
          wrapper.or().eq("***");
          @method or() 两个条件为或关系，默认and关系
         */
        Page<Contact> contactPage = new Page<>(page, limit);
        //调用service层的list方法，返回数据表中的所有数据,调用page方法实现分页查询
        Page<Contact> page1 = contactService.page(contactPage, wrapper);
        //getTotal返回表里的总记录数，getRecords返回当前页的数据列表
        return TableResult.ok("查询客户联系人成功！", page1.getTotal(), page1.getRecords());
    }

    /**
     * @param contact:前端传输过来的contact对象
     */
    @PostMapping("/addContact")//映射的地址与方法名没有关系
    public TableResult<Customer> addContact(Contact contact) {
        contactService.save(contact);
        return TableResult.ok("新增联系人信息成功！");
    }

    @PostMapping("/updateContact")
    public TableResult<Contact> updateCustomer(Contact contact) {
        contactService.updateById(contact);
        return TableResult.ok("修改联系人信息成功！");
    }

    @PostMapping("/deleteContact")//映射的地址与方法名没有关系
    public TableResult<Contact> deleteCustomer(Integer[] ids) {//参数名要和前端的ajax方法中的data参数里面的属性名字一致
        contactService.removeByIds(Arrays.asList(ids));//asList用于将数组转化为List
        return TableResult.ok("删除联系人信息成功！");
    }
}
