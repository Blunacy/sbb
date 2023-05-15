package com.lunacy.sbb;

import com.lunacy.sbb.question.Question;
import com.lunacy.sbb.question.QuestionRepository;
import com.lunacy.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {

  @Autowired
//  @Autowired : 객체를 주입하기 위해 사용하는 스프링의 애너테이션이다.
  private QuestionService questionService;

  @Test
  void testJpa() {
//    Question q1 = new Question();
//    q1.setSubject("sbb가 무엇인가요?");
//    q1.setContent("sbb에 대해서 알고 싶습니다.");
//    q1.setCreateDate(LocalDateTime.now());
//    this.questionRepository.save(q1); // 첫번째 질문 저장
//
//    Question q2 = new Question();
//    q2.setSubject("스프링부트 모델 질문입니다.");
//    q2.setContent("id는 자동으로 생성되나요?");
//    q2.setCreateDate(LocalDateTime.now());
//    this.questionRepository.save(q2); // 두번째 질문 저장

//    List<Question> all = this.questionRepository.findAll();
//    assertEquals(4, all.size());
//
//    Question q = all.get(0);
//    assertEquals("sbb가 무엇인가요?", q.getSubject());

//    Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//    assertEquals(2, q.getId());

//    Question q = this.questionRepository.findBySubjectAndContent(
//        "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//    assertEquals(1, q.getId());

//    List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//    Question q = qList.get(0);
//    assertEquals("sbb가 무엇인가요?", q.getSubject());

    for (int i = 1; i <= 300; i++) {
      String subject = String.format("테스트 데이터입니다:[%03d]", i);
      String content = "내용무";
      this.questionService.create(subject, content);
    }
  }

}
