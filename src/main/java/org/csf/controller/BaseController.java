package org.csf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Controller
@RequestMapping("/")
public class BaseController extends AbstractController {

    @GetMapping
    public String welcome() {
        return toWelcomePage();
    }

}
