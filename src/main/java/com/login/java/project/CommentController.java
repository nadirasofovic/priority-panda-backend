package com.login.java.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/task/{taskId}")
    public List<Comment> getCommentsByTaskId(@PathVariable Long taskId) {
        return commentService.getCommentsByTaskId(taskId);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
