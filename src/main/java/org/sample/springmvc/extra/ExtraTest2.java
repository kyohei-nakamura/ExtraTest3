package org.sample.springmvc.extra;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class ExtraTest2 {
    @Resource
    UserInfoValidator validator;

    @RequestMapping(value={"/login", "/locale"}, method=RequestMethod.GET)
	public String execute(Model model) {
        if (!model.containsAttribute("userinfo")) {
            model.addAttribute("userinfo", new UserInfo());
        }
        return "login";
	}
    
    @RequestMapping(value="/validateUser", method=RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("userinfo") UserInfo userinfo, BindingResult bindingResult){
        validator.validate(userinfo, bindingResult);
        
        if(bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("login");
            mav.getModel().putAll(bindingResult.getModel());
            
            return mav;
        }

		return new ModelAndView("welcome");
	}
}