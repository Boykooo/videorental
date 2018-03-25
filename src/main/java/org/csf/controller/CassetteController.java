package org.csf.controller;

import org.csf.domain.Cassette;
import org.csf.service.CassetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Controller
@RequestMapping("/cassette")
public class CassetteController {

    @Autowired
    private CassetteService cassetteService;

    @GetMapping
    public String getCassettes(Model model) {
//        List<Cassette> cassettes = cassetteService.getAllCassettes();
//        model.addAttribute(cassettes);

        return "cassettes";
    }

}
