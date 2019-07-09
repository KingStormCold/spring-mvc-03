package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.CommentDTO;
import com.example.service.ICommentService;
import com.example.utils.DisplayTagUtils;
import com.example.utils.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "commentControllerOfAdmin")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/admin/comments/{id}", method = RequestMethod.GET)
    public ModelAndView getBaseComment(@ModelAttribute(SystemConstant.MODEL) CommentDTO model,
                                       @PathVariable("id") long id,
                                       HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/comment/list");
        DisplayTagUtils.initSearchBean(request, model);
        List<CommentDTO> comments = commentService.getAllCommentByNew(id);
        model.setListResult(comments);
        initMessageResponse(mav, request);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = messageUtil.getMessageResponse(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }


}
