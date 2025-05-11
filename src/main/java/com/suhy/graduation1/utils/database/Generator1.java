package com.suhy.graduation1.utils.database;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class Generator1 {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/web?serverTimezone=GMT%2b9",
                        "root",
                        "123456")
                .globalConfig(builder -> {
                    builder.author("suhy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("src/main/java/com/suhy/graduation1/test1"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.suhy.graduation1") // 设置父包名
                                .moduleName("entity") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "src/resources/mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("betting_content") // 设置需要生成的表名
                                .addTablePrefix() // 设置过滤表前缀
                )
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
