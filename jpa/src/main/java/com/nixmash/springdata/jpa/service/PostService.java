package com.nixmash.springdata.jpa.service;

import com.nixmash.springdata.jpa.dto.PostDTO;
import com.nixmash.springdata.jpa.dto.TagDTO;
import com.nixmash.springdata.jpa.exceptions.DuplicatePostNameException;
import com.nixmash.springdata.jpa.exceptions.PostNotFoundException;
import com.nixmash.springdata.jpa.exceptions.TagNotFoundException;
import com.nixmash.springdata.jpa.model.Post;
import com.nixmash.springdata.jpa.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by daveburke on 6/1/16.
 */
public interface PostService {

    Post add(PostDTO postDTO) throws DuplicatePostNameException;

    Post getPost(String postName) throws PostNotFoundException;

    Page<Post> getPosts(Integer pageNumber, Integer pageSize);

    @Transactional
    Post update(PostDTO postDTO) throws PostNotFoundException;

    Post getPostById(Long postId) throws PostNotFoundException;

    @Transactional(readOnly = true)
    List<Post> getAllPosts();

    @Transactional(readOnly = true)
    List<Post> getPostsWithDetail();

    @Transactional(readOnly = true)
    Set<TagDTO> getTagDTOs();

    boolean canUpdatePost(Authentication authentication, Long postId);

    Set<TagDTO> getTagDTOs(Long postId);
    Tag getTag(String tagValue) throws TagNotFoundException;

    Page<Post> getPostsByTagId(long tagId, int pageNumber, int pageSize);
}
