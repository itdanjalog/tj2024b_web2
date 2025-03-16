package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.config.JwtUtil;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    // 🔹 회원가입 (POST /member/signup)
    // /api/member/signup // { "mid" : "qwe" , "mpwd" : "1234" , "mname":"유재석"}
    @PostMapping("/signup")
    //public boolean signup(@RequestBody MemberDto memberDto) {
    public boolean signup( MemberDto memberDto) {
        return memberService.signup(memberDto);
    }

    // ============================================================================================== //

    // 🔹 로그인 (POST /member/login)
    // /api/member/login // { "mid" : "qwe" , "mpwd" : "1234" }
    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto , HttpServletRequest request) {
        MemberDto member = memberService.login(memberDto);
        if (member != null) {
            HttpSession session = request.getSession(); // 세션 생성
            session.setAttribute("loginUser", member); // 세션 저장
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    // http://localhost:8080/api/member/logout //
    public boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 삭제
            return true;
        }
        return false;
    }

    // 🔹 로그인 상태 확인//  마이페이지
    // http://localhost:8080/api/member/info //
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null) ? (MemberDto) session.getAttribute("loginUser") : null;
    }


    // ============================================================================================== //

    private final JwtUtil jwtUtil;
// ============================================================================================== //
    /*
    // 🔹 로그인 (POST /api/member/login) → JWT 반환
    @PostMapping("/login") // { "mid" : "user1" , "mpwd" : "password123" }
    public String login(@RequestBody LoginDto loginDto) {
        MemberDto member = memberService.login(loginDto);
        if (member != null) {
            String token = jwtUtil.generateToken(member.getMid()); // JWT 생성
            return token ;
        }
        return null;
    }

    // 🔹 로그인 상태 확인 (JWT 기반)
    @GetMapping("/status")
    public boolean checkLoginStatus(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // "Bearer " 제거
            return jwtUtil.validateToken(token);
        }
        return false;
    }
 */
    // ============================================================================================== //

}





















