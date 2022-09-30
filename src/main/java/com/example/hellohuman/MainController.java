package com.example.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @RequestMapping("")
    StringBuilder hello(@RequestParam(value = "fName", required = false) String fName, @RequestParam(value = "lName", required = false) String lName, @RequestParam(value = "times", required = false) String times) {
        String response = "Hi";
        if (fName != null) {
            response += " " + fName;
        }
        if (lName != null) {
            response += " " + lName;
        }
        if (fName == null && lName == null) {
            response += " Human";
        }
        StringBuilder sb = new StringBuilder(response);
        if (times != null) {
            try {
                int num = Integer.parseInt(times);
                for (int i = 1; i < num; i++) {
                    sb.append(" ").append(response);
                }
            } catch (NumberFormatException e) {
                return sb;
            }
        }
        return sb;
    }

}

