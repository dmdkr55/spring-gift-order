package gift.controller;

import gift.dto.RegisterRequest;
import gift.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/members")

public class MemeberAdminController {

    private MemberService memberService;

    public MemeberAdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String showMemberList(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "member/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model,
        @RequestParam(name = "kakaoId", defaultValue = "-1") Long kakaoId) {
        RegisterRequest request = new RegisterRequest();
        request.setKakaoId(kakaoId);
        model.addAttribute("registerRequest", request);
        return "member/create-form";
    }

    @PostMapping("/new")
    public String addMember(@Valid @ModelAttribute RegisterRequest request,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("!!!!!!Validation Errors:");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(
                    " - " + error.getObjectName() + ": " + error.getDefaultMessage());
            });
            model.addAttribute("registerRequest", request);
            return "member/create-form";
        }

        memberService.save(request);
        return "redirect:/admin/members";
    }

}
