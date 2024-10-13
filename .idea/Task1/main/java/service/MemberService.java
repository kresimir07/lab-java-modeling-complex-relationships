package service;

import model.Member;
import org.springframework.stereotype.Service;
import repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Integer id) {
        return memberRepository.findById(id);
    }

    public Member saveOrUpdateMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMemberById(Integer id) {
        memberRepository.deleteById(id);
    }
}
