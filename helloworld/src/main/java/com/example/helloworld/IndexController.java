package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * Controller
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/helloworld")
public class IndexController {
    
    private final static String VIEW_NAME = "index";
    
    private final TestRepository repository;

    /**
     * 初期表示
     * @return view
     */
    @GetMapping("/")
    public String init(Model model) {
        String kamokuName = repository.select();
        model.addAttribute("kamokuName", kamokuName);
        return VIEW_NAME;
    }
}
