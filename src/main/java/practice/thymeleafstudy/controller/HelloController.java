package practice.thymeleafstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practice.thymeleafstudy.domain.Member;
import practice.thymeleafstudy.repository.MemoryRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
public class HelloController {

    private final MemoryRepository memoryRepository;

    public HelloController(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memoryRepository.findAll();
        model.addAttribute("members", members);
        return "view/members";
    }

    @PostConstruct
    public void init() {
        Member member = new Member(1, "kim", "contents_etc_11");
        Member member2 = new Member(2, "lee", "contents_etc_22");
        memoryRepository.save(member);
        memoryRepository.save(member2);

    }

}
