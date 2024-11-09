# 🗒️ 프로젝트 소개

자바 기초를 공부한 후 자바를 더 능숙하게 다루고 싶어 제작한 스프링 부프 프로젝트 입니다<br><br>
해당하는 입문서에서는 데이터베이스를 H2를 사용하였지만 좀 더 규모있는 MySQL로 채택하여 사용하였습니다<br><br>
또한, 엔티티를 만들 때에는 @Setter 메서드를 사용하지 않기를 권장하기에 @Builder를 사용하여 생성자에 의해서만 엔티티의 값을 저장할 수 있게 하였습니다<br><br>데이터를 변경해야 할 경우에는 create와 modify 메서드를 추가로 작성하여 builder()와 toBuilder()을 사용하여 변경하였습니다<br><br><br>
Dockerfile 및 docker-compose.yml 파일을 활용하여 database, springboot-app 컨테이너를 동작시켜 하나의 네트워크에서 서버를 실행시켰습니다

ORM과 JPA를 사용하여 데이터베이스를 관리하였습니다
JPA를 설정하기 위하여 application.yml 파일을 작성하였습니다
# ⚙️ 기술 스택
# 💻 동작화면

# DB

# 🛠️ UML

# 참고 자료
점프 투 스프링부트<br>
지은이: 박응용<br>
[https://wikidocs.net/161165](https://wikidocs.net/book/7601)<br><br>
"점프 투 스프링부트"는 Spring Boot Board(SBB)"라는 이름의 게시판 서비스를 만들어가는 과정을 설명한 스프링부트 입문서입니다<br><br>
자바 설치부터 서비스 운영까지 웹 프로그래밍의 처음부터 끝까지 모든 것을 알 수 있도록 구성하였습니다
