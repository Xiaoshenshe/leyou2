package com.leyousearch.Controller;

import com.leyou.item.pojo.Category;
import com.leyousearch.Service.SearchService;
import com.leyousearch.pojo.SearchRequest;
import com.leyousearch.pojo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;


@PostMapping("page")
public ResponseEntity<SearchResult> search(@RequestBody SearchRequest request){

    SearchResult result =this.searchService.search(request);
    if (result == null || CollectionUtils.isEmpty(result.getItems())){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(result);
}
}
