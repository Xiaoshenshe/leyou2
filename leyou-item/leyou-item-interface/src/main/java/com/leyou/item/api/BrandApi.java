package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("brand")
public interface BrandApi {
    /**
     * 根据ID查询品牌
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Brand queryBrandById(@PathVariable("id")Long id);

    /**
     * 根据ids查询list
     * @param ids
     * @return
     */
    @GetMapping("list")
    List<Brand> queryBrandByIds(@RequestParam("ids")List<Long> ids);

}
