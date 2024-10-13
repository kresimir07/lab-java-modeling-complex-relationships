import model.Chapter;
import model.Member;
import model.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import service.ChapterService;
import service.MemberService;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final ChapterService chapterService;
    private final MemberService memberService;


    public DataLoader(ChapterService chapterService, MemberService memberService) {
        this.chapterService = chapterService;
        this.memberService = memberService;
    }

    @Override
    public void run(String... args) throws Exception {

        Member member1 = new Member("Alice Smith", ZonedDateTime.now(), Status.ACTIVE);
        member1.setDateOfBirth(ZonedDateTime.from(LocalDate.of(1992,7,7)));




        Member member2 = new Member("Bob Johnson", ZonedDateTime.now(), Status.LAPSED);
        member2.setDateOfBirth(ZonedDateTime.from(LocalDate.of(1993,7,7)));


        Member member3 = new Member("Charlie Davis", ZonedDateTime.now(), Status.ACTIVE);
        member3.setDateOfBirth(ZonedDateTime.from(LocalDate.of(1994,7,7)));



        Chapter chapter1 = new Chapter("North Pole", "South Pole");


        chapter1.setPresident(member1);
        member1.setChapter(chapter1);
        member2.setChapter(chapter1);
        member3.setChapter(chapter1);
        chapter1.setMembers(Arrays.asList(member1, member2, member3));


        chapterService.saveOrUpdateChapter(chapter1);
        memberService.saveOrUpdateMember(member2);
        memberService.saveOrUpdateMember(member3);
    }
}
