package com.kingloo.springpractice.controller;

import com.kingloo.springpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;

/*    DI, Setter Injection
      @Autowired
      public void setMemberService(MemberService memberService) {
      this.memberService = memberService;
      }
*/

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
