package pl.lcc.SumYt.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lcc.SumYt.ai.AiService;

@Controller
public class MainController {

    public MainController(AiService aiService) {
        System.out.println("MainController");
        this.aiService = aiService;
    }

    AiService aiService;

    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("hello");
        //System.out.println(aiService.getModel("llama-3.2-90b-text-preview"));
        model.addAttribute("message", aiService.getModel("llama-3.2-90b-text-preview"));
        return "thyme";
    }


    @GetMapping("/hellos")
    public String hellos(Model model) {
        System.out.println("helloS");
        //System.out.println(aiService.getModel("llama-3.2-90b-text-preview"));
        model.addAttribute("message", aiService.getModels());
        return "thyme";
    }
}