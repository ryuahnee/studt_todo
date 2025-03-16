<h1 align="center">Study Todo Application</h1>
<p align="center"><em>스프링 웹 마스터 과정 복습 프로젝트</em></p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-3.4.1-6DB33F?style=for-the-badge&logo=spring-boot" alt="Spring Boot 3.4.1"/>
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Gradle-8.5-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt="Gradle 8.5"/>
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white" alt="Thymeleaf"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Clean_Architecture-0095D5?style=flat-square&logo=clean-code&logoColor=white" alt="Clean Architecture"/>
  <img src="https://img.shields.io/badge/RESTful_API-0095D5?style=flat-square&logo=api&logoColor=white" alt="RESTful API"/>
  <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring-security&logoColor=white" alt="Spring Security"/>
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white" alt="Thymeleaf"/>
</p>

<hr>

## 🖥️ 애플리케이션 소개

<p>
Study Todo Application은 Spring Boot 기반의 할 일 관리 웹 애플리케이션으로, 클린 아키텍처 원칙을 적용하여 개발되었습니다. 사용자별 할 일 관리, 작업 상태 추적, CSV 형식 내보내기 등 핵심 기능을 구현했습니다. REST API를 통해 프론트엔드와 효율적으로 통신하며, 사용자 인증 및 권한 관리를 제공합니다. 실시간 접속자 수 모니터링 및 국제화(i18n) 기능을 지원합니다.
</p>

<p>
이 프로젝트는 '스프링 웹 마스터' 교육 과정에서 학습한 내용을 복습하고 실습하기 위해 작성되었습니다. Spring MVC의 핵심 개념과 RESTful API 설계, 클린 아키텍처, 스프링 시큐리티, 예외 처리 등 다양한 주제를 포괄적으로 다루며 실제 구현을 통해 이론을 실습하였습니다.
</p>

<hr>

## 🛠️ 사용 기술

<table>
  <tr>
    <td>언어</td>
    <td>Java(JDK 21), Spring Boot 3.4.1, JPA</td>
  </tr>
  <tr>
    <td>서버</td>
    <td>내장 Tomcat (Spring Boot)</td>
  </tr>
  <tr>
    <td>DB</td>
    <td>H2 Database</td>
  </tr>
  <tr>
    <td>빌드 도구</td>
    <td>Gradle 8.5</td>
  </tr>
  <tr>
    <td>API & Library</td>
    <td>Spring Data JPA, Spring MVC, Thymeleaf, Bean Validation</td>
  </tr>
</table>

<hr>

## 💡 주요 기능

<ul>
  <li>RESTful API 설계 및 구현</li>
  <li>클린 아키텍처 기반 계층형 구조</li>
  <li>예외 처리 및 오류 관리 시스템</li>
  <li>국제화(i18n) 지원을 위한 메시지 처리</li>
  <li>콘텐츠 협상을 통한 다양한 응답 형식 지원</li>
</ul>

<hr>

## ✏️ 애플리케이션 구조

<pre>
server/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── todoapp/
│   │   │       ├── core/                  # 핵심 도메인 로직
│   │   │       │   ├── foundation/        # 공통 유틸리티 및 기본 클래스
│   │   │       │   ├── shared/            # 공유 컴포넌트 및 식별자
│   │   │       │   ├── todo/              # 할 일 관련 도메인 모델 및 비즈니스 로직
│   │   │       │   │   ├── application/   # 유스케이스 인터페이스 및 구현체
│   │   │       │   │   └── domain/        # 도메인 모델, 저장소 인터페이스, 예외
│   │   │       │   └── user/              # 사용자 관련 도메인 모델 및 비즈니스 로직
│   │   │       ├── data/                  # 데이터 액세스 구현체
│   │   │       ├── security/              # 보안 관련 컴포넌트
│   │   │       ├── web/                   # 웹 인터페이스 컨트롤러 및 모델
│   │   │       │   ├── config/            # 웹 관련 구성
│   │   │       │   ├── model/             # 웹 계층 모델
│   │   │       │   └── support/           # 웹 지원 유틸리티
│   │   │       └── TodoApplication.java   # 애플리케이션 진입점
│   │   └── resources/
│   │       ├── static/                    # 정적 리소스
│   │       ├── templates/                 # Thymeleaf 템플릿
│   │       ├── messages.properties        # 기본 메시지
│   │       ├── messages_ko.properties     # 한국어 메시지
│   │       ├── messages_en.properties     # 영어 메시지
│   │       └── application.yml            # 애플리케이션 설정
│   └── test/                              # 테스트 코드
└── build.gradle                           # Gradle 빌드 스크립트
</pre>

<hr>

## ❕ 구현 기능 상세

<details>
  <summary><b>할 일 관리 API</b></summary>
  <ul>
    <li>할 일 목록 조회 (<code>GET /api/todos</code>)</li>
    <li>새로운 할 일 등록 (<code>POST /api/todos</code>)</li>
    <li>할 일 수정 및 완료 처리 (<code>PUT /api/todos/{id}</code>)</li>
    <li>할 일 삭제 (<code>DELETE /api/todos/{id}</code>)</li>
    <li>할 일 목록 CSV 형식으로 제공 (<code>GET /todos</code>, <code>Accept: text/csv</code>)</li>
  </ul>
</details>

<details>
  <summary><b>사용자 관리 기능</b></summary>
  <ul>
    <li>사용자 로그인 및 로그아웃 (<code>POST /login</code>, <code>/logout</code>)</li>
    <li>사용자 프로필 정보 조회 (<code>GET /api/user/profile</code>)</li>
    <li>프로필 이미지 업로드 및 변경 (<code>POST /api/user/profile-picture</code>)</li>
    <li>사용자별 할 일 관리 (개인화된 할 일 접근 제어)</li>
  </ul>
</details>

<details>
  <summary><b>확장 기능</b></summary>
  <ul>
    <li>기능 토글을 통한 선택적 기능 활성화 (<code>GET /api/feature-toggles</code>)</li>
    <li>실시간 접속 사용자 수 모니터링 (<code>GET /stream/online-users-counter</code>)</li>
    <li>다국어 메시지 처리 (i18n)</li>
    <li>예외 처리 및 사용자 친화적인 오류 응답 제공</li>
  </ul>
</details>

<details>
  <summary><b>기술적 구현</b></summary>
  <ul>
    <li>AOP를 활용한 횡단 관심사 분리 (로깅, 성능 모니터링)</li>
    <li>Server-Sent Events를 통한 실시간 데이터 전송</li>
    <li>콘텐츠 협상을 통한 다양한 응답 형식 지원 (JSON, CSV)</li>
    <li>JPA를 활용한 데이터 액세스 계층 구현</li>
  </ul>
</details>

<hr>

## 📚 학습 내용 및 핵심 개념

<details>
  <summary><b>Spring MVC 아키텍처</b></summary>
  <ul>
    <li>DispatcherServlet의 역할과 요청 처리 흐름</li>
    <li>HandlerMapping과 HandlerAdapter를 통한 요청-핸들러 연결</li>
    <li>ViewResolver와 View를 활용한 응답 렌더링</li>
  </ul>
</details>

<details>
  <summary><b>RESTful API 설계 및 구현</b></summary>
  <ul>
    <li>HTTP 메서드를 활용한 리소스 중심 API 설계</li>
    <li>적절한 HTTP 상태 코드 활용 및 오류 처리</li>
    <li>콘텐츠 협상을 통한 다양한 응답 형식 지원</li>
  </ul>
</details>

<details>
  <summary><b>클린 아키텍처 적용</b></summary>
  <ul>
    <li>계층 분리를 통한 관심사 명확화</li>
    <li>의존성 역전 원칙(DIP)을 통한 결합도 낮추기</li>
    <li>SOLID 원칙 기반 객체지향 설계</li>
  </ul>
</details>

<details>
  <summary><b>보안 및 인증</b></summary>
  <ul>
    <li>Spring Security를 활용한 사용자 인증 및 세션 관리</li>
    <li>역할 기반 접근 제어 구현</li>
    <li>리소스 소유자 기반 접근 제어</li>
  </ul>
</details>

<details>
  <summary><b>예외 처리 및 오류 관리</b></summary>
  <ul>
    <li>글로벌 예외 처리 시스템 구축</li>
    <li>다국어 지원 오류 메시지 제공</li>
    <li>일관된 오류 응답 형식 유지</li>
  </ul>
</details>

<details>
  <summary><b>테스트 및 품질 관리</b></summary>
  <ul>
    <li>JUnit을 활용한 단위 테스트 및 통합 테스트</li>
    <li>MockMVC를 활용한 컨트롤러 테스트</li>
    <li>테스트 커버리지 향상을 통한 품질 보장</li>
  </ul>
</details>

<hr>

## 🔍 주요 코드 구현

<details>
  <summary><b>클린 아키텍처 기반 계층 구조 설계</b></summary>
  
  ```java
  // 도메인 계층: 도메인 모델 및 비즈니스 규칙
  public class Todo {
      private TodoId id;
      private String text;
      private TodoState state;
      private UserId owner;
      private LocalDateTime createdDate;
      private LocalDateTime lastModifiedDate;

      public Todo edit(String text, boolean completed) {
          this.text = text;
          this.state = completed ? TodoState.COMPLETED : TodoState.ACTIVE;
          this.lastModifiedDate = LocalDateTime.now();
          return this;
      }
      
      // 중요: 소유자 검증 기능을 도메인 모델에 구현
      public Todo edit(String text, boolean completed, UserId owner) {
          if (!Objects.equals(owner, getOwner())) {
              throw new TodoOwnerMismatchException();
          }
          return edit(text, completed);
      }
  }

  // 애플리케이션 계층: 유스케이스 구현
  @Service
  @Transactional
  class DefaultTodoManager implements FindTodos, AddTodo, ModifyTodo, RemoveTodo {
      @Override
      public TodoId add(String text) {
          return todoRepository.save(Todo.create(text, todoIdGenerator)).getId();
      }

      @Override
      public void modify(TodoId id, String text, boolean completed) {
          byId(id).edit(text, completed);
      }
  }

  // 웹 계층: 컨트롤러 및 외부 요청 처리
  @RestController
  @RequestMapping("/api/todos")
  public class TodoRestController {
      @GetMapping
      public List<Todo> readAll() {
          return findTodos.all();
      }

      @PostMapping
      @ResponseStatus(HttpStatus.CREATED)
      public void create(@RequestBody @Valid WriteTodoCommand command) {
          addTodo.add(command.text());
      }
  }
  ```
</details>

<details>
  <summary><b>Spring Security 구성</b></summary>
  
  ```java
  @Configuration
  public class SecurityConfig {
      @Bean
      SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http
              .csrf().disable()
              .authorizeHttpRequests(auth -> auth
                  .requestMatchers("/api/user/**").authenticated()
                  .requestMatchers("/api/todos/**").authenticated()
                  .requestMatchers("/admin/**").hasRole("ADMIN")
                  .anyRequest().permitAll()
              )
              .formLogin(form -> form
                  .loginPage("/login")
                  .defaultSuccessUrl("/todos")
                  .permitAll()
              )
              .logout(logout -> logout
                  .logoutUrl("/logout")
                  .logoutSuccessUrl("/")
                  .invalidateHttpSession(true)
              );
          
          return http.build();
      }
  }
  ```
</details>

<details>
  <summary><b>콘텐츠 협상을 통한 다양한 응답 형식 지원</b></summary>
  
  ```java
  @Controller
  public class TodoController {
      private final FindTodos findTodos;

      public TodoController(FindTodos findTodos) {
          this.findTodos = Objects.requireNonNull(findTodos);
      }

      @RequestMapping("/todos")
      public void todos() {
          // Thymeleaf 템플릿 렌더링 (HTML 응답)
      }

      @RequestMapping(value = "/todos", produces = "text/csv")
      public void downloadTodos(Model model) {
          // CSV 형식 응답 제공
          model.addAttribute(SpreadsheetConverter.convert(findTodos.all()));
      }
  }
  ```
</details>
