package com.leyou.goods.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Service
public class GoodsHtmlService {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TemplateEngine engine;

public void createHtml(Long spuId){
    //初始化上下文
    Context context = new Context();
    //设置数据模型
    context.setVariables(this.goodsService.loadData(spuId));

    PrintWriter printWriter = null;

    try {
        //静态文件生成到服务器本地
        File file = new File("E:\\spring\\Spring Service and Linux\\nginx-1.14.0\\html\\item\\"+ spuId + ".html");
        printWriter = new PrintWriter(file);

        this.engine.process("item",context, printWriter);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }finally {
        if (printWriter !=null){
            printWriter.close();
        }
    }
}

    public void deleteHtml(Long id) {
        File file = new File("E:\\spring\\Spring Service and Linux\\nginx-1.14.0\\html\\item\\"+ id + ".html");
        file.deleteOnExit();
    }
}
