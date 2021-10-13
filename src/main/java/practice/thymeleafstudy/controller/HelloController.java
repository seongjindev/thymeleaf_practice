package practice.thymeleafstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practice.thymeleafstudy.domain.Member;
import practice.thymeleafstudy.repository.MemoryRepository;

import javax.annotation.PostConstruct;
import java.util.*;

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

    @GetMapping("/th-text")
    public String thText(Model model) {
        String text = "Hello<br>Spring";
        model.addAttribute("text", text);
        return "view/th-text";
    }

    @GetMapping("/th-map")
    public String thMap(Model model) {
        Map<String, Integer> score = new HashMap<>();
        score.put("userA", 100);
        score.put("userB", 90);
        score.put("userC", 50);
        model.addAttribute("score", score);
        return "view/th-map";
    }

    @GetMapping("/th-ast")
    public String thAst(Model model) {
        Member member = new Member(1, "kim", "contents_etc_11");
        model.addAttribute("member", member);
        return "view/th-ast";
    }

    @GetMapping("/th-ahref")
    public String thAHref(Model model) {
        String mem = "members";
        model.addAttribute("mem", mem);
        return "view/th-ahref";
    }

    @PostConstruct
    public void init() {
        Member member = new Member(1, "kim", "contents_etc_11");
        Member member2 = new Member(2, "lee", "contents_etc_22");
        memoryRepository.save(member);
        memoryRepository.save(member2);

    }

}
