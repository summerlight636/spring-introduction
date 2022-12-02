package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class memberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);//ApplicationContext : 스프링의 DI컨테이너
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //p1: 메서드 이름, p2: 메서드의 반환 타입 (AppConfig의)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
