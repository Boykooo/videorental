package org.csf.controller;

import org.csf.dto.LoginData;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

public abstract class AbstractController {

    protected String toAccessDeniedPage() {
        return "access_denied";
    }

    protected String toWelcomePage() {
        return "welcome";
    }

    protected ModelAndView toErrorPage(String ex) {
        HashMap<String, String> model = new HashMap<String, String>();
        model.put("exceptionMessage", ex);
        return  new ModelAndView("exception", model);
    }

    protected String toLoginPage(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "admin/login";
    }

}
