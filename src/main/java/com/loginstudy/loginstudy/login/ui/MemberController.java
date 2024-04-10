package com.loginstudy.loginstudy.login.ui;

import com.loginstudy.loginstudy.login.service.JoinService;
import com.loginstudy.loginstudy.login.ui.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/login")
public class MemberController {

    private final JoinService joinService;

    @GetMapping
    public String main() {
        return "main Controller";
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest request) {
        joinService.joinProcess(request.toEntity());
        return "ok";
    }

}
