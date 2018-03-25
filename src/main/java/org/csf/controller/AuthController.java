package org.csf.controller;

import org.csf.domain.Employee;
import org.csf.dto.LoginData;
import org.csf.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Controller
@RequestMapping(value = "/auth")
public class AuthController extends AbstractController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginData loginData, Model model) {
        Employee employee = authService.login(loginData);
        if (employee == null) {
            model.addAttribute("exceptionMessage", "Сотрудник с такой парой логин/пароль не найден.");
            return toLoginPage(model);
        }

        return "redirect:/admin/cassette?token=" + employee.getToken();
    }

}
