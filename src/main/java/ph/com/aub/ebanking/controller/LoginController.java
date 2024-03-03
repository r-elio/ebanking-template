package ph.com.aub.ebanking.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/")
    public String index() {
        log.info("index");
        return "index";
    }

    @GetMapping("/dashboard/")
    public String dashboard() {
        log.info("dashboard");
        return "dashboard";
    }

    @GetMapping("/corporate/")
    public String corporate() {
        log.info("corporate");
        return "corporate/corporate";
    }

    @GetMapping("/personal/")
    public String personal() {
        log.info("personal");
        return "personal/personal";
    }

    @GetMapping("/logout")
    public String logout() {
        log.info("logout");
        return "redirect:/";
    }
}
