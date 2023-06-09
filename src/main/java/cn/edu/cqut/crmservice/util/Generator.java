package cn.edu.cqut.crmservice.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/crmdb?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai", "root", "xy478888").globalConfig(builder -> {
            builder.author("Haibara") // 设置作者
                    .outputDir("C:\\Users\\XY.DESKTOP-3N53OPF\\Desktop\\实训作业\\CRMSpingBootService\\src\\main\\java"); // 指定输出目录
        }).packageConfig(builder -> {
            builder.parent("cn.edu.cqut.crmservice"); // 设置父包名
        }).strategyConfig(builder -> {
            builder.addInclude("customer_loss"); // 设置需要生成的表名
        }).execute();
    }
}
