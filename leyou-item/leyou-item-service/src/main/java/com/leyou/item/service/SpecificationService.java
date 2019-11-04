package com.leyou.item.service;

import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationService {
        @Autowired
        private SpecGroupMapper groupMapper;

        @Autowired
        private SpecParamMapper specParamMapper;
        /**
         * 根据分类id查询分组
         * @param cid
         * @return
         */
public List<SpecGroup> queryGroupsByCid(Long cid) {
            SpecGroup specGroup = new SpecGroup();
            specGroup.setCid(cid);
            return this.groupMapper.select(specGroup);
        }

    /**
     * 跟俊gid查询规格参数
     * @param gid
     * @param cid
     * @param generic
     * @param searching
     * @return
     */
    public List<SpecParam> queryParam(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.specParamMapper.select(record);
    }

    public List<SpecGroup> queryGroupWithParam(Long cid) {
        List<SpecGroup> groups = this.queryGroupsByCid(cid);
        groups.forEach(group ->{
            List<SpecParam> params = this.queryParam(group.getId(), null, null, null);
            group.setParams(params);
        });
        return groups;
    }
}
