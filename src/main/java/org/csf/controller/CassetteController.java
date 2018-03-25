package org.csf.controller;

import org.csf.domain.Cassette;
import org.csf.service.AuthService;
import org.csf.service.CassetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

@Controller
public class CassetteController extends AbstractController {

    @Autowired
    private CassetteService cassetteService;

    @Autowired
    private AuthService authService;

    @GetMapping("/cassette")
    public String getCassettes(Model model) {
        model.addAttribute("cassettes", cassetteService.getAllCassettes());
        return "cassettes";
    }

    @GetMapping("/admin/cassette")
    public String getAdminCassettePage(@RequestParam(value = "token", required = false) String token,
                                       Model model) {
        if (Objects.isNull(authService.getEmployeeByToken(token))) {
            return toLoginPage(model);
        }

        model.addAttribute("cassettes", cassetteService.getAllCassettes());
        model.addAttribute("cassette", new Cassette());
        model.addAttribute("token", token);
        return "admin/cassette";
    }

    @PostMapping("/admin/cassette")
    public String newCassette(@RequestParam(value = "token", required = false) String token,
                              Cassette cassette,
                              Model model) {
        if (Objects.isNull(authService.getEmployeeByToken(token))) {
            return toLoginPage(model);
        }

        cassetteService.createOrUpdate(cassette);
        return getAdminCassettePage(token, model);
    }

    @DeleteMapping("/admin/cassette/{id}")
    public String deleteCassette(@RequestParam(value = "token", required = false) String token,
                                 @PathVariable("id") Long id,
                                 Model model) {
        if (Objects.isNull(authService.getEmployeeByToken(token))) {
            return toLoginPage(model);
        }

        cassetteService.delete(id);
        return getAdminCassettePage(token, model);
    }

}
