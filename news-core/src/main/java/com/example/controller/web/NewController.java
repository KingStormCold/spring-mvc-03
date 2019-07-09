package com.example.controller.web;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.ICommentService;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "newControllerOfWeb")
public class NewController {

	@Autowired
	private INewService newService;

	@Autowired
	private ICommentService commentService;

	@RequestMapping(value = "/tin-tuc/{id}/{code}", method = RequestMethod.GET)
	public ModelAndView getNewByCategory(@ModelAttribute(SystemConstant.MODEL) NewDTO model, @PathVariable("id") long id,
																			 @PathVariable("code") String code) {
		ModelAndView mav = new ModelAndView("web/new/list");
		model.setCategoryId(id);
		model.setCategoryCode(code);
		model = newService.getNewByCategory(model);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/tin-tuc/{code}/{newsid}/{title}", method = RequestMethod.GET)
	public ModelAndView getNewsDetail(@ModelAttribute("model") NewDTO model,
                                      @PathVariable("newsid") long newsId) {
		ModelAndView mav = new ModelAndView("web/new/detail");
		model = newService.getNewDetail(newsId);
		mav.addObject("commentTrees", commentService.getAllCommentByNew(newsId));
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}
}
