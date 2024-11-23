package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller
 */
@Controller
@RequestMapping("/helloworld")
public class IndexController {
    
    /** 画面名 */
    private final static String VIEW_NAME = "index";

    /**
     * 初期表示
     * @return view
     */
    @GetMapping("/")
    public String init() {
        return VIEW_NAME;
    }
}
