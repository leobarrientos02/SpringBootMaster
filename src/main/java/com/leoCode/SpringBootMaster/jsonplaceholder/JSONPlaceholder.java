package com.leoCode.SpringBootMaster.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "jsonplaceholder",
        url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceholder {
    @GetMapping("posts")
    List<Post> getPosts();

    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId") Integer postId);
}
/*
    OpenFeign, originally known as Feign and sponsored by Netflix,
    is designed to allow developers to use a declarative way to build
    HTTP clients by means of creating annotated interfaces without
    writing any boilerplate code.
 */