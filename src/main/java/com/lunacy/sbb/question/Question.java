package com.lunacy.sbb.question;

import com.lunacy.sbb.answer.Answer;
import com.lunacy.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
// @Data : @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정
@Entity
// @Entity : @Entity 애너테이션을 적용해야 JPA 가 엔티티로 인식
public class Question {
  @Id
//  @Id : id 속성을 기본 키로 지정한다. 기본 키로 지정하면 이제 id 속성의 값은 데이터베이스에 저장할 때 동일한 값으로 저장할 수 없다
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @GeneratedValue : 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장
  private Integer id;

  @Column(length = 200)
//  @Column : 엔티티의 속성은 테이블의 컬럼명과 일치하는데 컬럼의 세부 설정을 위해
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;

  @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
  private List<Answer> answerList;

  @ManyToOne
  private SiteUser author;

  private LocalDateTime modifyDate;

  @ManyToMany
  Set<SiteUser> voter;
}
