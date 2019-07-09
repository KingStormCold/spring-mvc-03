package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.utils.DisplayTagUtils;
import com.example.utils.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "newControllerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) NewDTO model,
								HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/list");
		DisplayTagUtils.initSearchBean(request, model);
		Pageable pageable = new PageRequest(model.getPage() - 1, model.getMaxPageItems());
		List<NewDTO> news = newService.getNews(model.getSearchValue(), pageable);
		model.setListResult(news);
		model.setTotalItems(newService.getTotalItems(model.getSearchValue()));
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}

	@RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
	public ModelAndView editNewsPage() {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		NewDTO news = new NewDTO();
		news.setCategories(categoryService.getCategories());
		mav.addObject(SystemConstant.MODEL, news);
		return mav;
	}

	@RequestMapping(value = "/admin/new/{id}", method = RequestMethod.GET)
	public ModelAndView getNewById(@PathVariable("id") long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		initMessageResponse(mav, request);
		mav.addObject(SystemConstant.MODEL, newService.findNewById(id));
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
