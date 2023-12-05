package java.com.example.contoller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.com.example.model.Employee;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String showView() {
        return "first-view";
    }

    @RequestMapping("/details")
    public String getDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "details";
    }

    @RequestMapping("info")
    public String showDetails(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors())
            return "details";
        return "show_info";
    }
}
