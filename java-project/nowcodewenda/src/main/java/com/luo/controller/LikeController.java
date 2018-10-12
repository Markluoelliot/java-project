package com.luo.controller;

import com.luo.async.EventModel;
import com.luo.async.EventProducer;
import com.luo.async.EventType;
import com.luo.model.Comment;
import com.luo.model.EntityType;
import com.luo.model.HostHolder;
import com.luo.service.CommentService;
import com.luo.service.LikeService;
import com.luo.service.MessageService;
import com.luo.util.WendaUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nowcoder on 2016/7/30.
 */
@Controller
public class LikeController {
    @Autowired
    LikeService likeService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    CommentService commentService;

    @Autowired
    EventProducer eventProducer;

    @RequestMapping(path = {"/like"})
    @ResponseBody
    public String like(@RequestParam("commentId") int commentId
    		        ) {
       if(hostHolder.getUser()==null) {
    	   return WendaUtil.getJSONString(999);
       }
       Comment comment = commentService.getCommentById(commentId);
       eventProducer.fireEvent(new EventModel(EventType.LIKE)
               .setActorId(hostHolder.getUser().getId()).setEntityId(commentId)
               .setEntityType(EntityType.ENTITY_COMMENT).setEntityOwnerId(comment.getUserId())
               .setExt("questionId", String.valueOf(comment.getEntityId())));
       long likeCount = likeService.like(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, commentId);
       return WendaUtil.getJSONString(0,String.valueOf(likeCount));
       //return "redirect:/question/"+qid;
    }

    @RequestMapping(path = {"/dislike"})
    //@ResponseBody
    public String dislike(@RequestParam("commentId") int commentId
    		) {
    	if(hostHolder.getUser()==null) {
     	   return WendaUtil.getJSONString(999);
     	   //return "login";
        }

        long likeCount = likeService.disLike(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, commentId);
        return WendaUtil.getJSONString(0, String.valueOf(likeCount));
        //return "redirect:/question/"+qid;
    }
}
