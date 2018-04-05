package org.csf.controller;

import org.csf.dto.CostComputeDto;
import org.csf.service.AuthService;
import org.csf.service.CassetteService;
import org.csf.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

@Controller
@RequestMapping("/admin/rental")
public class RentalController extends AbstractController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private AuthService authService;

    @Autowired
    private CassetteService cassetteService;

    @GetMapping("/cost_compute")
    public String getCostComputePage(@RequestParam(value = "token", required = false) String token,
                                     Model model) {
        if (Objects.isNull(authService.getEmployeeByToken(token))) {
            return toLoginPage(model);
        }
        model.addAttribute("token", token);
        model.addAttribute("costComputeDto", new CostComputeDto());
        model.addAttribute("cassettes", cassetteService.getAllCassettes());
        return "admin/cost_compute";
    }

    @PostMapping("cost_compute")
    public String costCompute(@RequestParam(value = "token", required = false) String token,
                              CostComputeDto costComputeDto,
                              Model model) {
        if (Objects.isNull(authService.getEmployeeByToken(token))) {
            return toLoginPage(model);
        }
        model.addAttribute("cost", rentalService.costCompute(costComputeDto));
        return getCostComputePage(token, model);
    }

}
